package book.chap15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RandomGame2 extends JFrame {

	public static void main(String[] args) {
		RandomGame2 rg = new RandomGame2();
		Random r = new Random();
		int dap = r.nextInt(10);					//0~9까지 채번
		String user = "-1";							//사용자가 입력한 숫자 담기
		JOptionPane.showMessageDialog(rg, "0~9 중에서 입력해봐", "INFO", JOptionPane.INFORMATION_MESSAGE);
		InputStreamReader in = new InputStreamReader(System.in);
		//버퍼링 기능이 추가되어 있는 보조스트림이다.
		//단독으로는 읽기 불가함. 반드시 기반스트림(InputStreamReader)과 연결해서 사용해야 한다.
		BufferedReader br = new BufferedReader(in);	//보조스트림 파라미터에 기반스트림
		try {
			//user = in.read();						//아스키 코드 10진수를 가져온다.
			while(((user=br.readLine()) != null)) {	//문자열 전체 덩어리를 받아오는 메소드 readLine()
				System.out.println("사용자가 입력한 숫자: "+user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
