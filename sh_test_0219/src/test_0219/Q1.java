package test_0219;
/*
 아래의 지시사항에 따라 작업을 진행하시오.
 1. 다음의 요구사항을 충족하는 프로그램의 소스코드와 결과화면 스크린 샷을 제출하시오
  [요구사항] 
  가. 자신이 태어난 년도인 숫자를 저장 할 수 있는 변수 year를 선언하고
      자신이 태어난 년도를 대입한다.     
  나. 자신의 나이를 저장할 수 있는 변수 age를 선언하고, 
     year 변수를 사용하여 자신의 나이를 
     계산하여 대입한다(공식:현재년도-태어난 년도)
     단,현재 년도는 Calendar클래스를 사용하여 구해야 한다
     그리고 age 와 year를 출력하여라
 */
import java.util.Calendar;


public class Q1 {
	Calendar c = Calendar.getInstance();
	
	int year = 1986;
	int thisYear = c.get(c.YEAR);
	int age = thisYear-year;
	
	public static void main(String[] args) {
		Q1 q1 = new Q1();
		int ty = q1.thisYear;
		int y = q1.year;
		int a = q1.age;
		System.out.println("age: "+a+", Year: "+y);
	}
}
