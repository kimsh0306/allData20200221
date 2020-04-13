package book.chap05;

public class MemberSimulation2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Member mems[] = new Member[2];
		//여기를 지나면 입장 할 수 있어요.
		Member mem = new Member();
		
		mem.mem_name="김유신";//21 이후로 mems[0].mem_name="김유신";로도 쓸 수 있음.
		mem.mem_id="test";
		mem.mem_pw=123;
		
		//앗 mem주소번지를 잘라내려고 해요....
		//잘리기 전에 담아두어야 합니다. 일단 null이 되고 나면 가비지 컬렉터가
		//넌 쓰레기값이야 라고 딱지를 붙입니다. 그러면 접근을 못해요 ㅠㅠ
		//그래서 반드시 그 전에 담아두어야 하는 거군요.
		
		mems[0]=mem;  //끊기전에 데이터를 집어넣음
		mem = null;  //풍선줄 끊음
		mem = new Member();
		mem.mem_name="이순신";//27 이후로 mems[1].mem_name="이순신";로도 쓸 수 있음.
		mem.mem_id="fdfd";
		mem.mem_pw=333;
		mems[1] = mem;
		System.out.println(mems[0]+" "+mems[1]);
	
		
		for(int i=0; i<mems.length; i++) {
			String id = mems[i].mem_id;
			int pw = mems[i].mem_pw;
			String name = mems[i].mem_name;
			System.out.println("id ===>"+id);
			System.out.println("pw ===>"+pw);
			System.out.println("name ===>"+name);
		}
	}
}
