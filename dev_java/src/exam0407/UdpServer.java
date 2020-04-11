package exam0407;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpServer {
	public void connect_process() {
		try {
			DatagramSocket socket = new DatagramSocket(7000);
			DatagramPacket inDP, outDP = null;
			byte[] inMsg = new byte[10];
			byte[] outMsg = null;
			while (true) {
				inDP = new DatagramPacket(inMsg, inMsg.length);
				socket.receive(inDP);
				//수신한 패킷에서 사용자의 ip와 port를 얻을 수 있다.
				InetAddress iaddr = inDP.getAddress();
				int port = inDP.getPort();
				//서버의 현재 시간정보
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
				String time = sdf.format(new Date());
				outMsg = time.getBytes();//시간정보를 byte배열로 변환
				//패킷 생성 client전송
				outDP = new DatagramPacket(outMsg, outMsg.length,iaddr,port);
				socket.send(outDP);
			}
		} catch (Exception e) {
			//쓰든 쓰지 않든 무조건 넣어두자.
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		UdpServer udps = new UdpServer();
		udps.connect_process();
	}

}
