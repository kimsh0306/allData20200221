package book.chap04;

import java.util.Random;
import java.util.Scanner;

/*
 * 0부터 9사이의 임의의 숫자를 채번하기
 */

public class RandomGame {
	static Random r =new Random();
	static int imsi=r.nextInt(10);
	
	static boolean Rg() {
		
		int count=2;
		while(count >= 0) {
			System.out.print("0~9 정답을 입력하세요 :");
			Scanner scan = new Scanner(System.in);
			int i_result = scan.nextInt();
			
			if(i_result==imsi) {
				System.out.println("축하합니다! 정답입니다.");
				return true;
			}
			else if(i_result>imsi){
				System.out.println("값을 더 낮추세요!!");
				System.out.println("남은 횟수는 "+count+"입니다.");
				count--;
			}
			else if(i_result<imsi) {
				System.out.println("값을 더 높이세요");
				System.out.println("남은 횟수는 "+count+"입니다.");
				count--;
			}
		} 
		System.out.println("게임에 패배하였습니다.");
		System.out.println("정답은 "+imsi+"이였습니다.");
		return false;
	}
	
	
	public static void main(String[] args) {
			Rg();
}
}
