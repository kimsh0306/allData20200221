package ex05method;

import java.util.Scanner;

public class MethodBasic {
	
	/*
	메소드정의1 : 매개변수O, 반환값O 형태로 정의
	- 두개의 정수를 입력받아 합의 결과를 반환한다.
	 */
	public static int simpleFunc(int a, int b) {
		int sum = a + b;
		return sum;
	}		 
	
	
	
	
	/*
	메소드정의2 : 매개변수X, 반환값X 형태로 정의
	-매개변수 없이 이름을 입력받은후 namePrint()함수를 호출함.
	-반환타입이 없기 때문에 이 경우 void라고 반드시 명시해야 한다. 
	 */
	public static void menuPrint() {
		System.out.println("당신의 이름은 무엇인가요?");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();

		namePrint(name);
	}
	/*
	메소드정의3 : 매개변수O, 반환값X
	-반환값이 없는 경우에는 실행이 완료된 후 호출했던 지점으로 
	다시 돌아간다. 
	 */
	public static void namePrint(String n) {
		System.out.println("제 이름은 "+ n +" 입니다.");
	} 
	/*
	규칙
	-JAVA에서는 main메소드는 무조건 public static void로 선언하기로
	약속되어있다. 
	-static으로 선언된 메소드에서 다른 메소드를 호출하기 위해서는 호출되는
	메소드도 static으로 선언되어야 한다. 
	-메소드 호출후 반환값은 항상 호출한 위치로 반환된다. 이때 호출된 메소드는
	메모리에서 소멸된다. 반환값이 없는 경우에도 함수의 실행이 완료되면 호출한
	위치로 돌아온다. 
	 */
	public static void main(String[] args) {	
		
		/*
		메소드를 호출할때는 함수의 원형을 그대로 써주면 된다. 
		매개변수가 있다면 갯수만큼 포함시켜준다. 
		 */
		int result = simpleFunc(1, 2);
		System.out.println("1과2를 전달한 결과:"+ result);
		System.out.println("10과20를 전달한 결과:"+ simpleFunc(10, 20));
		
		menuPrint();				
	}
}
