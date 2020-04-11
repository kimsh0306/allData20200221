package study.hyelim;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class MethodQuiz_hl {
	/*
		Q.01
		정수를 2개 입력 받고, 작은 수부터 큰 수까지의 합 구하는 함수 만들기(함수 안에서 입력 받기) 
	 */
	public void quiz01() {
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("첫 번째 숫자를 입력하세요."));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("두 번째 숫자를 입력하세요."));
		/*
		 * JOptionPane.showInputDialog("메시지"); >> 이 메소드의 반환값은 String 타입이다.
		 * 이 코드를 수행했을 때 열리는 창에 입력한 값이 반환값으로 저장되는 것이다.
		 * 이 메소드에서 결국은 int타입 숫자가 필요한 것이기 때문에 Integer.parseInt() 메소드로 형변환 해준 것이다.
		 * 이 메소드에 String 타입을 넣으면 int 타입으로 반환 해준다.
		 */
		int imsi = 0;
		//입력 받은 두 수 중 어떤 수가 큰 수인지 작은 수인지 판별해야 한다.
		if(num1-num2>0) {//num1-num2가 양수라면 num1이 더 큰 것이다. imsi를 사용해서 num1과  num2의 값을 서로 바꿔주자.
			imsi = num1;
			num1 = num2;
			num2 = imsi;
		}
		int sum = 0;
		for (int i = num1; i <= num2; i++) {
			sum += i;
		}
		System.out.println("sum : " + sum);
	}

	
	/*
		 Q.02
		  사용자로부터 국, 영, 수 점수를 입력 받아 평균을 구한 후, 학점을 반환하는
		 메서드를 정의하시오.
		 (국, 영, 수 점수는 main에서 배열로 입력받기
		 입력 받은 후 함수를 호출하고, 함수의 호출이 끝난 후 main에서 학점 출력하기)
	 */
	public double quiz02(int[] score) {
		int sum = 0;
		double avg = 0.0;//double은 실수형. 즉 소수점이 있으므로 0이 아니라 0.0으로 초기화 하기
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		/*
		 * 배열 선언하기
		 * 자료형[] 배열명 = new 자료형[배열크기];
		 * 자료형 배열명[] = new 자료형[배열크기]; //선언부('=' 기준 왼쪽 부분)의 []의 위치는 상관 없다.
		 * 자료형 배열명[] = {##, ##, ##}; //이렇게 크기를 정하지 않고 값을 바로 넣어줘도 된다.
		 */
		avg = sum/score.length;
		//배열의 길이는 배열명.length이다.
		//추가적으로 ArrayList, Vector의 크기는 이름.size()로 구한다.
		
		return avg;
	}
	
	
	/*
		Q.03 
		 사용자로부터 2~9사이의 숫자 중 2개를 입력 받아 그에 해당하는 구구단을 출력하는 메소드를 작성하시오.(for문, while문 각각 만들어보기)
	 */
	public void quiz03_1() {
		
		int sNum = Integer.parseInt(JOptionPane.showInputDialog("몇 단부터 출력하시겠습니까?"));
		int eNum = Integer.parseInt(JOptionPane.showInputDialog("몇 단까지 출력하시겠습니까?"));
		
		for (int i = sNum; i <= eNum; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " * " + j + " = " + i*j);
			}
			if(i!=eNum)//마지막 단을 출력할 때 제외하고는 아래의 구분선을 넣어주기
				System.out.println("================");
			/*
			 * if문 조건이 충족되면 수행할 문장이 하나라면 중괄호를 쓰지 않아도 된다.
			 * 이렇게 if문에 중괄호를 붙이지 않은 상태에서 두 문장 이상을 넣어주면 처음 한 문장만 if문 조건 충족에 따른 수행문이 된다.
			 * System.out.println("+++++++++++++++++++++");
			 * 위의 문장을 if문 아래 "====...===" 출력문 아래 놓고 실행해보면 무슨 말인지 알 수 있다..!
			 * if문 조건이 충족되지 않으면(i!=eNum일 경우. 즉, 구구단을 다 출력 해서 ===를 출력할 필요 없을 경우)
			 * System.out.println("================"); >>> 이 문장은 출력 되지 않을 것이다.
			 * 하지만 그 아래 System.out.println("+++++++++++++++++++++"); >> 이 문장을 넣어놓으면
			 * 이건 실행이 된다.
			 * 헷갈리면 항상 중괄호 쓰자...! 
			 */
			}
		
	}
	public void quiz03_2() {
		
		int sNum = Integer.parseInt(JOptionPane.showInputDialog("몇 단부터 출력하시겠습니까?"));
		int eNum = Integer.parseInt(JOptionPane.showInputDialog("몇 단까지 출력하시겠습니까?"));
		while(sNum <= eNum) {
			int cnt = 1;//2단, 3단에 단 말고 곱하는 수
			while(cnt<=9) {
				System.out.println(sNum + " * " + cnt + " = " + sNum*cnt);
				cnt++;
			}
			if(sNum!=eNum)
				System.out.println("================");
			sNum++;
			/*
			 * 시작 수부터 끝 수까지 출력을 한다. 시작 수를 기준으로 while문을 돌고 나면 시작 수는 더이상 필요 없다.
			 * 그래서 시작수를 증가시켜서 다음 수로 넘어가게 하는 것이다. 다음 수로 넘어가다보면 끝 수와 일치되는
			 * 순간(sNum==eNum)이 있을 것이고, 그 순간까지만 while문을 돌고 빠져나간다.
			 * 다시 말하자면, 우선 시작 수는 끝 수보다 작다는 가정이 있다. 시작 수를 증가 시키면서 프로그램을 진행하는데
			 * 시작 수와 끝 수와 같을 때까지만 진행한다고 한다면 시작 수가 끝 수 이하일 때까지 코드를 반복하는 것이다.
			 * 그래서 while문 조건으로 (sNum <= eNum)을 쓴 것이다.
			 * 
			 */
		}
		
	}
	
	
	/*
		Q.04
		 인원 수를 매개변수로 전달 받아 인원 수만큼 나이를 입력받고, 그 나이의 합을 반환하는 메소드를 작성하시오.
	 */
	public int quiz04(int inwon) {
		int[] age = new int[inwon];//인원 수만큼 나이도 관리해주어야 한다. 그러니까 인원 수와 같은 크기로 배열을 만든다.
		int sum = 0;
		for (int i = 0; i < inwon; i++) {
			age[i] = Integer.parseInt(JOptionPane.showInputDialog((i+1) + "번째 사람의 나이를 입력하세요."));
			//i는 0부터 시작한다. 그냥 보기 좋게 i+1로 출력을 한 것이다. 이 경우, i가 실제로 1이 증가하지 않지만 i++, ++i를 적으면 i가 증가해서 for문에 영향을 끼치니까 조심하자.
			sum += age[i];
		}
		return sum;
	}
	
	
	/*
		Q.05
		여러 개의 숫자를 입력 받은 후 최대값을 구하는 메소드를 정의하시오. 단, 숫자의 개수는 매개변수로 전달받고 숫자의 개수만큼
		Scanner 클래스를 통해 입력받는다. 입력받은 숫자 중 최대값을 찾아서 반환하도록 정의한다. 
	 */
	public int quiz05(int num) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[num];
		int maxNum = 0;//최대값을 여기에 저장하자
		for (int i = 0; i < num; i++) {
			System.out.print((i+1) + "번째 숫자를 입력하세요.");
			nums[i] = sc.nextInt();
		}
		maxNum = nums[0];//우선 입력 받은 숫자들 중 첫 번째 숫자를 maxNum에 담아둔다.
		for (int i = 0; i < nums.length; i++) {
			if(maxNum<nums[i]) {//만약 최대값보다 nums[i]가 크다면
				maxNum = nums[i]; //nums[i]를 최대값으로 저장한다.
			}
		}
		return maxNum;
	}
	
	/*
	 	Q.06
	 	사용자로부터 두 개의 정수와 산술연산자(+, -, *, /) 하나를 입력 받아서 연산결과를 반환하는
		메서드를 작성하시오.
	 */
	public int quiz06() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		System.out.println("산술 연산자를 입력하세요. (+, -, *, / ) 중에 선택하세요.");
		String oper = sc.next();
		int result = 0;
		switch(oper) {//switch문에 String 타입도 올 수 있다. oper가 "+"라면, oper가 "-"라면, ... 이렇게 되는 것이다.
		case "+":
			result = num1+num2;
			break;	//switch문의 case에 break를 쓰지 않으면 해당 case 아래의 case들에 있는 코드도 모두 수행한다. 각 case마다 break문을 써주자!
		case "-":
			result = num1-num2;
			break;
		case "*":
			result = num1*num2;
			break;
		case "/":
			if(num2==0) {
				System.out.println("0으로는 나눌 수 없습니다.");
				break;//0으로는 더 나눌 수 없으니까 break문으로 switch문 빠져나가기. 프로그램이 끝난다.
			}
			result = num1/num2;
			break;
		}
		return result;
	}
	

	public static void main(String[] args) {
		MethodQuiz_hl re = new MethodQuiz_hl();
		System.out.println(re.quiz04(5));
	}

}
