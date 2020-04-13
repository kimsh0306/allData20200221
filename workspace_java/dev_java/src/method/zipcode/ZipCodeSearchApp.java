package method.zipcode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.util.DBConnectionMgr;

import oracle.jdbc2.JDBCTest;
import oracle.jdbc2.ZipCodeVO;
//implements 뒤에 오는 이름 모두 인터페이스
//인터페이스는 추상메소드만 가지고 있다. 메소드 뒤에 세미콜론으로 끝남.
//void(int) methodA(); -> 추상메소드 
//인터페이스는 단독으로 인스턴스화를 할 수 없다.
//ItemListener item = new ItemListener(); -> 불법
//ItemListener item = new ZipCodeSearchApp2(); -> 합법
//인터페이스는 반드시 구현체 클래스가 있어야 한다.
//구현체 클래스가 되기 위한 필요조건은 반드시 추상메소드를 구현해주어야 한다. = @Override
public class ZipCodeSearchApp implements ItemListener, ActionListener, FocusListener {
/* 모든 클래스에 메인메소드가 잇다면 이 메소드는 시작점이다.
 * 이것보다 먼저 초기화 되는 코드들이 있다.
 */
	String zdos[] = null;
	//사용자가 콤보박스에서 선택한 정보를 담을 변수 선언
	//선택은 이벤트 쪽에서 처리되므로 전역변수로 해야 그 값을 유지할 수 있고
	//또 조회 메소드에서 그 값을 사용할 수 있을 것이다.
	String zdo = null;
	JComboBox jcb_zdo = null;
	//JComboBox jcb_zdo = new JComboBox(zdos);
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//선언부-전역변수는 초기화를 생성자가 해준다.
	Connection			con = null; //전역변수 선언하기 - 클래스() 안에서는 사용가능 함.
	PreparedStatement	pstmt = null; //오라클서버에 쿼리문을 전달하고 너가 좀 처리해줄래?
	/* 오라클에는 일꾼이 살고있는데 이름은 '옵티마이저'라고 함.
	 * 데이터를 찾을때는 커서를 움직이면서 조회결과가 존재하는지 확인하고 그 로우에있는 값들을
	 * RAM메모리 영역에 올린다. 커서를 조작하면서 해당 로우에 있는 값을 꺼낼수 있다. */
	ResultSet 			rs 			= null;
	JTextField 			jtf_dong 	= new JTextField("동 이름을 입력하세요.");//검색상자ㅁㅁ.
	JButton 			jbtn_search = new JButton("조회");
	JButton				jbtn_del	= new JButton("삭제");
	//테이블의 헤더 설정하기
	String 				cols[]		= {"주소","우편번호"};
	String				data[][]	= new String[0][2];
	DefaultTableModel 	dtm_zip 	= new DefaultTableModel(data, cols);
	/* DefaultTableModel : 오라클에서 조회한 결과를 담을 클래스 선언 및 생성하기
	 * 생성자에는 파라미터를 가질수 있다.
	 * 첫번째 파라미터는 데이터영역을 표시하는 주소번지
	 * 두번째 파라미터는 테이블 헤더영역에 해당하는 주소번지
	 * 파라미터의 갯수에 따라서 서로 다른 생성자를 선언하는것도 가능하다는 것인가? */
	JTable 			jt_zip 		= new JTable(dtm_zip); 		//테이블 양식 그려줌
	JScrollPane 	jsp_zip 	= new JScrollPane(jt_zip);
	//JTableHeader 
	JTableHeader 	jth_zip 	= new JTableHeader();
	JFrame			jf_zip 		= new JFrame(); //운영체재 위에 창을 띄운다.
	JPanel 			jp_north 	= new JPanel(); //속지를 만들어 주는 클래스
	//생성자 - 리턴타입이 없다. 클래스이름과 동일하다
	public ZipCodeSearchApp() {
		zdos = getZDOList();
		jcb_zdo = new JComboBox(zdos);
		/* 인스턴스화를 할 때 마다 생성자도 같은 횟수 만큼 호출이 일어난다.
		 * new A()같이 했을 때 객체가 RAM에 로딩(상주:기억)되면서 동시에 생성자가 호출됨. */
		System.out.println("나는 파라미터가 없는 디폴트 생성자라고 해.");
		System.out.println("나는 인스턴스화 하면 자동으로 호출되는거야");
	}
	public ZipCodeSearchApp(String str, int i) {	
	}
	//새로고침 기능을 구현해보자 - SELECT
	public void refreshData(String zDO, String myDong) {
		System.out.println("refreshData호출 성공"+myDong);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT address, zipcode");
		sql.append(" FROM zipcode_t");
		sql.append(" WHERE 1=1");
		if(zDO!=null && zDO.length()>0) {
			sql.append(" And zdo=?");//참이면 AND 붙인다			
		}
		if(myDong!=null || myDong.length()>0) {
			sql.append(" AND dong LIKE '%'||?||'%'");
		}
		int i=1;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());//타입이 String이어야 하는데 현재 StringBuilder라서 toString으로 맞춰주자.
			if(zDO!=null || zDO.length()>0) {
				pstmt.setString(i++, zDO);			
			}
			if(myDong!=null || myDong.length()>0) {
				pstmt.setString(i++, myDong);//?들어갈 동이름이 결정됨.
			}
			rs = pstmt.executeQuery(); //오라클 서버에게 처리를 요청함.
			Vector<ZipCodeVO> v = new Vector<>();
			ZipCodeVO zcVOS[] = null;
			ZipCodeVO zcVO = null;
			while(rs.next()) { //현재 커서 위치에 입력할 데이터가 있습니까?
				//System.out.println("while문 :"+ rs.next());
				zcVO = new ZipCodeVO();
				zcVO.setAddress(rs.getString("address"));
				zcVO.setZipcode(rs.getInt("zipcode"));
				v.add(zcVO);	
			}
			zcVOS = new ZipCodeVO[v.size()];
			v.copyInto(zcVOS); //벡터 자료구조에 들어있는 정보를 복사하기	
			System.out.println("v.size():"+v.size()+", "+zcVOS.length);
			if(v.size()>0) { //조회된 결과가 있니?
				while(dtm_zip.getRowCount() > 0) {
					dtm_zip.removeRow(0);
				}
			//조회결과가 있다면 데이터를 DefaultTableModel에 담아 주어야 합니다.
			//그래야 JTable에서 그리드에 출력된 결과를 볼 수 있기 때문입니다.
			//그런데 컬럼을 하나씩 각각 개발자가 일일이 초기화 해주는 건 너무 불편합니다.
				for(int x=0; x<v.size(); x++) {
			//그래서 for문 안에서 백터를 하나 더 생성했어요 
			//addRow라는 메소드가 있는데 이 파라미터에 Vector를 넣으면 한 개 로우씩
			//추가 해준다고 합니다.
					Vector oneRow = new Vector();
					oneRow.add(0, zcVOS[x].getAddress());
					oneRow.add(1, zcVOS[x].getZipcode());
					dtm_zip.addRow(oneRow);
				}
			}
		} catch (SQLException se) {
			//테이블이 존재하지 않습니다. - 테이블을 만들지 않았네
			//혹은 부적합한 식별자 - 컬럼명이 맞지 않습니다.
			System.out.println("[[query]]"+sql);
		} catch (Exception e) { //그 밖에 문제가 발생할 경우 잡아준다.
			System.out.println("[[Exception]]"+e);
		}
	}
	//화면그리기
	public void initDisPlay() {
		jcb_zdo.addItemListener(this);
		jtf_dong.addFocusListener(this);
		System.out.println("initDisPlay 호출성공");
		//테이블 헤더 영역에 배경색 바꿔볼까?
		jth_zip = jt_zip.getTableHeader();
		jth_zip.setBackground(new Color(0,100,0));
		jth_zip.setForeground(Color.white);
		jth_zip.setFont(new Font("맑은 고딕",Font.BOLD,20));
		jt_zip.setGridColor(Color.black);
		//그리드의 높이 변경하기
		jt_zip.setRowHeight(20);
		//컬럼의 너비 조정하기
		jt_zip.getColumnModel().getColumn(0).setPreferredWidth(350);
		//선택한 로우의 배경색이나 글자색 변경하기
		jt_zip.setSelectionBackground(new Color(0,255,0));
		//이벤트가 일어난 소스와 이벤트를 처리하는 클래스(actionPerFormed메소드)를 연결해준다.
		//jp_north속지에는 중앙에 jtf_dong을 붙이고 동쪽에는 jbtn_searth를 붙인다.
		//이렇게 동,서,남,북,중앙에 버튼을 배치하고 싶으면 BorderLayout사용함.
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.setBackground(Color.red);
		jp_north.add(jcb_zdo);
		jp_north.add(jtf_dong);
		jp_north.add(jbtn_search);
		jp_north.add(jbtn_del);
		jbtn_search.addActionListener(this);
		jbtn_del.addActionListener(this);
		jtf_dong.addActionListener(this);
		
		jf_zip.setTitle("우편번호 검색"); 	//타이틀 설정
		//JFrame판넬 위에 북쪽에 jp_north속지를 붙이자
		//속지안에 버튼과 텍스트 필드가 붙어있으니까 같이 따라온다.
		jf_zip.add("North", jp_north);
		jf_zip.add("Center", jsp_zip);
		jf_zip.setSize(600, 500);		//화면 크기 픽셀
		jf_zip.setVisible(true);		//화면 활성화
	}
	//콤보박스에 뿌려질 zdo 컬럼의 정보를 오라클 서버에서 꺼내오기
	public String[] getZDOList() {
		//리턴타입을 1차배열로 했으므로 1차배열 선언하기
		String zdos[] = null;
		//오라클서버에게 보낼 select문 작성하기
		//String은 원본이 바뀌지 않음.
		StringBuilder sb = new StringBuilder();
		//자바코드는 이클립스에서 디버깅하고 SELECT문은 토드에서 디버깅하기
		sb.append("SELECT               ");
		sb.append("       distinct(zdo) ");
		sb.append("  FROM zipcode_t     ");
		sb.append(" ORDER BY zdo asc    ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<String>();
			while(rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
			zdos = new String[v.size()];
			v.copyInto(zdos);
		} catch (Exception e) {
			//stack영역에 관리되는 에러메시지 정보를 라인번호와 이력까지 출력해줌
			e.printStackTrace();
		}
		return zdos;
	}
	//메인메소드		
	public static void main(String[] args) {
		ZipCodeSearchApp zipApp = new ZipCodeSearchApp();
		zipApp.initDisPlay();
	}//end of main
	@Override
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 감지된 버튼의 주소번지를 읽어오는 메소드임.
		Object obj = ae.getSource();
		if((obj==jbtn_search)||(obj==jtf_dong)) {
			String myDong = jtf_dong.getText();
			//자바에서는 같은이름의 메소드를 정의 할 수있다.
			//단, 파라미터의 갯수가 다르거나 파라미터 타입이 반드시 달라야 한다.
			refreshData(zdo,myDong);
		}
		else if(obj == jbtn_del) {
			int index[] = jt_zip.getSelectedRows();
			for(int row:index) {
				JOptionPane.showInputDialog(jf_zip, row);
			}
		}
	}//end of action	
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == jtf_dong) {
			jtf_dong.setText("");
		}
	}
	@Override
	public void focusLost(FocusEvent e) {
		
	}
	@Override
	public void itemStateChanged(ItemEvent ie) {
		Object obj = ie.getSource();
		if(obj == jcb_zdo) {
			if(ie.getStateChange()==ItemEvent.SELECTED) {
				zdo=zdos[jcb_zdo.getSelectedIndex()];
			}
		}
	}
}//////end of class