package thread.bank;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import design.book.TimeServerThread;

//인터페이스를 추가하면 반드시 구현체 클래스가 되기 위해서 추상메소드를 재정의 해야 한다.-규칙
//run메소드를 반드시 오버라이딩 해야 한다.
//이 메소드 안에서는 무엇을 하지? - 기다려[Thread.sleep(1000)],듣기와 말하기[ois.readObject()]와 말하기[oos.writeObject("메시지")]
public class ServerBank extends JFrame implements Runnable {
	/////////////////////////////전역변수 선언하기 시작/////////////////////////////////////
	Socket socket = null;
	int port = 3000; //서버파트의 포트
	//서버소켓은 사용자가 접속해 오기를 기다립니다.언제까지 기다려야 할지 알 수 없죠...
	ServerSocket server = null;
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log
										,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
										,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//클라이언트에서 접속해온 사용자에 대한 스레드를 담기 위한 List선언
	//일단 선언만 해두었다가 서버소켓이 개설되기 직전에 인스턴스화 함.
	//List는 인터페이스이므로 단독으로 인스턴스화 불가하니까 구현체 클래스 중에서
	//여러 사람을 손실 없이 관리할 수 있는 Vector객체를 생성할 것.
	//클라이언트가 접속을 했을 때 스레드를 가동시킴.
	//ServerBankThread가 서버측에서 생성한 클래스이지만 그 안에 담긴 정보는 클라이언트에
	//대한 정보를 담고 있다.
	//클라이언트가 접속 성공하면 일반소켓에게 서버소켓이 수집한 정보를 넘김.
	//이 정보를 넘겨받으면 그 안에 클라이언트 정보가 담김.
	//스레드가 생성되었을 때 그때 Vector 안에 add처리 할 것. 그래야 그 사람 정보를 유지 가능하니까.
	//담는 작업은 스레드 생성되었을 때 거의 동시에 일어나는 사건이므로 생성자 안에서 처리함.
	List<ServerBankThread> globalList = null;
	ServerBankThread sbt = null;	//인스턴스화는 여기서 하는 게 아니라 억셉트했을 때.
	CustomerDao cDao = new CustomerDao();
	/////////////////////////////전역변수 선언하기 끝/////////////////////////////////////
	
	//메인메소드는 entry point이다.
	//메인 스레드라고도 한다. - 경합이 벌어진다.
	//화면처리와 서버 개통하기
	//스레드 클래스의 run메소드는 어떻게 호출하지?
	public static void main(String[] args) {
		ServerBank sb = new ServerBank();
		sb.initDisplay();
		//sb.start();//오류.왜냐하면 Thread를 상속받지 않았으니까. - 나는 스레드가 아님.
		//어떻게 해결하지? - 일단 Thread를 인스턴스화 하고 생성자에 구현체 클래스를 넣어줌.
		Thread th = new Thread(sb);
		th.start();//run메소드 호출하기
	}

	@Override
	public void run() {
		JOptionPane.showMessageDialog(this, "run호출 성공-스레드 가동 중");
		globalList = new Vector<ServerBankThread>();
		try {
			server = new ServerSocket(port); //가게 문 열고 기다리는 중... 손님이 언제 올까?(ip,port)
		}catch (Exception e) {
		}/////////////////end of try

		jta_log.append("ServerBank started successfully...");
		while(true) {		//와일문에 트루가 오면 무한루프에 빠진다. while문 탈출 불가.
			try {
				//클라이언트 측에서 접속해온 정보를 client 소켓에게 넘김.
				socket = server.accept();//손님이 올 때까지 대기, 사용자의 정보를 갖고 있는 소켓.
				jta_log.append("New Client connected..."+socket.toString());
				sbt = new ServerBankThread(this);	//this-SeverBank자신-원본=>생성자 호출
				sbt.start();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//현재 서버에 접속한 모든 사용자에게 시간 정보 방송하기 구현
	public void initDisplay() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {				//사용 자원 반납하기
					server.close();
					socket.close();
					System.exit(0);
				}catch(Exception e) {
					
				}
			}
		});
		this.setTitle("ServerBank 로그창");
		this.add("Center",jsp_log);
		this.setSize(500,400);
		this.setVisible(true);
	}

}
