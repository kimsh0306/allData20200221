package ex04controlstatement;

import java.io.IOException;
import java.util.Scanner;

/*
do ~ while문
	: 반드시 한번은 실행해야 할 경우 사용하는 반복문.
	즉 조건의 검사없이 무조건 한번은 실행된다. 
	형식
		반복을 위한 초기값;
		do {
			조건에 만족할때의 실행문장;
			증감식;
		}while(조건식); <- 반드시 ;(세미콜론)으로 마무리한다.
 */
public class DoWhile {

	public static void main(String[] args) throws IOException {
	 
		int sum = 0; 
		int i = 1;
		do { 
			sum += i;
			//System.out.println("i="+i);//확인용			
			i++;
		}while(i<=10);
		System.out.println("1~10까지의 누적합:"+ sum);
		
		
		/*
		연습문제] 1부터 1000까지의 정수중 4의배수이거나 7의
		배수인 수의 합을 구하여 출력하는 프로그램을 작성하시오.
		단, do~while문을 사용해야 한다. 
		 */		
		int total = 0;
		int j = 1;		
		do {			
			if(j%4==0 || j%7==0) {
				System.out.println("j="+ j);
				//찾은 j를 total에 누적해서 더함.
				total += j;
			}
			j++;
		}while(j<=1000);
		
		System.out.println("1~1000사이 4or7의 배수합:"+ total);
		
		
		/*
		시나리오]국어, 영어, 수학 점수를 사용자로부터 입력받은 후
		평균을 구해 A~F학점을 판단하여 출력하는 프로그램을 작성하시오.
		단, 사용자가 X,x(대소문자 구분없음)를 입력하면 프로그램이 
		종료되어야 하며 do~while문으로 구현해야 한다. 
		 */
		 Scanner scanner = new Scanner(System.in);
		 int kor, eng, math, avg;
		 int exitCode;
		 do {
			System.out.print("국어점수:");		
			kor = scanner.nextInt();
			System.out.print("영어점수:");
			eng = scanner.nextInt();
			System.out.print("수학점수:");
			math = scanner.nextInt();
			
			avg = (kor+eng+math) / (3 * 10);
			switch(avg) {
			case 10: case 9:
				System.out.println("A학점");break;
			case 8:
				System.out.println("B학점");break;
			case 7:
				System.out.println("C학점");break;
			case 6:
				System.out.println("D학점");break;
			default:
				System.out.println("F학점");break;
			}
			 
			System.out.println("종료하려면 x(X)를 입력하세요.");
			System.out.println("계속하려면 아무키나 입력하세요.");
			exitCode = System.in.read();
			 
		 }while(!(exitCode=='x' || exitCode=='X'));
		 
	}

}
