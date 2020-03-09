package division.UI;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

//부분 페이지로 처리가 될 것이다.
//JPanel은 단독으로 창을 띄울 수 없다.
//혼자 힘으로는 세상에 나올 수 없다.
//TestView클래스에 의존해야 화면에 나타낼 수 있다. => 의존성 주입.의존 관계에 있다.
//테스트뷰 안에 테스트사우스
public class TestSouth extends JPanel {
	JTextField jtf_msg = new JTextField(20);
	public TestSouth() {
		initDisplay();
	}
	
	public void initDisplay() {
		this.setLayout(new BorderLayout());
		this.add("Center",jtf_msg);
	}
}
