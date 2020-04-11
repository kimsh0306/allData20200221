package book.chap15;

public class StopThread implements Runnable {
	boolean stopped = false;
	
	@Override
	public void run() {
//		while(true) {
		while(!stopped) {
			System.out.println("Thread is alive...");
			try {
				Thread.sleep(500);	//0.5초 동안 슬립 당한다.죽은 건 아니다. 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread is dead...");
	}
	public void stop() {
		stopped = true;
	}

}
