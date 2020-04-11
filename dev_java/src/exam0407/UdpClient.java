package exam0407;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
	public void connect_process() {
		try {
			DatagramSocket ds = new DatagramSocket();
			InetAddress siAddr = InetAddress.getByName("127.0.0.1");
			//데이터가 저장될 공간
			byte[] msg = new byte[100];
			DatagramPacket outDP = new DatagramPacket(msg, 1, siAddr,7000);
			DatagramPacket inDP = new DatagramPacket(msg, msg.length);
			//전송하기
			//쓰레드를 사용하지 않으면 지속적으로 서비스를 제공할 수 없다.
			ds.send(outDP);
			//수신하기
			ds.receive(inDP);
			System.out.println("현재 서버 시간:"+new String(inDP.getData()));
			ds.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		UdpClient uc = new UdpClient();
		uc.connect_process();
	}
}
