package ex03operator;

public class BitOperator {

	/*
	비트연산자 : 자료를 bit단위로 논리 연산한다.
	 	& : And. 좌우가 둘다 1일때만 1을 반환. 나머지는 0
	 	| : Or. 좌우 둘중 하나만 1이면 1을 반환. 둘다 0일때 0반환.
	 	^ : 둘이 같으면 0, 다르면 1을 반환
	 	~ : 반전된 값을 반환. 1이면 0, 0이면 1 반환.	 	
	 */
	public static void main(String[] args) {

		int num1 = 5;//00000000 00000000 00000000 00000101
		int num2 = 3;//00000000 00000000 00000000 00000011
		int num3 =-1;//11111111 11111111 11111111 11111111
					// -1이 위와같은 이유는 1과 더했을때 0이되기 때문이다.
		
		System.out.println("비트AND:"+ (num1 & num2));//결과1
		System.out.println("비트OR:"+ (num1 | num2));//결과7
		System.out.println("비트XOR:"+ (num1 ^ num2));//결과6
		System.out.println("비트Not:"+ (~num3));//결과0

	}

}
