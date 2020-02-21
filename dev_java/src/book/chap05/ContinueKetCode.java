package book.chap05;

import java.io.IOException;
import java.util.Scanner;

import javafx.scene.input.KeyCode;

public class ContinueKetCode {
	
	public static void main(String[] args) throws IOException{
		String input =null;
		while(true) {
			Scanner scan = new Scanner(System.in);
			input=scan.nextLine();
			System.out.println("keyCode :"+input);
			if(input.equals("q")) {
				break;//break를 만나면 if문을 탈출하는게아니라 while문 탈출
			}
		}
		System.out.println("종료");
	}
}
