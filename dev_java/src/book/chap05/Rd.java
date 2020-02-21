package book.chap05;

import java.util.Random;
import java.util.Scanner;

public class Rd {
	int strike=0;
	int ball=0;
	
	int com[]=new int[3];
	int user[] =new int[3];
	Random rd = new Random();
	
	void game() {
	com[0]=rd.nextInt(10);
	
	do {
		com[1]=rd.nextInt(10);
	}while(com[0]==com[1]);
	
	do {
		com[2]=rd.nextInt(10);
	}while(com[0]==com[2] || com[1]==com[2]);
	}
	
	
	String user() {
			System.out.print("세자리수 입력");
			Scanner scan= new Scanner(System.in);
			String num3=scan.nextLine();
			
			return num3;
		}
		
	
	
	String result(String num) {
		int temp = Integer.parseInt(num);
		user[0] = temp/100;//123/100=1
		user[1] = (temp%100)/10;//2
		user[2] = temp%10;//3
		
		for(int i=0;i<com.length; i++) {
			for(int j=0; j<user.length; j++) {
					if(com[i]==user[j]) {
						if(com[i]==user[i]) {
							strike++;
						}else {
							ball++;
						}
					}
				
			}
		}
		return strike+"strike "+ball+"ball";
	}
	
	
	
	public static void main(String[] args) {
		Rd rd= new Rd();
		rd.game();
		System.out.println(rd.com[0]+" "+rd.com[1]+" "+rd.com[2]);
		System.out.println("===========================");
		String num3=rd.user();
		System.out.println(num3);
		
	

		
		String a=rd.result(num3);
		System.out.println(a);
	}
	
	
}
