package exam0407;
//서버쪽에 접속하는 부분까지

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TcpChatClient {
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	
	Socket socket = null;
	final String 	_IP 	= "192.168.0.26";
	final int 		_PORT 	= 5005;
	public void connect_process() {
		try {
			socket = new Socket(_IP,_PORT);
			System.out.println("client측: "+socket.getInetAddress());
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			//서버로부터 전송된 메시지를 읽어보자.
			//변수에 담아보자
			String msg = (String)ois.readObject();
			System.out.println("서버로부터 받은 메시지: "+msg);
		} catch (Exception e) {
			//항상 메시지 확인하기.당분간.
			System.out.println(e.toString());
		}finally {
			try {
				if(ois!=null) ois.close();
				if(socket!=null) socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		TcpChatClient tcc = new TcpChatClient();
		tcc.connect_process();
	}

}
