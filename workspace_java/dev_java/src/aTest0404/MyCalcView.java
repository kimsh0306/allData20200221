package aTest0404;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

//JUnit
public class MyCalcView extends JFrame implements ActionListener{
	//선언부
	JMenuBar	jmb = new JMenuBar();
	JMenu		jm_info = new JMenu("도움말");
	JMenuItem	jmi_create = new JMenuItem("만든사람들.");
	
	//JFrame 디폴트가 BorderLayout
	JTextField jtf_account = new JTextField(20);//North에 붙일 예정
	JPanel 	jp_center	= new JPanel();
	JButton jbtn_b1 	= new JButton(" ");
	JButton jbtn_b2 	= new JButton(" ");
	JButton jbtn_ac 	= new JButton("AC");
	JButton jbtn_bs 	= new JButton("←");
	JButton jbtn_seven 	= new JButton("7");
	JButton jbtn_eight 	= new JButton("8");
	JButton jbtn_nine 	= new JButton("9");
	JButton jbtn_plus 	= new JButton("+");
	JButton jbtn_four 	= new JButton("4");
	JButton jbtn_five 	= new JButton("5");
	JButton jbtn_six 	= new JButton("6");
	JButton jbtn_minus 	= new JButton("-");
	JButton jbtn_one 	= new JButton("1");
	JButton jbtn_two 	= new JButton("2");
	JButton jbtn_three 	= new JButton("3");
	JButton jbtn_mul 	= new JButton("×");
	JButton jbtn_zero 	= new JButton("0");
	JButton jbtn_dot 	= new JButton(".");
	JButton jbtn_equl 	= new JButton("=");
	JButton jbtn_div 	= new JButton("÷");//ㄷ+한자
	//생성자
	public MyCalcView() {
		initDisplay();
	}
	//파라미터로 받은 두 개 값이 같은 지를 비교할 때
	public int methodA(int a, int b) {
		int result = 0;
		System.out.println("a:"+a+", b:"+b);
		if(a==b) result = 1;
		return result;
	}
	//화면처리부
	public boolean initDisplay() {
		System.out.println("initDisplay호출 성공");
		jtf_account.setHorizontalAlignment(JTextField.RIGHT);
		jbtn_ac.addActionListener(this);
		jbtn_bs.addActionListener(this);
		jbtn_one.addActionListener(this);
		jbtn_two.addActionListener(this);
		jbtn_three.addActionListener(this);
		jbtn_four.addActionListener(this);
		jbtn_five.addActionListener(this);
		jbtn_six.addActionListener(this);
		jbtn_seven.addActionListener(this);
		jbtn_eight.addActionListener(this);
		jbtn_nine.addActionListener(this);
		jbtn_zero.addActionListener(this);
		jtf_account.setEditable(false);//입력받지 못하도록 만들었다.
		boolean isOk = false;
		jm_info.add(jmi_create);
		jmb.add(jm_info);
		
		this.setJMenuBar(jmb);
		jp_center.setLayout(new GridLayout(5,4,2,2));
		jp_center.add(jbtn_b1);		//
		jp_center.add(jbtn_b2);		//
		jp_center.add(jbtn_ac);		//
		jp_center.add(jbtn_bs);		//
		jp_center.add(jbtn_seven);	//
		jp_center.add(jbtn_eight);	//
		jp_center.add(jbtn_nine);	//
		jp_center.add(jbtn_plus);	//
		jp_center.add(jbtn_four);	//
		jp_center.add(jbtn_five);	//
		jp_center.add(jbtn_six);	//
		jp_center.add(jbtn_one);	//
		jp_center.add(jbtn_two);	//
		jp_center.add(jbtn_three);	//
		jp_center.add(jbtn_mul);	//
		jp_center.add(jbtn_zero);	//
		jp_center.add(jbtn_dot);	//
		jp_center.add(jbtn_equl);	//
		jp_center.add(jbtn_div);	//
		this.add("North",jtf_account);
		this.add("Center",jp_center);
		this.pack();
		this.setVisible(true);
		
		if(isOk) {
			System.out.println("정상적으로 되었음.");
		}else {
			System.out.println("화면처리 실패!!!.");
		}
		return true;
		
	}
	//메인
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		MyCalcView mv = new MyCalcView();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//지우기 버튼
		if(jbtn_plus == obj) {
			String imsi = jtf_account.getText();
			imsi = imsi.substring(0,imsi.length()-1);
			jtf_account.setText(imsi);
		}
		if(jbtn_bs == obj) {
			String imsi = jtf_account.getText();
			imsi = imsi.substring(0,imsi.length()-1);
			jtf_account.setText(imsi);
		}
		else if(jbtn_ac == obj) {
			jtf_account.setText("");
		}
		else if(jbtn_one == obj) {
			jtf_account.setText(jtf_account.getText()+"1");
		}
		else if(jbtn_two == obj) {
			jtf_account.setText(jtf_account.getText()+"2");
		}
		else if(jbtn_three == obj) {
			jtf_account.setText(jtf_account.getText()+"3");
		}
		else if(jbtn_four == obj) {
			jtf_account.setText(jtf_account.getText()+"4");
		}
		else if(jbtn_five == obj) {
			jtf_account.setText(jtf_account.getText()+"5");
		}
		else if(jbtn_six == obj) {
			jtf_account.setText(jtf_account.getText()+"6");
		}
		else if(jbtn_seven == obj) {
			jtf_account.setText(jtf_account.getText()+"7");
		}
		else if(jbtn_eight == obj) {
			jtf_account.setText(jtf_account.getText()+"8");
		}
		else if(jbtn_nine == obj) {
			jtf_account.setText(jtf_account.getText()+"9");
		}
		else if(jbtn_zero == obj) {
			jtf_account.setText(jtf_account.getText()+"0");
		}
	}
}
