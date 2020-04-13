package book.chap02.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import book.chap02.Sonata;
/*
 * JUnit 단위테스트 도구 설치
 * 외부 테스트 클래스를 따로 작성하지 않아도 된다.
 * 단위테스트 제공하는 프레임워크
 * 어노테이션(@) 지원. 예시) @Test => 간결하게 처리할 수 있다.
 * 결과 체크할 때
 * 녹색이면 성공
 * 붉은이면 실패
 * 
 * assertEquals(a,b): a와 b의 값이 같은지 확인할 때
 * assertTrue: a가 참인지 확인할 때
 * assertNotNull: a가 null이 아닌지 확인할 때
 * 
 * 
 */
class SonataTest {
	//어노테이션이 의미하는 것은
	//아래 메소드가 단위테스트 대상 메소드라는 것을 지정해 주는 것.
	@Test
	void testMethodA() {
		Sonata myCar = new Sonata();
		//()안의 문장이 참인지 거짓인지 확인해주는 문법
		assertTrue(myCar.methodA(3, 3));
	}

}
