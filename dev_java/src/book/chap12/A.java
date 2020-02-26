package book.chap12;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class A {
//클래스 A에서 B클래스의 메소드 네 개를 호출해 보자.
	public static void main(String[] args) {
		B b = new B();
		List<String> list			= new ArrayList<>();	//싱글스레드에서 안전 => 동기화 구현이 안 되어 있다.속도가 빠름.벡터보다.
		List<String> list2			= new Vector<>();		//멀티스레드에서 안전 => 동기화 구현 함.속도가 느림 예시)도서관,채팅방,단톡방 구현
		ArrayList<String> nameList	= new ArrayList<>();	//선언부가 생성부 타입이 같다.
		Vector<String> mailList		= new Vector<>();		//선언부가 생성부 타입이 같다.
		b.methodA(list);
		b.methodA(list2);
		b.methodA(nameList);
		b.methodA(mailList);
	}
}
