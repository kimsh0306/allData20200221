package study;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Method3_hl {

	public void numGame(int answer) {
		Scanner sc = new Scanner(System.in);
		boolean result = false;
		for (int i = 0; i < 5; i++) {
			System.out.print("숫자를 입력하세요 : ");
			int input = sc.nextInt();
			if(input == answer) {
				System.out.println("정답입니다.");
				result = true;
				break;
			}else {
				System.out.println("틀렸습니다.");
			}
			
		}
		if(!result) {
			System.out.println("기회가 모두 끝났습니다.");
		}
	}
	
	public static void main(String[] args) {
		
		Method3_hl m3hl = new Method3_hl();
		
		//형변환 연습
		String a = JOptionPane.showInputDialog("숫자를 입력하세요.");
		int num2 = Integer.parseInt(a);
		double num3 = Double.parseDouble(a);
		String st = Integer.toString(num2);
		//==
		int num = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력하세요."));
		m3hl.numGame(num);
	}
	
	
}
