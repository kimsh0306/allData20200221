package ocjp.basic;

import java.util.Scanner;

public class Random {
	
	boolean game(int i_number, int count) {
		int i_random=((int)((Math.random()*100) %9));  //0~9  
		
			if(i_number==i_random) {
				System.out.println("축하합니다! 정답 입니다.");
				return true;
			}else {
				System.out.println("틀렸습니다.");
				System.out.println("정답은 "+i_random+"입니다.");
				System.out.println("남은 횟수 :"+count+"\n");
				return false;
			}
		}
		
	
	public static void main(String[] args) {
	
		Random random=new Random();
		
		for(int count=2; count>=0; count--) {
			System.out.println("0~9 정답 입력 :");
			Scanner scan = new Scanner(System.in);
			int result= scan.nextInt();
			
			boolean b =random.game(result,count);
			if(b==true) {
				count=0;
			}
		}
	}
}
