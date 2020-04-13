package ex04controlstatement;
/*
문제3] 다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.
파일명 : Qu_09.java
출력]	
* * * * *
* * * *
* * *
* *
*
*/
public class Qu_09 {

	public static void main(String[] args) {
		
		final int FLOOR = 10;//층을 나타내는 변수
		
		/*
		해당 모양을 출력하기 위한 일반식
			y = 층 - x + 1
			즉, 층이 증가할때 y는 감소하게된다. 
		 */
		for(int x=1 ; x<=FLOOR ; x++) {
			for(int y=1 ; y<=(FLOOR-x+1) ; y++) {
				
				System.out.print("*");
			}			
			//한개의 층을 출력한후 줄바꿈 처리
			System.out.println();
		}
	}
}
