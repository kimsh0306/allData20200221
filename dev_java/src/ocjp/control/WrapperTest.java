package ocjp.control;
//객체지향적 언어 - JAVA
//절차지향적 언어 - C언어 - 순서대로 실행됨

/*
 * 변수의 종류
 * 1. 원시형타입(primative data type) -부르면 값이 반환됨
 * 		참조형 타입이 아니라서 변수나 메소드를 누릴 수 없다.
 * 2. 참조형타입(reference data type) -Sonata, String, Tivoli - 부르면 주소번지가 반환됨
 */
public class WrapperTest {
	
	int i;
	
	static void methodA() {
		//int i = new int();
		Integer i = new Integer(10);
		//오토박싱 개념추가 
		//변수 i는 클래스급이고 변수 j는 원시형타입 이라서 서로 급이 다름
		int j= i;
		//오토박싱이 나오기 전에는 반드시 래퍼클래스 타입을 원시형타입으로 바꾸어 주는
		//메소드를 태워야 했음.
		j=i.intValue();
		
		Boolean b = new Boolean(false);
		boolean b1 = b;  //jvm 오토박싱
		//오토박싱 나오기전
		
		
		String str = "false";
		Boolean b2 =Boolean.valueOf(str);
		//if(str) [에러]
		  if(b2); //이런 차이가 있다
	}
	public static void main(String[] args) {
		
		//원시형 타입에는 8가지가 있다.  부르면 값이나옴
		//int, boolean, double	
		//Wrapper클래스라고 함        참조형 타입   부르면 주소값이 나옴   .다트연산자 사용가능
		//Integer, Boolean, Double
		//원시형 타입인 int에도 메소드를 가지게 하고 싶다.
		
	}

}
