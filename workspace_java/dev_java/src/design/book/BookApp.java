package design.book;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;

import javafx.scene.image.Image;

public class BookApp extends JFrame implements ActionListener {
	//선언부
	//DB커넥션 연결하기
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//이미지 경로 추가
	String imgPath = "src\\design\\book\\";
	URL bookURL = getClass().getResource("imgBook.png");
	ImageIcon bicon = new ImageIcon(bookURL);
	//메뉴바 추가하기
	JMenuBar	jmb_book	= new JMenuBar();
	JMenu		jm_file		= new JMenu("File");
	////상단 메뉴
	JMenuItem	jmi_db		= new JMenuItem("DB 연결");
	JMenuItem	jmi_open	= new JMenuItem("Open File");
	JSeparator	js_file		= new JSeparator();
	JMenuItem	jmi_exit	= new JMenuItem("Exit");
	JMenu		jm_edit		= new JMenu("Edit");
	////메소드 중심의 코딩하기***
	JMenuItem	jmi_all		= new JMenuItem("전체조회");
	JMenuItem	jmi_sel		= new JMenuItem("상세조회",new ImageIcon(imgPath+"detail.gif"));
	JMenuItem	jmi_ins		= new JMenuItem("입력",new ImageIcon(imgPath+"new.gif"));
	JMenuItem	jmi_upd		= new JMenuItem("수정",new ImageIcon(imgPath+"update.gif"));
	JMenuItem	jmi_del		= new JMenuItem("삭제",new ImageIcon(imgPath+"delete.gif"));
	
	static BookApp ba = null;
	//조립 전 부품을 준비한다.
	//파라미터가 없는 생성자는 디폴트로 지원해주지만 있는 경우에는 예측불가이므로 지원불가함.
	BookDialog bd = new BookDialog();
	//jp_north 속지는 JFrame의 북쪽에 배치
	JPanel jp_north = new JPanel();
	//아래 버튼은 jp_north 속지에 차례대로 배치 - 배치는 왼쪽부터 
	JToolBar jtbar 	 = new JToolBar();
	JButton jbtn_db	 = new JButton("DB연결");
	JButton jbtn_all = new JButton("전체조회");
	JButton jbtn_sel = new JButton();
	JButton jbtn_ins = new JButton();
	JButton jbtn_upd = new JButton();
	JButton jbtn_del = new JButton();
	JLabel jlb_time  = new JLabel("현재시간",JLabel.CENTER);
	TimeClient tc 	 = null;
	
	//테이블 추가 - 복사 붙여넣기로 사용////////////////////////////////////////////
	String cols[] = {"도서번호","도서명","저자","출판사"};
	String data[][] = new String[0][4];
	DefaultTableModel dtm_book = new DefaultTableModel(data,cols);
	JTable jtb_book = new JTable(dtm_book);
	JScrollPane jsp_book = new JScrollPane(jtb_book);
	///////////////////////////////////////////////////////////////////////
	
	BookController bCtrl = new BookController();	//센터에 넣어 주면 된다.
	
