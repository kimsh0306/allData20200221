package division.UI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestView extends JFrame {
	TestSouth ts = new TestSouth();
	//외부에 두지 않고 내부에 만들기
	JPanel jp_north = new JPanel();
	JButton jbtn_change = new JButton("변경");
	//ts를 넘기면 TestSouth만 누릴 수 있지만 this를 넘기면 TestView와 TestSouth 
	//모두를 누릴 수 있다.**********************************************
	TestEvent te = new TestEvent(this);		//
	//TestSouth ts2 = new TestSouth(this);	//어떤 경우에 이렇게 해야 할까?
	
	public TestView() {
		initDisplay();
	}
	
	public void initDisplay() {
		//이벤트를 감지하는 코드
		//사우스에서 해야할 일을 여기서 한다.
		//코드의 가독성이 좋아짐.
		ts.jtf_msg.addActionListener(te);
		jbtn_change.addActionListener(te);
		//버튼을 여기에 붙인다.왼쪽부터 정렬.
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		//이 [변경]버튼을 눌렀을 때 다른 버튼으로 출력해 보자.
		jp_north.add(jbtn_change);
		this.add("North",jp_north);
		this.add("South",ts);
		this.setSize(500,300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestView();//***
	}
}