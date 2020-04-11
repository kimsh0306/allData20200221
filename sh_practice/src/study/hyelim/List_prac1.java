package study.hyelim;

import java.util.ArrayList;
import java.util.List;

public class List_prac1 {

	/*
	 * List는 인터페이스이다.(Java.Util) 그래서 단독으로 인스턴스화 할 수 없다.
	 * List li = new List(); 이게 안 된다는 것이다.
	 * 인터페이스는 원래 추상적인 애다. 애매하다는 것이다. 그래서 이 애매한 애로만은
	 * 새로운 객체를 생성할 수 없다. 새로운 객체를 생성한다는 것은 인스턴스화를 한다는 것이고,
	 * 인스턴스화를 한다는 것은 새로운 객체를 생성해서 어딘가 사용한다는 말이다. 어딘가에 사용하려먼,
	 * 당연히 애매하면 안 되겠지??!??! 
	 * 그러니까 List를 인스턴스화 하려면 구현체 클래스라는 것이 필요하다.
	 * List의 구현체 클래스는 ArrayList와 Vector가 있다.
	 * ArrayList는 싱글스레드에 안전하다. 속도가 빠르다. 스레드를 관리할 것이 아니라면
	 * ArrayList를 쓰는 것이 일반적인 것 같다.
	 * Vector는 멀티스레드에 안정적이다. 동기화 지원이 돼서 그렇다. 동시에 여러 개의 객체가
	 * Vector에 추가 되어도 순서가 잘 지켜진다는 말...아마도..
	 * 암튼.. 그거 말고는 다 똑같다.
	 * List<타입> arList = new ArrayList<>();
	 * List<타입> vList = new Vector<>();
	 * 이렇게 인스턴스화 하면 된다.
	 * <>는 다이아몬드 연산자라고 한다. 선언부에 적은 타입과 똑같이 적으면 되는데, 비워두는 것도 가능하다.
	 * 타입은 원시형타입이라고 하던가.. 암튼 클래스로 적어줘야 한다. 그래서 int가 아니라 Integer로 적어야 한다.
	 * ArrayList와 Vector는 기차..?라고 생각하자. 방이 여러 개 있고, 순서가 있는 것이다.
	 * 타입을 적을 때는 그 방안에 어떤 것을 넣을 것인지에 따라 달라진다. 최근에는 Map을 많이 넣었다.
	 * 그래서 List<Map<String,Object>> 이렇게 많이 썼었지..!
	 * String 타입을 담을 것이라면 List<String>이렇게 쓰면 된다. 이렇게 쓰면 기차처럼 생긴
	 * 방 안에 문자열만 담을 수 있다. 방 한 칸에 문자열이 하나씩 들어가는 것이다.
	 * 값을 담으려면 arList.add(____); 이렇게 하면 된다. 파라미터에 들어가는 값은 
	 * 당연히 선언할 때 적은 타입과 같아야 한다. String이면 String, VO면 VO, ...
	 * 값을 가져올 땐 arList.get(인덱스); 0번째 방의 값을 가져오려면 arList.get(0) 이렇게 쓰면 된다.
	 * Vector도 똑같다.
	 * 만약 arList의 0번째 방에 있는 아이와 1번째 방에 있는 아이를 더할 거라면
	 * arList.get(0) + arList.get(1) 이렇게 쓰면 된다.
	 * 
	 * 그냥 배열과 다른 점
	 * - 크기를 미리 정해주지 않아도 된다.
	 * - 크기가 유동적이다.
	 * 	- list 안에 들어있는 값을 remove 해도 오류가 발생하지 않는다.
	 * 		- List의 크기가 변해도 된다는 말이다.
	 * 	- 일반 배열에서는 초기화 같은 건 가능해도 중간에 값을 빼거나 할 수 없다.
	 * 
	 */
	
	/*
	 * Map
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		
		List<Integer> li = new ArrayList<Integer>();  
		
	}
	
}
