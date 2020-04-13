package study;

import java.util.Scanner;

public class Gugudan{
		
	public void gugudan(int dan){
		for(int j=1;j<10;j++) {
			System.out.println(dan+"단:"+dan+"x"+j+"="+dan*j);
		}
	}	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("출력하고 싶은 구구단은:");
		
		//nextInt() => Int타입으로 받겠다.
		int gugu = sc.nextInt(); 
		
		//메인 메소드 안에 없는 메소드니까 인스턴스화
		Gugudan gu = new Gugudan();
		gu.gugudan(gugu);
		
		
/***************구구단 출력*******************
		for(int i=2;i<10;i++) {
			for(int j=1;j<10;j++) {
			System.out.println(i+"단:"+i+"x"+j+"="+i*j);
			}
			System.out.println("---------");
		}
 */
		
	}
}