	//이벤트 소스와 이벤트 핸들러 클래스 연결하기
	public void eventMapping() {
		//db연결 버튼 이벤트 처리
		jbtn_db.addActionListener(new ActionListener() {//this대신 직접 인스턴스화
			//함수가 아니라 클래스다.
			@Override
			public void actionPerformed(ActionEvent ae) {
				dbActionPerformed(ae);
			}
		});
		//함수 (중심) 지향적인 파이썬 같은 패턴...
		//db연결 메뉴 이벤트 처리
		jmi_db.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				dbActionPerformed(ae);
			}
		});
		jmi_all.addActionListener(this);
		jbtn_all.addActionListener(this);
	}
	
	protected void dbActionPerformed(ActionEvent ae) {
		System.out.println("db연결 테스트");
		//연결 확인
		Connection con = null;
		con = dbMgr.getConnection();
		//con에 대한 정보를 확인 => null이 아니면 연결됐다.
		System.out.println(con.toString());
	}

	//화면 그리기
	public void initDisplay() {
		////상단 메뉴바 붙이기.
		jm_file.setMnemonic('F');
		jm_edit.setMnemonic('E');
		
		jm_file.add(jmi_db);
		jm_file.add(jmi_open);
		jm_file.add(jmi_exit);
		jmb_book.add(jm_file);
		jmb_book.add(jm_edit);
		
		jm_edit.add(jmi_all);
		jm_edit.add(jmi_sel);
		jm_edit.add(jmi_ins);
		jm_edit.add(jmi_upd);
		jm_edit.add(jmi_del);
		
		this.setJMenuBar(jmb_book);
		////JVM, 버튼 누르는 것을 감지해라.
		////버튼 다섯 개에 대해서 이벤트 처리를 연결해 주는 코드.
		//실제로 타임서버로부터 시간정보 듣기는 TimeClient에서 진행되지만
		//생성자의 파라미터를 통해서 BookApp jlb_time 원본의 주소번지를
		//넘겼으므로 TimeClient에서는 원본에 직접 써주면 화면에 보임.
		//tc=new TimeClient(jlb_time);
		//tc.start();
		//아래코드가 JFrame의 자원을 회수함.
		//부모자원이 회수될 때 JDialog도 같이 회수됨.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbtn_ins.addActionListener(this);
		jbtn_sel.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		jbtn_all.addActionListener(this);
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		//insert here
		//준비한 것을 조립한다.
		this.setTitle("도서관리시스템");
		////마우스 오버 => 풍선 도움말
		jbtn_sel.setToolTipText("상세조회");
		jbtn_ins.setToolTipText("입력");
		jbtn_upd.setToolTipText("수정");
		jbtn_del.setToolTipText("삭제");
		jbtn_sel.setIcon(new ImageIcon(imgPath+"detail.gif"));
		jbtn_ins.setIcon(new ImageIcon(imgPath+"new.gif"));
		jbtn_upd.setIcon(new ImageIcon(imgPath+"update.gif"));
		jbtn_del.setIcon(new ImageIcon(imgPath+"delete.gif"));
		jtbar.add(jbtn_db);
		jtbar.add(jbtn_all);
		jtbar.add(jbtn_sel);
		jtbar.add(jbtn_ins);
		jtbar.add(jbtn_upd);
		jtbar.add(jbtn_del);
		this.add("North", jtbar);
		this.add("Center",jsp_book);
		this.add("South", jlb_time);
		this.setSize(700, 500);
		this.setIconImage(bicon.getImage());
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		TimeServer ts = new TimeServer();
		ts.initDisplay();//화면을 그리고 난 뒤 스레드 대기를 타도록 해야 함.
		Thread th = new Thread(ts);
		th.start();//스레드의 run메소드를 호출하는 메소드
		//insert here
		ba = new BookApp();
		ba.initDisplay();
		ba.eventMapping();
	}

	//JButton에 대한 이벤트를 지원하는 인터페이스가 ActionListener임.
	//클래스 뒤에 implements 할 것.
	//ActionListener에 정의된 추상메소드를 재정의 할 것.
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 감지된 클래스의 주소번지 받기
		Object obj = e.getSource();
		//입력버튼을 누른거니?
		if(jbtn_ins==obj) {
			System.out.println("입력호출 성공");
			//insert here
			bd.set("입력",true,true,null,ba);
			//initDisplay를 호출한 이유는 setTitle("입력")과 setVisible(true)
			//때문이었다. 그런데 그 둘을 set 메소드로 이전하였다.
		}
		else if(jbtn_upd==obj) {	//수정 시에는 먼저 기본 정보를 조회하고 화면 이동
			//insert here
			//select 처리한 후 한 개 로우를 받아서 Map에 저장
			System.out.println("수정 호출 성공");
			Map<String, Object> rMap = null;
			rMap = new HashMap<>();
			rMap.put("b_title", "자바의 정석");
			bd.set(jbtn_upd.getText(),true,true,rMap,ba);
		}
		else if(jbtn_sel==obj) {
			System.out.println("상세조회 호출 성공");
			//insert here
			Map<String, Object> rMap = null;
			//bd.set(jbtn_sel.getText(),true,false,rMap,null);
			int indexs[] = jtb_book.getSelectedRows();
			if(indexs.length==0) {
				JOptionPane.showMessageDialog
				(this, "상세조회 할 로우를 선택하세요.");
				return;
			}
			else {
				int b_no = Integer.parseInt(dtm_book.getValueAt(indexs[0], 0).toString());			
				System.out.println("b_no : "+b_no);//2
				BookVO pbVO = new BookVO();
				pbVO.setB_no(b_no);
				BookVO rbVO = bCtrl.send(pbVO);
			}
		}
		else if(jbtn_del==obj) {
			System.out.println("삭제 호출 성공");
		}
		else if(jbtn_all==obj) {
			System.out.println("전체조회 호출 성공");
			refreshData();
		}
	}
	public void refreshData() {
		System.out.println("refreshData 호출 성공");
		List<BookVO> bookList = null;
		BookVO pbVO = new BookVO();
		pbVO.setCommand("all");
		bookList = bCtrl.sendAll(pbVO);
		
		while(dtm_book.getRowCount()>0) {
			dtm_book.removeRow(0);
		}
		for(int i=0 ; i<bookList.size() ; i++) {
			BookVO bVO = bookList.get(i);
			Vector<Object> v = new Vector<>();
			v.add(bVO.getB_no());
			v.add(bVO.getB_name());
			v.add(bVO.getB_author());
			v.add(bVO.getB_publish());
			dtm_book.addRow(v);
		}
	}//////////////////////////////////////end of refreshData
}