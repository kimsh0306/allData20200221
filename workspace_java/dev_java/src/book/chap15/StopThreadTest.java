package book.chap15;

public class StopThreadTest {
	public void process() {
		StopThread st = new StopThread();
		Thread th = new Thread(st);	//자동차>내비게이션을 켰을 때 스레드가 동작한다.
		th.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		st.stop();
	}
	//16-17-18-4-5(Thread를 통한 객체 생성)-6-7(run호출)-"Thread is alive..."-두 번
	//[StopTread]의 11번(슬립상태에 빠져있다가)-13-[StopTread]의 19번-"Thread is dead..."
	public static void main(String[] args) {
		StopThreadTest stt = new StopThreadTest();
		stt.process();
	}

}
