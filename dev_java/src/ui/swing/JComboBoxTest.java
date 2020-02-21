package ui.swing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.util.DBConnectionMgr;

public class JComboBoxTest implements ItemListener {//JComboBox클래스 이용하기.
	//선언부
	JFrame jf = new JFrame();
	String data[] = null;
	JComboBox jcb_dept = null;//생성자의 파라미터로 데이터를 넘겨 준다.
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//생성자(호출을 해야 실행 된다)
	public JComboBoxTest() {//실행문은 메소드 안에.화면이 그려지는 부분.
		data = getDeptList();//인스턴스화 없이 바로 호출할 수 있다. 내 안에 있다.
		jcb_dept = new JComboBox(data);
		jcb_dept.addItemListener(this);//괄호 안에는 이벤트를 담당하는 클래스
		//jf.setDefaultCloseOperation(EXIT_ON_CLOSE);//상속 공부 후에 사용.
		jf.add("North",jcb_dept);//"North" 파라미터이기 때문에 앞 글자는 대문자.
		jf.setSize(300,200);
		jf.setVisible(true);//화면에 보여주세요. false 보여주지 마세요.
	}
	/*
	 * 오라클 서버에서 dept테이블에 있는 정보를 조회하시오.
	 * 조회된 정보를 data배열에 초기화 하시오.
	 */
	public String[] getDeptList() {
		String depts[] = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT dname FROM dept");
		try {//물리적으로 떨어져 있는 서버에 ip주소로 접근하니까 예외가 발생할 가능성이 있음.try사용을 권장함
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();//오라클에게 부탁하는 중. sb.append("SELECT dname FROM dept"); 이 셀렉트 문 처리해 줄래?
			Vector<String> v = new Vector<>();//배열의 갯수를 정할 수 없어서
			while(rs.next()) {
				String dname = rs.getString("dname");
				v.add(dname);
			}
			depts = new String[v.size()];
			v.copyInto(depts);//0~? 방에 한 번에 값을 넣는다.타입,파라미터 갯수 맞춰야 한다.
		}catch(Exception e) {
			
		}
		return depts;
	}
	
	//메인 메소드
	public static void main(String[] args) {
		//생성자 호출
		new JComboBoxTest();

	}
	/*
	 * ItemListener의 공식명칭은 인터페이스이다.
	 * 인터페이스는 추상메소드를 가지고 있으므로 반드시 구현해 주어야 한다.
	 * 이때 부모가 가진 메소드의 원형을 절대로 훼손해서는 안된다.
	 */
	@Override
	public void itemStateChanged(ItemEvent ie) {
		Object obj = ie.getSource();
		if(obj == jcb_dept) {
			if(ie.getStateChange()==ItemEvent.SELECTED) {
				System.out.println(jcb_dept.getSelectedIndex());
			}
		}
	}
}
