package book.chap06;

import javax.swing.JOptionPane;

public class P181 {

	
	void methodA() {
		System.out.println("methodA호출 성공");
	}
	public static void main(String[] args) {
		String input =JOptionPane.showInputDialog("숫자를 입력하세요.");
		//JOptionPane <<클래스타입 static타입
		int i =Integer.parseInt("20");
		//public static int parseInt(String s)
		//P181.methodA(); 메소드 선언시 static 을 사용하지않았으므로 에러
		//static이 없는 메소드를 호출할땐 반드시 인스턴스화 할것.
		//만일 static이 있다면 클래스 타입.메소드명
		P181 p181 = new P181();
		p181.methodA();
		System.out.println(Integer.parseInt(input)+10);
	}

}
