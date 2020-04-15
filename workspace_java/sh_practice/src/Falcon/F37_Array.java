package Falcon;

import java.util.Scanner;

public class F37_Array {

	public static void main(String[] args) {
		String[] name = new String[3];
		
		name[0] = "Falcon";
		name[1]	= "Spider";
		name[2]	= "Killer";
		
//		배열의 선언과 초기화를 동시에 하는 방법
//		String[] name = {"Falcon","Spider","Killer"};
		
		Scanner sc = new Scanner(System.in);
		//i가 0,1,2가 될 때까지 숫자를 입력 받아라.
		for(int i=0;i<3;i++) {
			//스캐너 속성 nextLine => 엔터를 감지해서 다음으로 넘어간다.
			name[i] = sc.nextLine();
		}
		sc.close();
		
		for(int i=0;i<3;i++) {
			System.out.println(name[i]);
		}
	}
}
