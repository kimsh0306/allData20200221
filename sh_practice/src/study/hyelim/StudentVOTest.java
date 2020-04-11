package study.hyelim;

import java.util.ArrayList;
import java.util.List;

public class StudentVOTest {

	
	public static void main(String[] args) {
//		///step1///
//		StudentVO sVO = new StudentVO();
//		sVO.name = "혜림";
//		sVO.age = 23;
//		
//		System.out.println(sVO.name);
//		///step1///
		
		
		///step2///
		List<StudentVO> voList = new ArrayList<StudentVO>();// ArrayList는 구현체 클래스이다.
		//List<타입> li = new List<>(); // 할 수 없다.
		StudentVO sVO = new StudentVO();
		sVO.setName("aaa");
		voList.add(sVO);//voList에 인덱스 0번부터 차례차례 채워질 것이다.
		
		sVO = new StudentVO();//sVO를 새로 만들어주었다.
		sVO.setName("bbb");
		voList.add(sVO);
		//voList는 새로 만들어진 것이 아니다.
		//20번 줄에서 생성한 것이 끝이니까 24번 줄에서 추가한 sVO가 그대로 담겨있다.
		//그래서 28번에서 추가한 sVO는 1번 인덱스에 담겼을 것이다.
		
		//이제 voList를 출력해보자
		for(StudentVO stu: voList) {//voList 안에 뭐가 들어있는지를 묻는 것이다. 뭐가들어있냐면 StudentVO가 들어있다.
			//개선된 for문에서는 stu가 voList의 방 안에 있는 그 자체의 값이 된다.
			System.out.println(stu.getName());///stu.getName(); 이 코드가 완전히 이해가 되는지 확인하기
		}									///이해가 안 되면 Arr_Prac1.java 다시 보기
		
		for (int i = 0; i < voList.size(); i++) {//배열은 length / ArrayList, Vector는 size()
			System.out.println(voList.get(i).getName());
			//개선된 for문에서는 stu가 voList의 방 안에 있는 그 자체의 값이 된다.
			//근데 그냥 for문에서는 그런 기능이 없다. 그러니까 voList의 i번째 방에 직접 접근해줘야 한다.
			//그래서 voList.get(i)를 사용해서 직접 접근 해줘야 한다.
		}
	}
}
