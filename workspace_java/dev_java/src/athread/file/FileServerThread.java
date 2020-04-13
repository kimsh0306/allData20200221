package athread.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileServerThread extends Thread {
	FileServer fc = null;
	public FileServerThread() {
	}
	public FileServerThread(FileServer fs) {
		this.fc = fc;
	}
	@Override
	public void run() {
		boolean isStop = false;
		while(!isStop) {
			try {
				String 	fileName = "src\\emotion\\lion1.png";
				OutputStream out = new FileOutputStream(fileName);
				InputStream is = fc.socket.getInputStream();
				int readcount = 0;
				byte buffer[] = new byte[512];
				while((readcount=is.read(buffer)) != -1) {
					out.write(buffer,0,readcount);
				}
				out.close();
				is.close();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
}
