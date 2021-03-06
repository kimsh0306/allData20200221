package athread.talk3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread {
	public TalkServer ts = null;
	Socket client = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	String chatName = null;//현재 서버에 입장한 클라이언트 스레드 닉네임 저장
	String g_title = null;//현재 그 사람의 대화방명
	int g_current = 0;//현재 인원 수 담기
	public TalkServerThread(TalkServer ts) {
		this.ts = ts;
		this.client = ts.socket;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			String msg = (String)ois.readObject();
			ts.jta_log.append(msg+"\n");
			StringTokenizer st = null;
			if(msg != null) {	//사용자가 보낸 메시지가 도착한거야?
				st = new StringTokenizer(msg,Protocol.SEPERATOR);
			}
			if(st.hasMoreTokens()) {
				st.nextToken();//100
				chatName = st.nextToken();
				g_title = st.nextToken();//대기
			}
			st.nextToken();//100
			chatName = st.nextToken();
			ts.jta_log.append(chatName+"님이 입장하였습니다.\n");
			for(TalkServerThread tst:ts.globalList) {
			//이전에 입장해 있는 친구들 정보 받아내기
				String currentName = tst.chatName;
				String currentState = tst.g_title;
				this.send(Protocol.WAIT
						 +Protocol.SEPERATOR+currentName
						 +Protocol.SEPERATOR+currentState
						 );
			}
			//현재 서버에 입장한 클라이언트 스레드 추가하기
			ts.globalList.add(this);
			this.broadCasting(msg);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	//현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
	public void broadCasting(String msg) {
		for(TalkServerThread tst:ts.globalList) {
			tst.send(msg);
		}
	}
	//클라이언트에게 말하기 구현
	public void send(String msg) {
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		String msg = null;
		boolean isStop = false;
		try {
			//while(true) {//무한루프에 빠질 수 있다.
			run_start:
			while(!isStop) {
				msg = (String)ois.readObject();
				ts.jta_log.append(msg+"\n");
				ts.jta_log.setCaretPosition
				(ts.jta_log.getDocument().getLength());
				StringTokenizer st = null;
				int protocol = 0;//100|200|201|202|500
				if(msg !=null) {
					st = new StringTokenizer(msg,"#");
					protocol = Integer.parseInt(st.nextToken());//100
				}
				switch(protocol) {
					case 200:{
						//보내는 사람
						String nickName = st.nextToken();
						//받는 사람
						String otherName = st.nextToken();
						//보내진 메시지
						String msg1 = st.nextToken();
						//클라이언트로 전송하기
						//스레드 중에서 상대 스레드에게만 메세지 전송할 것
						for(TalkServerThread tst:ts.globalList) {
							if(otherName.equals(tst.chatName)) {//내가 선택한 상대가 맞는거야?
								tst.send(200
										+"#"+nickName
      								    +"#"+otherName
								        +"#"+msg1);
								break;
							}
						}
						//그리고 나 자신에게도 전송해 보자.
						this.send(200
								+"#"+nickName
								+"#"+otherName
						        +"#"+msg1);
					}break;
					case 201:{
						String nickName = st.nextToken();
						String message = st.nextToken();
						String fontColor = st.nextToken();
						broadCasting(201
								   +"#"+nickName
								   +"#"+message
						           +"#"+fontColor);
					}break;
					case 202:{
						String nickName = st.nextToken();
						String afterName = st.nextToken();
						String message = st.nextToken();
						this.chatName = afterName;
						broadCasting(202
								+"#"+nickName
								+"#"+afterName
        						+"#"+message);
					}break;
					case 500:{
						String nickName = st.nextToken();
						ts.globalList.remove(this);
						broadCasting(500
								+"#"+nickName);
					}break run_start;
				}/////////////end of switch
			}/////////////////end of while			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}/////////////////////////end of run
}
