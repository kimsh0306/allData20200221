package design.book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/*
 * 자바에서는 단일 상속만 가능함.
 * 다중 상속이 필요할 땐 인터페이스로 대신한다.
 * 여기서처럼 JFrame을 이미 상속받은 경우 Thread를 또 상속받을 수 없다.
 * 이런 경우를 지원하기 위해서 Runnable이라는 인터페이스를 지원함.
 */
public class TimeServer extends JFrame implements Runnable {
	Socket socket = null;
	int port = 3000; //서버파트의 포트
	//서버소켓은 사용자가 접속해 오기를 기다립니다.언제까지 기다려야 할지 알 수 없죠...
	ServerSocket server = null;
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log
										,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
										,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	List<TimeServerThread> globalList = null;
	TimeServerThread tst = null;
	
	public TimeServer() {

	}
	
	public String setTimer() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);		//1~24시까지 가져온다.
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		return	(hour < 10 ? "0"+hour:""+hour)+":"+
				(hour < 10 ? "0"+min:""+min)+":"+
				(hour < 10 ? "0"+sec:""+sec);
	}
	public void run() {	//지연처리 가능, 들은 정보를 내보낼 수 있다. 1초에 한 번씩 시간 정보를 내보낸다.
		globalList = new Vector<>();
		System.out.println("run call....");
		try {
			server = new ServerSocket(port); //가게 문 열고 기다리는 중... 손님이 언제 올까?(ip,port)
		}catch (Exception e) {
		}/////////////////end of try

		System.out.println("TimeServer started successfully...");
		while(true) {		//와일문에 트루가 오면 무한루프에 빠진다. while문 탈출 불가.
			try {
				//클라이언트 측에서 접속해온 정보를 client 소켓에게 넘김.
				socket = server.accept();//손님이 올 때까지 대기, 사용자의 정보를 갖고 있는 소켓.
				jta_log.append("New Client connected..."+socket.toString()+"\n");
				tst = new TimeServerThread(this);
				tst.start();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		

	}
	/*
	 * main메소드 안에서 만들어진 정보를 run메소드에서 사용하려면 생성자를 통해서
	 * 초기화를 해주어야 한다.
	 * 복사본을 사용하는 것이 아니라 메인에서 접속한 클라이언트의 소켓 원본을 사용해야 하니까.
	 */
	public static void main(String[] args) {
		TimeServer ts = new TimeServer();
		ts.initDisplay();//화면을 그리고 난 뒤 스레드 대기를 타도록 해야 함.
		Thread th = new Thread(ts);
		th.start();//스레드의 run메소드를 호출하는 메소드
		//스레드 =>	지속적으로 1초에 한 번씩 기다렸다가 시간을 찍어야할 때 '스레드'가 필요하다.
		//			순서대로 처리하고 싶다.스레드를 동작시켜주는 메소드 => start()
	}////////////////////////end of main
	
	//화면 처리
	public void initDisplay() {
		this.setTitle("TimeServer 로그");
		this.add("Center",jsp_log);
		this.setSize(500,400);
		this.setVisible(true);
	}
}