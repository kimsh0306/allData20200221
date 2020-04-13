package Falcon;

import java.util.Scanner;

public class F37_Array {

	public static void main(String[] args) {
		String[] name = new String[3];
		
		name[0] = "Falcon";
		name[1]	= "Spider";
		name[2]	= "Killer";
		
		Scanner sc = new Scanner(System.in);

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
