package ex03operator;

public class BeekyoOperator {
	
	/*
	비교연산자
		: 좌우측항의 값이 크거나, 같거나 한지 비교하는 연산자
	 */
	public static void main(String[] args) {

		int num1=10, num2=20;
		
		/*
		num1이 클때 true(참)을 반환한다. 현재 조건은 거짓이므로
		else 구문이 실행된다. 
		 */
		if(num1 > num2) {
			System.out.println("num1이 더 큽니다.");
		}
		else {
			System.out.println("num2가 더 큽니다.");
		}
		
		/*
		num1과 num2가 다를때 true를 반환하므로 if구문이 실행된다. 
		 */
		if(num1 != num2) {
			System.out.println("num1과 num2는 다르다.");
		}
		else {
			System.out.println("num1과 num2는 같다.");
		}

	}

}
