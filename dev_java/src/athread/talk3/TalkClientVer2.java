package athread.talk3;

import java.awt.Color;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
//나는 oos와 ois를 어느 클래스에 생성해야 하는지 전혀 감이 없다.
//TalkClientVer2 oos와 ois를 두는 이유는?
//Login처리는 LoginForm에서 진행되므로 TalkClientVer2에서 생성하면 될 것이다.
public class TalkClientVer2 extends JFrame {
	JTabbedPane jtp = new JTabbedPane(); //인덱스로 방을 여러개로 나눔
	WaitRoom wr = new WaitRoom(this);
	MessageRoom mr = new MessageRoom(this);
	SettingRoom sr = new SettingRoom(this);
	Socket mySoket = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	//서버에 접속하려면 ip주소,PORT가 있어야 한다.
	final static String _IP = "192.168.0.26";
	final static int _PORT 	= 5001; //0~65575 사이에 포트 사용 가능
	//대화명을 담는 변수
	String nickName = null;
	LoginForm loginForm =null;
	
	public TalkClientVer2() {
	}
	
	public TalkClientVer2(LoginForm loginForm) {
		this.loginForm = loginForm;
		nickName = loginForm.nickName;//로그인 화면에서 결정된 대화명으로 동기화
		initDisplay();
		//화면처리 후 서버소켓 접속하기
		connect_process();
		
	}
	public void connect_process() {
		this.setTitle(nickName+" 님의 대화창");
		try {
			mySoket = new Socket(_IP,_PORT);
			oos = new ObjectOutputStream(mySoket.getOutputStream());
			ois = new ObjectInputStream(mySoket.getInputStream());
			oos.writeObject(Protocol.WAIT+"#"+nickName+"#"+"대기");
			//말하고 듣기
			//내가 한 말도 서버를 경우하여 듣는다(스레드**, 메소드 이름은 run) - 꼭 기억해야한다***
			TalkClientThread tct = new TalkClientThread(this);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void initDisplay() {
		this.getContentPane().setLayout(null);	//원래는 보더레이아웃인데 널로 뭉갰다.
		//탭 추가
		jtp.addTab("대기실", wr);
		jtp.addTab("단톡방", mr);
		jtp.addTab("설정방", sr);
		
		this.getContentPane().setBackground(new Color(158,217,164));//메소드 안에서 메소드 호출***
		
		jtp.setBounds(5, 4, 620, 530);
		this.getContentPane().add(jtp);
		this.setSize(650, 580);
		this.setVisible(true); //화면을 보여주세요.
		jtp.setSelectedIndex(0);
	}
	
	public static void main(String[] args) {
		TalkClientVer2 tc = new TalkClientVer2(new LoginForm());
		
	}
}