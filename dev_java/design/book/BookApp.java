package design.book;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BookApp extends JFrame implements ActionListener {
	//선언부
	static BookApp ba = null;
	//조립 전 부품을 준비한다.
	//파라미터가 없는 생성자는 디폴트로 지원해주지만 있는 경우에는 예측불가이므로 지원불가함.
	BookDialog bd = new BookDialog();
	//jp_north 속지는 JFrame의 북쪽에 배치
	JPanel jp_north = new JPanel();
	//아래 버튼은 jp_north 속지에 차례대로 배치 - 배치는 왼쪽부터 
	JButton jbtn_all = new JButton("전체조회");
	JButton jbtn_sel = new JButton("상세조회");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	
	
	//화면 그리기
	public void initDisplay() {
		//아래코드가 JFrame의 자원을 회수함.
		//부모자원이 회수될 때 JDialog도 같이 회수됨.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JVM, 버튼 누르는 것을 감지해라.
		//버튼 다섯 개에 대해서 이벤트 처리를 연결해 주는 코드.
		jbtn_ins.addActionListener(this);
		jbtn_sel.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		jbtn_all.addActionListener(this);
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		//insert here
		//준비한 것을 조립한다.
		this.setTitle("도서관리시스템");
		jp_north.add(jbtn_all);
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		this.add("North", jp_north);
		this.setSize(700, 500);
		this.setVisible(true);
		bd.isView = true;
	}
	
	public static void main(String[] args) {
		//insert here
		ba = new BookApp();
		ba.initDisplay();
	}

	//JButton에 대한 이벤트를 지원하는 인터페이스가 ActionListener임.
	//클래스 뒤에 implements 할 것.
	//ActionListener에 정의된 추상메소드를 재정의 할 것.
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 감지된 클래스의 주소번지 받기
		Object obj = e.getSource();
		//입력버튼을 누른거니?
		//insert here
		//initDisplay를 호출한 이유는 setTitle("입력")과 setVisible(true)
		//때문이었다. 그런데 그 둘을 set 메소드로 이전하였다.
		if(jbtn_ins==obj) {
			System.out.println("입력호출 성공");
			bd.set(jbtn_ins.getText(),true,true,null,ba);
			
		}else if(jbtn_upd==obj) {	//수정 시에는 먼저 기본 정보를 조회하고 화면 이동
			//insert here
			//select 처리한 후 한 개 로우를 받아서 Map에 저장
			Map<String, Object> rMap = null;
			rMap = new HashMap<>();
			rMap.put("b_title", "자바의 정석");
			System.out.println("수정호출 성공");
			bd.set(jbtn_upd.getText(),true,true,rMap,null);
			
		}else if(jbtn_sel==obj) {
			Map<String, Object> rMap = null;
			System.out.println("상세조회호출 성공");
			bd.set(jbtn_sel.getText(),true,false,rMap,null);
			
		}else if(jbtn_del==obj) {
			System.out.println("삭제호출 성공");
		}
	}
	public void refreshData() {
		System.out.println("refreshData 호출 성공");
	}
}