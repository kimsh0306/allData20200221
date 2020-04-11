package book.chap15;

public class StopThread2 implements Runnable {
	
	@Override
	public void run() {
//		while(true) {
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("Thread is alive...");
			try {
				Thread.sleep(500);	//0.5초 동안 슬립 당한다.죽은 건 아니다. 
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Thread is alive...");
			}
		}
		System.out.println("Thread is dead...");
	}
}
