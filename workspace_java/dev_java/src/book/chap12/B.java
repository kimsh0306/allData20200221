package book.chap12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

//상속관계가 없으면 메소드 오버로딩

/*
 * 메소드 오버로딩은 무조건 파라미터의 갯수나 파라미터 타입이 달라야 한다.
 * 이것은 자바언어가 같은 이름의 메소드를 여러 개 운영할 수 있도록 지원하기 위해서 
 * 추가된 규칙이다. => 규칙을 지키지 않으면 컴파일 에러가 발생한다.
 */
public class B {
	void methodA(Collection<String> col) {
		System.out.println("methodA(Collection)호출 성공- #16");
	}
//	void methodA(List<String> li) {
//		System.out.println("methodA(List)호출 성공- #19");
//	}
//	void methodA(ArrayList<String> al) {
//		System.out.println("methodA(ArrayList)호출 성공- #22");
//	}
	void methodA(Vector<String> v) {
		System.out.println("methodA(Vector)호출 성공- #25");
	}
}