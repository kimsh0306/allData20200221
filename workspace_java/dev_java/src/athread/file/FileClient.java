package athread.file;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileClient extends JFrame {
	Socket 			socket 	= null;
	JTextArea 		jta_log = new JTextArea(10,30);
	JScrollPane 	jsp_log = new JScrollPane(jta_log
			                                 ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			                                 ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	public void initDisplay() {
		this.setTitle("★★★★★클라이언트★★★★★");
		this.add("Center",jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		FileClient fs = new FileClient();
		fs.initDisplay();
		Thread th = new Thread(fs);
		th.start();
	}
	public void init() {
		try {
			socket = new Socket("127.0.0.1",3002);
			FileClientThread tct = new FileClientThread(this);
			tst.start();//run()호출해줌
		}
	}
}
