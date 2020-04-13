package athread.talk3;

public class Protocol {
	public final static int WAIT  		= 100;	//대기상태
	public final static int ROOM_CREATE = 110;	//단톡방에 생성 
	public final static int ROOM_LIST  	= 120;	//단톡방 목록
	public final static int ROOM_IN  	= 130;	//하늘소 입장
	public final static int ROOM_INLIST	= 140;	//단톡방 목록
	public final static int ROOM_OUT	= 190;	//방나가기
	public final static int MESSAGE		= 200;	//다자간 대화
	public final static int WHISHER		= 210;	//1:1대화
	public final static int CHANGE		= 220;	//대화명 변경
	public final static int EXIT		= 500;	//종료
	public final static String SEPERATOR = "#";
}
