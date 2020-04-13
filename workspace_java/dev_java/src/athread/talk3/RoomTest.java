package athread.talk3;

import java.util.ArrayList;
import java.util.List;

public class RoomTest {
	TalkServer ts = null;
	//축구부 명단 출력하기
	void printFList(List<String> nameList) {
		if(nameList !=null) {
			for(int i=0;i<nameList.size();i++) {
				System.out.println(nameList);
				
			}
		}else {
			System.out.println("명단이 없습니다.");
		}
	}
	
	//축구부는 축구부에만 전달, 농구부는 농구부에만 전달
	public void roomCasting(String msg, String roomTitle) {
		for(int i=0;i<ts.roomList.size();i++) {
			//Room에 대한 주소번지를 가져옴.
			Room room = ts.roomList.get(i);
			if(roomTitle.equals(room.title)) {
				for(int j=0;j<room.userList.size();j++) {
					TalkServerThread tst = room.userList.get(j);
					try {
						tst.send(msg);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
		//방의 갯수는 어떻게 알 수 있을까?
		
		//그 방 중에 방이름은 어떻게 비교하지?
		
		//그 방에 있는 사람 수는 어떻게 알아내는 거야?
	}
	
	public static void main(String[] args) {
		Room broom = new Room();//농구부
		broom.title = "농구부";
		//농구부의 인원을 5명 
		List<String> bList = new ArrayList<>();
		broom.nameList.add("이순신");
		broom.nameList.add("김유신");
		broom.nameList.add("이성계");
		broom.nameList.add("강감찬");
		broom.nameList.add("김춘추");
		
		Room froom = new Room();//축구부
		froom.title = "축구부";
		//축구부의 인원을 3명
		List<String> fList = new ArrayList<>();
		froom.nameList.add("유재석");
		froom.nameList.add("강호동");
		froom.nameList.add("김종국");
		
		RoomTest rt = new RoomTest();
		rt.printFList(froom.nameList);	//축구부인지 농구부인지
	}
}