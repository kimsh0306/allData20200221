package ex02variable;
/*
연습문제] 국어,영어,수학 점수를 99, 80, 96점으로 입력하고
평균점수를 구해서 출력하는 프로그램을 작성하시오.
출력결과]
	99점,80점,96점의 평균점수는 XXX.XX점입니다.(실수형태)
	99점,80점,96점의 평균점수는 XXX점입니다.(정수형태)
 */
public class Qu_02 {

	public static void main(String[] args) {
		
		float korean=99, english=80, math=96;

		float avr = (korean + english + math) / 3;
		
		System.out.println("평균점수는 "+avr+"점입니다.");
		System.out.println("평균점수는 "+(korean + english + math) / 3+"점입니다.");
		System.out.println("평균점수는 "+(int)avr+"점입니다.");	

	}

}
