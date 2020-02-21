package ex02variable;

public class CharBooleanType {
	
	/*
	아스키코드 : 1byte로 표현할수 있는 문자(영문, 숫자)를 
		십진수코드로 정의한것을 말한다. 
		Ex) A => 65로 표현
			a => 97로 표현
			
	유니코드 : 1byte로 표현이 안되는 문자(한글, 한자 등)는 
		2byte가 필요하고, 이를 16진수로 정의한값을 말한다. 
	 */
	public static void main(String[] args) {
		
		/*
		char형 : 하나의 문자를 저장할수 있는 자료형으로 값을 저장할때
			'(Single Quotation)으로 감싸서 표현한다. 
			만약 "(Double Quotation)으로 감싸면 문자열로 인식하므로
			String형으로 선언해야 한다. 
		 */
		char ch1 = '가';
		//char chStr = '가나다라';[에러발생]문자열이므로 char에 대입불가함
		String chStr = "가나다라";
		System.out.println("ch1="+ ch1);
		System.out.println("chStr="+ chStr);
		
		/*
		char형 변수는 내부적으로 저장될때 아스키코드를 통해 저장되므로
		아래와 같은 연산이 가능하다. 
		 */
		char ch2 = 'A'; 
		int num1 = 2;
		int num2 = ch2 + num1; // 65+2=67
		System.out.println("num2="+ num2);//출력 : 67 
				
		char ch3 = (char)(ch2+num1);// A + 2
		System.out.println("ch3(문자출력)=>"+ ch3);//출력:C
		System.out.println("ch3(아스키코드출력)=>"+ (int)ch3);//출력:67
		
		char ch4 = '1';//숫자가 아니라 문자 1이므로 49로 저장된다.
		char ch4_1 = 49;
		System.out.println("ch4="+ ch4 
				+", ch4_1:"+ ch4_1);
		
		/*
		boolean형 : true 혹은 false 두가지의 값만 가질수 있는
			데이터형으로 산술연산(+,-,*,/)이나 비교연산(<,>,<=등)은
			사용이 불가능하다. 단 논리연산은 가능하다.(다음 챕터에서 학습)
		 */
		boolean bn1 = true;
		boolean bn2 = false;
		System.out.println("bn1="+ bn1 +", bn2="+ bn2);
	 
		/*
		&& : 논리And 연산으로 양쪽 모두 참일때 참을 반환한다. 
		 	나머지는 거짓을 반환한다. 
		
		|| : 논리Or 연산으로 둘중 하나만 참이면 참을 반환한다. 
			그리고 둘다 거짓일때 거짓을 반환한다. 
		 */
		boolean bn3 = bn1 && bn2;
		System.out.println("bn3="+ bn3); 
						      
		bn3 = '가' > 30000;// 가=> 유니코드 44032 이므로 true반환됨 
		System.out.println("bn3="+ bn3); 

	}

}
