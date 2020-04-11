package aTest0404.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aTest0404.MyCalcView;
//두 개 값을 비교해서 값이 같은 지를 비교한다면 어떻게 확인을 하면 될까?
class MyCalcViewTest {
	MyCalcView mv = new MyCalcView();
	@Test
	void testInitDisplay() {
		assertTrue(mv.initDisplay());
	}
	@Test
	void testMethodA() {
		//같은 지를 체크해주는 함수.두 값 비교(0과 뒤의 값이 같은 지 비교)
		assertEquals(0,mv.methodA(13, 3));
	}
}
