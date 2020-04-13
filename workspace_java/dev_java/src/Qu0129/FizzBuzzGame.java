package Qu0129;

public class FizzBuzzGame {
	//if문으로 처리하기
	
	public void ifTest() {
		System.out.println("if");
		//for(초기화;조건식;증감식) {
		for(int i=1; i<=100; i++) {//1부터 100까지 센다 -while문
			if(i%35==0) {
				System.out.println(i+" = FizzBuzz");
			}else if(i%5==0) {
				System.out.println(i+" = Fizz");
			}else if(i%7==0) {
				System.out.println(i+" = Buzz");
			}else {
				System.out.println(i);
			}
		}
	}
	
	public void swichTest() {
		//switch문으로 처리하기
		int i=1;
		while(i<=100) {
			switch(i%35) {
				case 0: //1가지
					System.out.println(i+"=FizzBuzz");
					break;
				case 5: case 10: case 15: case 20: case 25:
				case 30: //2가지
					System.out.println(i+"=Fizz");
					break;
				case 7: case 14: case 21: case 28: //3가지
					System.out.println(i+"=Buzz");
					break;
				default : //4가지
					System.out.println(i);
			}//end of switch
			i++;
		}//////////////end of while
	}///////////////////end of swichTest
}
