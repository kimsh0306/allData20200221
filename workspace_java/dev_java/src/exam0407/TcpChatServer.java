package exam0407;
/*
 * TCP/IP방식 - 군사목적: 안전, 신뢰도 높다.,장애가 발생하면 지속적으로 체크 다시 연결
 * 			- 휴대전화
 * 
 * UDP방식 - 신뢰도는 낮다, 대용량 전송에 유리,보내고 나면 확인 불가, 
 * 			몇 번째 데이터가 에러가 나서 탈선이 됐는지 알 길이 없다. 속도는 높다.
 * 			미디어 전송처리에 유리하다.
 * 			- 편지(보내는 이, 받는 이)
 * 
 */
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpChatServer extends Thread{
	
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	
	ServerSocket server = null;
	Socket client = null;
	
	@Override
	public void run() {
		try {
			//서버소켓을 생성한다.
			server = new ServerSocket(5005);
			System.out.println("클라이언트를 기다린다...");
		} catch (Exception e) {
			//예외에 대한 메시지 출력
			System.out.println(e.toString());
			//예외상황을 관리하는 stack메모리 영역에 쌓여 있는 메시지를 순차적으로 보여준다.
			e.printStackTrace();
		}
		//서버는 24시간 돌아가고 있어야 한다.
		while(true) {
			//클라이언트가 접속할 때까지 기다리는 작업이 필요하다.
			try {
				//손님이 입장
				client = server.accept();
				//getInetAddress() 문제 나올 것이다.
				//client.getInetAddress() => 접속한 클라이언트의 주소
				//System.out.println(client.getInetAddress());
				System.out.println(client);
				
				OutputStream os = client.getOutputStream();
				oos = new ObjectOutputStream(client.getOutputStream());
				oos.writeObject("서버에서 보내는 메시지입니다.");
				System.out.println("메시지를 전송했습니다.");
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if(oos!=null) oos.close();
					if(client!=null) client.close();
				} catch (Exception e2) {
					//외우자.
					e2.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		TcpChatServer tcs = new TcpChatServer();
		tcs.start();
	}

}
