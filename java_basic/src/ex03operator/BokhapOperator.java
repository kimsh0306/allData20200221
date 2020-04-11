package ex03operator;

public class BokhapOperator {
	/*
	복합대입연산자
		: 산술연산자와 대입연산자를 연결해놓은 형태로 
		좌우측의 값을 연산하여 좌측의 변수에 대입하는 형태의 
		구조를 가진다. 
	 */
	public static void main(String[] args) {

		double e = 3.1;
		e += 2.1;	// 3.1 + 2.1 = 5.2
		e *= 2;		// 5.2 * 2 = 10.4
		e = e + e;	// e = 10.4 + 10.4 => 20.8
		System.out.println("e의 결과값:"+ e);
		
		/*
		※ 복합대입연산자의 경우 문법의 구조상 자동형변환이 일어나지
		않고 기존의 자료형을 유지한다. 
		 */
		int n = 5;
		//n = n * 2.7;[에러발생]계산의 결과가 double이 되므로 형변환해야한다.
		n *= 2.7;//[정상] 기존의 자료형을 유지한다. 단 결과는 13이된다.
		System.out.println("n의 결과값:"+ n);

	}

}
