package ex06array;

import java.util.Random;

public class Array01_2 {
	
	public static void main(String[] args) {
		
		//난수생성방법1
		double rndNumber = Math.random(); //1을 넘지못함
		System.out.println("생성된난수[실수]:"+rndNumber);
		int intNumber = (int)(Math.random()*100); //강제 형변환
		System.out.println("생성된난수[정수]:"+intNumber);
		
		//난수생성방법2
		Random random = new Random();
		System.out.println("생성된난수:"+random.nextInt());
		System.out.println("=================================");
		
		
		
		/*
		 로또번호처럼 1~45사이의 난수를 생성하는 방법
		 1. 0.xxxx 형태의 난수를 정수로 변경하기 위해
		 	100(혹은 더 큰수도 상관없음)을 곱한후 int형으로 형변환한다.
		 2. 45로 %연산을 하여 나머지를 구한다. 이때 결과는 0~44가 된다.
		 3. 2번의 결과에 +1한다. 결과적으로 1~45 사이의 난수를
		 	생성할수 있게된다.
		 */
		System.out.println("1~45사이의 난수생성:"
				+((int)((Math.random()*100) %45)+1));
		
		System.out.println("=====================");
		int[] lottoNum = new int[6];
		for(int i=0; i<lottoNum.length; i++) {
			lottoNum[i] = (int)((Math.random()*100)%45)+1;
			
		}
		for(int i=0; i<lottoNum.length; i++) {
			System.out.printf("%d ",lottoNum[i]);
		}
	}
}
