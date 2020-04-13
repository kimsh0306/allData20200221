package ocjp.basic;

import java.util.Scanner;

public class QuTest {
	
	//달의 무게 계산 메소드
	double moon(double d_ew) {
		return (d_ew*17)/100.0;
	}
	
	public static void main(String[] args) {
		System.out.print("당신의 지구 몸무게 입력 :");
		Scanner scan = new Scanner(System.in);
		double d_ew=0; //지구의 몸무게
		d_ew = scan.nextDouble();
		System.out.println("당신이 입력한 값은 "+d_ew+"kg");
		
		//달의 몸무게를 담기(dobue_moonWeight)
		double d_mw=0;
		d_mw=(d_ew*17)/100.0; //int연산 조심
		System.out.println("(메인)달의 몸무게 : "+d_mw +"kg 입니다.");
		
		
		//메소드 사용
		QuTest qutest = new QuTest();
		double d_moon=qutest.moon(d_ew);
		System.out.printf("(메소드)달의 몸무게 : %.2f"
				+ "kg 입니다.",d_moon);
		
	}
}
