package ex02variable;

public class JunsuType {

	public static void main(String[] args) {
		
		/*
		정수자료형
		-byte, short, int, long 타입(형)이 있다.
		-각 자료형의 표현범위는 교안을 참조한다.
		-일반적으로 CPU(중앙처리장치)는 정수형 연산을 할때 int형을 가장
		빠르게 처리한다. 
		-즉 정수형 변수는 대부분 int형을 사용한다. 
		 */
		int int1 = 100;
		int int2 = 200;
		int result1 = int1 + int2;		
		System.out.println("int1 + int2 = "+ result1);//결과:300
		
		result1 = int1 / int2;		
		System.out.println("int1 / int2 = "+ result1);//결과:0
					
		/*
		-int보다 작은자료형을 연산하면 컴파일러는 int형으로 자동형변환한다.
		-byte, short는 게임케릭터의 움직임의 표현이나 음원정보등을 저장할때
		사용한다. 
		 */
		byte byte1 = 50, byte2 = 55;
		int result2 = byte1 + byte2;//byte형+byte형 = int형
		System.out.println("byte1 + byte2 = "+ result2);
		
		short short1 = 60, short2 = 70;
		int result3 = short1 + short2;//short형+short형 = int형
		System.out.println("short1 + short2 = "+ result3);
		
		/*
		-동일자료형끼리의 연산은 동일자료형이 되는것이 기본 원칙이다.
		-큰자료형과 작은자료형을 연산하면 큰 자료형으로 자동형변환된다.(데이터의
		손실이 있기 때문)
		-단 byte와 short는 예외적인 상황으로 생각하면 된다. 
		 */
		long long1 = 1000, long2 = 2000;
		long result4 = int1 + long1;//int형 + long형 = long형으로 변환
		System.out.println("int1 + long1 = "+ result4);
		
		result4 = long1 + long2;//long형끼리의 연산은 기본규칙을 따른다. 
		System.out.println("long1 + long2 = "+ result4);
		
		
		//long long3 = 2200000000;[에러발생]out of range
		long long3 = 2200000000L;/*
			자바컴파일러(CPU)는 정수형상수를 기본적으로 int형으로
			간주하기 때문에 위와같은 경우는 접미사(l or L)을
			붙여서 int형이 아닌 long형이라는것을 컴파일러에게 
			알려줘야 에러가 발생하지 않는다. 
			이와같이 대입을 위해 입력하는 숫자도 자료형을 기반으로 
			메모리공간에 저장된다. 이를 가르켜 '리터럴'이라고 한다.
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
