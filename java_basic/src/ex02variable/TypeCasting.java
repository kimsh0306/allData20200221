package ex02variable;

public class TypeCasting {

	public static void main(String[] args) {
		
		/*
		자동형변환 : 작은상자의 데이터를 큰상자에 넣을때는 
			자동으로 형변환이 일어난다. 
		 */
		byte b1 = 65;
		short s1;
		s1 = b1;// 작은 byte형이 큰 short형으로 자동변환됨.
		System.out.printf("b1은 %d, s1은 %d%n", b1, s1);
		
		/*
		아래코드는 자동형변환이 아님. CPU는 int보다 작은 자료형은 int로
		간주하고 연산을 진행하며, 결과도 int로 반환한다. 
		CPU의 특성이라 생각하자. 
		 */
		int num1 = b1 + s1;
		int num2 = num1;
		System.out.println("num1은 "+ num1);
		
		/*
		char형(문자타입)에 byte형(숫자타입)을 바로 대입할수 없다. 
		성질이 서로 다르므로 명시적 형 변환후 대입해야 한다. 
		 */
		//char ch1 = b1; 에러발생
		char ch2 = (char)b1;
		System.out.println("b1="+ b1 +", ch2="+ ch2);
		
		/*
		명시적형변환 : 큰상자의 자료를 작은상자의 자료형에 담아야 할때
			사용한다. 단, 이때는 데이터의 손실이 있을수 있으므로
			주의를 요한다. 
		 */
		short s2 = 100;
		byte b2 = (byte)s2;//100은 byte의 표현범위안에 있으므로 손실되지 않음.
		System.out.printf("데이터미손실:b2=%d, s2=%d\n",
				b2, s2);
	
		/*
		소수점 아래부분이 버려지므로 데이터 손실됨. 따라서 특수한 
		경우가 아니라면 사용을 자제하는것이 좋다. 
		 */
		int num3;
		double dl = 3.14;
		num3 = (int)dl;
		System.out.printf("데이터손실:num3=%d, dl=%.2f %n",
				num3, dl);
		
		
		char ch3 = 'A', ch4;
		int num4 = 2;
		/*
		char와 int를 연산하면 결과는 int이므로 아래문장은 에러가 
		발생된다. 여기서는 연산결과 전체를 char형으로 변환후
		대입해야 한다. 
		 */
		//ch4 = ch3 + num4; 에러발생
		ch4 = (char)(ch3 + num4);
		System.out.println("ch4="+ ch4);	
	}

}
