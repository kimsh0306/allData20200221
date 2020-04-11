package study;

public class ForTest {
	/*
	연습문제] for문을 이용하여 1~10사이의 정수중 2의배수의 합을
	구하는 프로그램을 작성하시오. 
	 */
	
	public static void main(String[] args) {
		int hap = 0;
		for(int i=1;i<=10;i++) {
			if(i%2==0) {
				hap += i;
			}
		}
		System.out.println("1~10사이 2의배수의합:"+ hap);
	}
}