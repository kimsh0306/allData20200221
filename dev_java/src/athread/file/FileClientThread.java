package athread.file;

public class FileClientThread extends Thread{
	FileClient fc = null;
	public FileClientThread() {
	}
	public FileClientThread(FileClient fc) {
		this.fc = fc;
	}
	@Override
	public void run() {
		
	}
}
