package ex03operator;

public class BitShiftOperator {
	
	/*
	비트이동연산자(Bit Shift Operator)
		: 자료의 비트를 좌측 혹은 우측으로 이동시키는 연산자
		좌측으로 shift시키면 2배씩 증가
		우측으로 shift시키면 2배씩 감소한다. 
	 */
	public static void main(String[] args) {
		
		/*
		00000000 00000000 00000000 00000010 => 2 
		00000000 00000000 00000000 00000100 => 2 << 1 = 4(2배증가) 
		00000000 00000000 00000000 00001000 => 2 << 2 = 8(4배증가) 
		 */
		System.out.println(2 << 1);
		System.out.println(2 << 2);
		System.out.println(2 << 3);
		
		int num = 8;
		int sh1=1, sh2=2, sh3=3;
		System.out.println(num >> sh1);//4
		System.out.println(num >> sh2);//2
		System.out.println(num >> sh3);//1

	}

}
