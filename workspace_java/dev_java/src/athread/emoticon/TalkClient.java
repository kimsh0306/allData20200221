package athread.emoticon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class TalkClient extends JFrame implements ActionListener {
	////////////////통신과 관련한 전역변수 추가 시작//////////////
	Socket 				socket 	= null;
	ObjectOutputStream 	oos 	= null;//말 하고 싶을 때
	ObjectInputStream 	ois		= null;//듣기 할 때
	////////////////통신과 관련한 전역변수 추가  끝  //////////////
	JPanel jp_second	  = new JPanel();
	JPanel jp_second_south = new JPanel();
	JButton jbtn_create	  = new JButton("방생성");
	JButton jbtn_emot	  = new JButton("이모티콘");
	JButton jbtn_one	  = new JButton("1:1");
	JButton jbtn_change	  = new JButton("대화명변경");
	JButton jbtn_font	  = new JButton("글자색");
	JButton jbtn_exit	  = new JButton("나가기");
	String cols[] 		  = {"대화명"};
	String data[][] 	  = new String[0][1];
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	JTable			  jtb = new JTable(dtm);
	JScrollPane       jsp = new JScrollPane(jtb);
	JPanel jp_first 		= new JPanel();
	JPanel jp_first_south 	= new JPanel();
	JTextField jtf_msg = new JTextField(20);//south속지 center
	JButton jbtn_send  = new JButton("전송");//south속지 east
	//글꼴적용이나 스타일 추가를 하려면 스타일 클래스를 매핑해야 함.
	StyledDocument sd_display = 
			new DefaultStyledDocument(
					new StyleContext());
	JTextPane   jtp_display = new JTextPane(sd_display);
	JScrollPane jsp_display = new JScrollPane(jtp_display
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
	//배경 이미지에 사용될 객체 선언-JTextArea에 페인팅
	Image back = null;
	//LoginForm loginForm = new LoginForm();
	LoginForm loginForm = null;
	String fontColor = "0";
	public TalkClient() {
	}
	public TalkClient(LoginForm loginForm) {
		this.loginForm = loginForm;
		jtf_msg.addActionListener(this);
		jbtn_create.addActionListener(this);
		jbtn_emot.addActionListener(this);
		jbtn_one.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jbtn_font.addActionListener(this);
	    initDisplay();
		init();//서버소켓 연결하기
	}
	public void initDisplay() {
		this.setLayout(new GridLayout(1,2));
		
		jp_first.setLayout(new BorderLayout());
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center",jtf_msg);
		jp_first_south.add("East",jbtn_send);
		back = getToolkit().getImage("src\\athread\\talk\\back.jpg");
		Font font = new Font("돋움",Font.BOLD,25);	
		
		jp_first.add("Center",jsp_display);
		jp_first.add("South",jp_first_south);
		jp_second.setLayout(new BorderLayout());
		jp_second_south.setLayout(new GridLayout(3,2));
		jp_second.add("Center",jsp);
		jp_second.add("South",jp_second_south);
		jp_second_south.add(jbtn_create);
		jp_second_south.add(jbtn_emot);
		jp_second_south.add(jbtn_one);
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_font);
		jp_second_south.add(jbtn_exit);
		this.add(jp_first);
		this.add(jp_second);
		this.setSize(600, 450);
		this.setVisible(true);
	}
	public static void main(String args[]) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		TalkClient tc = new TalkClient();
		tc.initDisplay();
		tc.init();
	}
	//소켓 관련 초기화
	public void init() {
		try {
			//서버측의 ip주소 작성하기
			socket = new Socket("127.0.0.1",3002);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			//initDisplay에서 닉네임이 결정된 후 init메소드가 호출되므로
			//서버에게 내가 입장한 사실을 알린다.(말하기)
			this.setTitle(loginForm.nickName);
			oos.writeObject(Protocol.LOGIN+"#"+loginForm.nickName);
			//서버에 말을 한 후 들을 준비를 한다.
			//서버에서 듣고 말한 내용을 들을 준비한다.
			TalkClientThread tct = new TalkClientThread(this);
			tct.start();
		} catch (Exception e) {
			//예외가 발생했을 때 직접적인 원인되는 클래스명 출력하기
			System.out.println(e.toString());
		}
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		String msg = jtf_msg.getText();
		if(jbtn_font == obj) {
			JDialog jdl_color = new JDialog();
			jdl_color.setSize(600, 500);
			JColorChooser jcc = new JColorChooser();
			ColorSelectionModel csm = jcc.getSelectionModel();
			ChangeListener cl = new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					Color color = jcc.getColor();
					fontColor = String.valueOf(color.getRGB());
				}
			};
			csm.addChangeListener(cl);
			jdl_color.add(jcc);
			jdl_color.setVisible(true);
		}
		else if(jbtn_one == obj) {
			//상대를 선택
			int row = jtb.getSelectedRow();
			if(row == -1) {//-1 end of file
				JOptionPane.showMessageDialog(this, "상대를 선택하세요.");
				return;//actionPerformed탈출
			}
			else {//상대가 다른 사람이 아닌 나 자신일 때는 배제한다.
				String name = (String)dtm.getValueAt(row, 0);
				if(loginForm.nickName.equals(name)) {
					JOptionPane.showMessageDialog(this, "자기자신을 선택했어요. 다른 사람을 선택하세요");
					return;
				}
				//메시지 입력받기
				String msg1 = JOptionPane.showInputDialog(name+"님에게 보낼 메시지를 입력하세요.");
				try {
					oos.writeObject(200+"#"+loginForm.nickName+"#"+name+"#"+msg1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}//////////////end of else
			//선택한 대화 상대 초기화
			jtb.clearSelection();
		}//////////////////end of if
		else if(jtf_msg==obj) {
			try {
				oos.writeObject(201
						   +"#"+loginForm.nickName
						   +"#"+msg
				           +"#"+fontColor);
				jtf_msg.setText("");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(jbtn_exit==obj) {
			try {
				oos.writeObject(500+"#"+loginForm.nickName);
				//자바가상머신과 연결고리 끊기
				System.exit(0);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(jbtn_change == obj) {
			String afterName = JOptionPane.showInputDialog("변경할 대화명을 입력하세요.");
			if(afterName == null || afterName.trim().length()<1) {
				JOptionPane.showMessageDialog(this
				, "변경할 대화명을 입력하세요"
				, "INFO", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			try {
				oos.writeObject(202
						   +"#"+loginForm.nickName
						   +"#"+afterName
						   +"#"+loginForm.nickName+"의 대화명이 "+afterName+"으로 변경되었습니다.");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}//////////////////////end of actionPerformed
}















