package test.d20200219;
/*
 * 1.	다음의 요구사항을 충족하는 프로그램의 소스코드와 결과화면 스크린 샷을 제출하시오.
		[요구사항] 
		가.	자신이 태어난 년도인 숫자를 저장 할 수 있는 변수 year를 선언하고
			자신이 태어난 년도를 대입한다.     
		나.	자신의 나이를 저장할 수 있는 변수 age를 선언하고, 
			year 변수를 사용하여 자신의 나이를 계산하여 대입한다(공식:현재년도-태어난 년도)
	 		단,현재 년도는 Calendar클래스를 사용하여 구해야 한다.
			그리고 age 와 year를 출력하여라
 */

import java.util.Calendar;

public class Test1 {

	public static void main(String[] args) {
		//static 공유, 공유된다는 건 원본이 하나라는 의미. 하나를 같이 나누어 사용하는 것.
		//리턴타입이 클래스 타입
		//메소드로 인스턴스화하는 방법이 있다.
		//.(다트연산자)누르고 기다리면 나오는 API => :다음에 리턴타입.
		int year = 0;
		year = 1996;
		int age = 0;
		int cyear = 0; //상수 싫어요.변수 좋아요. 
		cyear = 2020; 
		Calendar cal = Calendar.getInstance();	//Calendar클래스 이용하기
		cyear=cal.get(Calendar.YEAR);
		age = cyear-1986;
		System.out.println("age: "+age);
		System.out.println("year: "+cyear);
	}
}
