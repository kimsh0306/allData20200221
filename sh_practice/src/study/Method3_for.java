package study;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Method3_for {

	/*
	 * main()
	 * 1. 숫자를 입력받는다.
	 * 2. numGame()을 호출하면서 입력받은 숫자를 파라미터로 넘긴다.
	 * 
	 * numGame()
	 * 1. 파라미터로 입력받은 숫자(이걸 정답으로 정한다.)를 맞추는 메소드이다.
	 * 2. 사용자가 숫자를 입력하고, 정답이 맞으면 맞았음을 출력하고 프로그램이 끝난다. 정답이 틀릴 경우 틀렸음을 출력하고 계속 진행한다.
	 * 3. 기회는 5번이다. 정답을 맞추지 못 했어도 기회가 끝나면 프로그램이 끝난다.
	 */
	
	void numGame(int dap) {
		
		for(int i=0;i<5;i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("숫자를 입력하세요:");
			int user = sc.nextInt();
			if (user==dap) {
				System.out.println("답이 맞습니다.종료합니다.");
				break;
			}else {
				System.out.println("답이 아닙니다.");
			}
		}
		System.out.println("기회가 끝났습니다.종료합니다.");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Method3_for m3 = new Method3_for();
		System.out.println("답을 입력하세요:");
		int dap = sc.nextInt();
		m3.numGame(dap);
	}
}
