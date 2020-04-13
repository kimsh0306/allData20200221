package ui.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class JInternalFrameTest implements ActionListener{//ActionListener 버튼에 대한 이벤트 처리
	JFrame jf = new JFrame();
	JDesktopPane jdp = new JDesktopPane();
	//이 아이를 중앙에 배치하고 JInternalFrame으로 내부에 띄워줄 창을 만들면 
	//JFrame 창 안에 여러 개의 내부창을 관리할 수 있다.
	JPanel jp_north = new JPanel();//north 속지(패널) 추가, 패널은 투명한 셀로판지
	//버튼을 북쪽에 만든다.
	JButton jbtn_zip = new JButton("우편번호찾기");
	public JInternalFrameTest() {
		initDisplay();//출력 테스트 해보기
	}
	public void initDisplay() {
		//내 안에 actionPerformed 메소드를 구현하였다. 
		//이벤트를 처리해 주는 기능을 담고 있는 메소드가 내 안에 있기 때문에 this를 쓴다.
		//이 코드가 있어야 자동(누가? JVM)으로 actionPerformed 메소드를 호출해 줌.
		jbtn_zip.addActionListener(this);
		jf.setTitle("윈도우창에 내부 프레임 생성하기");
		//jp_north 속지에 우편번호 찾기 버튼을 오른쪽에서부터 붙인다.
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtn_zip);
		//북쪽에는 jp_north 속지를 붙여 줄까
		jf.add("North",jp_north);
		//jf의 중앙에 JDesktopPane 속지를 붙여 줄래
		jf.add("Center",jdp);
		jf.setSize(700, 500);
		jf.setVisible(true);//화면을 띄워주세요.
	}
	public static void main(String[] args) {
		new JInternalFrameTest();
	}//////////////////////////////end of main
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn_zip) {//너 우편번호 찾기 버튼 누른거야? JVM이 갖고 있는 주소 번지
			//System.out.println("우편번호 찾기 호출 성공");
			//주소번지 필요하니까 인스턴스화가 필요
			InnerFrame inn = new InnerFrame(jbtn_zip.getText(),
											true
										   ,true
										   ,true
										   ,true);
			jdp.add(inn);//(주소번지);
		}
	}///////////////////////////end of actionPerformed
}
//JDesktopPane이라는 속지 안에  InnerFrame을
class InnerFrame extends JInternalFrame{//JInternalFrame => 아빠 것도 내 거, 내 것도 내 거.
	  InnerFrame(String title, boolean resizable
			    ,boolean closable,boolean maximizable//closable 닫히는 아이콘을 활성화 할거야 말거야?
			    ,boolean iconifiable)
	{
		//아빠 생성자 호출 문장 => 아빠 객체가 가진 기능들을 온전히 누릴 수 있다.
		super(title,resizable,closable,maximizable,iconifiable);
		this.setTitle(title);
		this.setSize(300, 200);
		this.setVisible(true);
	}
}