package gogo;

import java.util.Scanner;

public class TV {

	String color = null;
	boolean power = false;
	int channel = 2;
	
	
	/*********************************************************
	 * power의 경우 값에 상관없이 항상 반대의 값으로 변경해주면 되므로
	 * 굳이 if문을 사용하지 않아도 될 것 같아요
	 *********************************************************/
	
	void power() {
		power =!power;
	}
	void channelUp() {
		++channel;
	}
	
	void channelDown() {
		--channel;
	}
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("TV를 보시겠습니까?");
			Scanner scan = new Scanner(System.in);
			boolean isOk = scan.nextBoolean();
			TV tv = new TV();
			if(isOk) {
				System.out.println("true를 입력하셨군요");
				tv.power=true;
			}else {
				System.out.println("false를 입력하셨군요");
				tv.power=false;
			}
		
			tv.power(); //false => !false => true
			//현재 TV는 전원이 켜진 상태입니까?
			System.out.println(tv.power);//true
			
			
			if(tv.power) {
				System.out.println("현재 TV를 시청중입니다.");
			}
			else {
				System.out.println("아무도 TV를 보고 있지 않아요.");
			}
			
		}
		
		
		
	}

}
