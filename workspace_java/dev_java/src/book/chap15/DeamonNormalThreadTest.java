package book.chap15;
/*
 * 상황에 따라 분리된 스레드로 백그라운드 작업을 해야 하는 경우가 있다.
 * JVM 안에 가비지 컬렉션과 같은 작업이 대표적이다.
 * 이런 백그라운드 작업이 일반 스레드로 설정되어 있다면 전원이 종료되거나 사용자가 
 * 강제 종료하지 않는 한 애플리케이션은 영원히 정지하지 않을 것이다.
 */
import javax.naming.InterruptedNamingException;

public class DeamonNormalThreadTest {

	public static void main(String[] args) {
		Thread th = new Thread() {
			public void run() {
				try {
					//5초가 될 때까지 NomalThreadTest객체는 종료되지 않는다.
					Thread.sleep(5000);		//Millisecond 5초 정지
					System.out.println("INNER Thread 종료");
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
		};
		th.setDaemon(true);
		th.start();
		System.out.println("main 종료");
	}
}
