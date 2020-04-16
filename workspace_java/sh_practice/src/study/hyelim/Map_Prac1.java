package study.hyelim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Map_Prac1 {

	/*
	 * Map
	 * 
	 * VO랑 역할이 거의 똑같다. 역할 부분에서는 다른 점을 잘 모르겠다.
	 * 특징(공통점)이 뭐냐면
	 * 여러 개의 값을 하나의 장소에서 관리한다는 것.
	 * VO에서는 여러 변수를 선언 해놓고 관리한다.
	 * Map에서는 키 값과 value값을 여러 쌍 만들어놓고 관리한다.
	 * 
	 * Map 생성
	 * Map<String, Object> rMap = new HashMap<>();
	 * 이렇게 생성한다. Map은 List와 마찬가지로 인터페이스라서 단독으로 인스턴스화 할 수 없다.
	 * Map<String, Object> rMap = new Map<>();
	 * 이렇게 할 수 없다는 말이다.
	 * Map<키의 타입, value의 타입> 변수명 = new HashMap<>(); 이 형식이다.
	 * 수업에서 보통 키의 타입은 String, Value 타입은 Object로 했다.
	 * 키는 사람이 알아보기 쉽게 "name", "age", "gender" 이런 식으로 직관적으로 설정하려고
	 * String 타입으로 한 것이다. 키 값이 만약 1, 2, 3 이라면 그 키와 세트인 value 값이 뭐인지
	 * 모르니까 String 타입으로 해서 보기 쉽게 선언한 것이다.
	 * 
	 * Value를 Object 타입으로 선언한 이유는 하나의 Map 안에서 여러 개의 정보를 관리할 건데
	 * 그 각각의 정보가 타입이 한 가지가 아닐 수 있기 때문이다. 예를 들어 한 사람의 정보를 관리하는 Map을
	 * 만든다면 나이(int), 이름(String), 운전면허 있는지(Boolean) 이런 식으로 타입이 int 타입 또는 String 타입 이렇게
	 * 하나로 통일 되는 것이 아니라 다 다르기 때문에 모든 자료형을 한 번에 담아줄 수 있는 최상위 클래스..?인 Object를 사용한 것이다.
	 * 
	 *  Map에 값을 담으려면 put 메소드를 사용하면 된다.
	 *  rMap.put(키 값, value 값);
	 *  rMap.put("name", "혜림");
	 *  rMap.put("age", 23);
	 *  rMap.put("drive", true); //boolean타입.. 사실 한 번도 안 써 봄 헤헤
	 *  
	 *  이렇게 하면 rMap에는 세 쌍의 정보가 담겨있다. 이걸 꺼내보자
	 *  rMap.get(키값); 하면 된다.
	 *  rMap.get("name"); 하면 "혜림"이 반환될 것이다.
	 *  이 때, 이 반환 값의 타입은 무엇일까? >> Object이다.
	 *  왜냐면, rMap을 선언 할 때 Value 타입을 Object로 했기 때문이다.
	 *  그래서 String name = rMap.get("name"); 할 수 없다.
	 *  String 타입 변수에 저장하고 싶다면
	 *  String name = (String)rMap.get("name");
	 *  이렇게 형변환 해서 넣어줘야 한다.
	 * 
	 */
	
	public static void main(String[] args) {
		
		Map<String, Object> rMap =  new HashMap<String, Object>();
		List<Map<String, Object>> mList = new ArrayList<Map<String,Object>>();
		/*
		 * 국어 : 90
		 * 수학 : true
		 * 영어 : 통과
		 */
		//key 값은 put하면서 결정된다.
		//key 값을 변수 이름이라고 생각하면 좀 쉬울까..?
		rMap.put("국어", 90);
		rMap.put("수학", true);
		rMap.put("영어", "통과");
		mList.add(rMap);//69번에서 rMap을 새로 만든다. 없어지기 전에 mList에 담아주자.
		
		rMap = new HashMap<String, Object>(); //rMap을 새로 만드는 이유.. 중요하다..!***	
		rMap.put("국어", 80);
		rMap.put("수학", false);
		rMap.put("영어", "실패");
		mList.add(rMap);
		
		
		//mList를 개선된 for문으로 출력을 해보자
		for(Map<String, Object> m : mList) {
			//형 변환 꼭 해주기
			int korean = (int)m.get("국어");
			boolean math = (boolean)m.get("수학");
			String english = (String)m.get("영어");
			
			System.out.println(korean + ", " + math + ", " + english);
		}
	}
	
}
