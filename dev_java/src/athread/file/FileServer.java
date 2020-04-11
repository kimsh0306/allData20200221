package athread.file;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import athread.talk2.TalkServerThread;

public class FileServer extends JFrame implements Runnable {
	ServerSocket 	server 	= null;//경합이 벌어짐
	Socket 			socket 	= null;//그 순간에는 하나
	List<FileServerThread> globalList = null;
	Map<String, FileServerThread> map = new HashMap<>();
	JTextArea 		jta_log = new JTextArea(10,30);
	JScrollPane 	jsp_log = new JScrollPane(jta_log
			                                 ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			                                 ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	public void initDisplay() {
		this.setTitle("★★★★★서버 로그★★★★★");
		this.add("Center",jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		FileServer fs = new FileServer();
		fs.initDisplay();
	}
	@Override
	public void run() {
		//서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기 
		//손님을 관리하기 위한 벡터
		globalList = new Vector<>();
		boolean isStop = false;
		try {
			server = new ServerSocket(3002);
			jta_log.append("Server Ready.........\n");
			while(!isStop) {
				socket = server.accept();
				jta_log.append("client info:"+socket+"\n");		
				//생성자 or run메소드 호출이 먼저?
				//생성자 호출이 먼저다.
				//run() => 듣고 말하기를 한다.
				FileServerThread fst = new FileServerThread(this);
				fst.start();//run() 호출해줌. 누가? JVM 언제? run()를 호출하기만 하면
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
