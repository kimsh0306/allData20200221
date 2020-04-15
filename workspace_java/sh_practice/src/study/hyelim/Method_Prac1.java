package study.hyelim;

import java.util.Scanner;

public class Method_Prac1 {

	/*
	 * 파라미터는 왜 쓰는 걸까? 필요한 지 안 필요한 지 어떻게 알 수 있을까?
	 * 
	 *  어떤 정보가 메소드 안에서 결정된다면.. 필요 없다.
	 *  
	 *  어떤 정보를 받아서 그걸 조작하는 메소드라면.. 필요 하다.
	 *  
	 *  결국.... 밖에서 값을 받아와야 뭔가 수행이 되는지 안에서 결정이 되어도 되는지.........
	 *  이걸 고민해보면 될 것 같아요..!
	 */
	
	/*
	 * Q01.
	 * 인원 수를 입력받고, 그 인원 수 만큼 성적을 입력 받는 메소드를 만들어라.
	 * 
	 */
	/*
	 * 1. 숫자 두 개를 입력 받고, 그걸 더해주는 메소드
	 * 
	 * 2. 받은 값을 출력해주는 메소드
	 * 
	 */
	public void q01_1(int inwon) {
		
//		inwon으로 뭔가를 할 수 있다.
		int[] score = new int[inwon]; //inwon의 크기만큼 배열을 만드니까
		Scanner scan = new Scanner(System.in);//스캐너 인스턴스화. 이제 스캐너를 사용할 수 있게 된 것이다.
		//이제 인원 수만큼 성적을 입력받아야 한다.
		for (int i = 0; i < score.length; i++) {//score.length말고 inwon을 적어도 된다.
			score[i] = scan.nextInt();//score 배열의 0번째 방을 초기화 시켰다. 스캐너로 입력 받은 값으로 초기화 시킨 것이다.
		}
	}
	
	public void q01_2() {
		
		Scanner scan = new Scanner(System.in);//스캐너 인스턴스화. 이제 스캐너를 사용할 수 있게 된 것이다.
//		inwon으로 뭔가를 할 수 있다.
		int inwon =  scan.nextInt();//메소드 안에서 인원 수가 결정되었다. 그러니까 파라미터는 필요가 없는 것이다.
		int[] score = new int[inwon]; //inwon의 크기만큼 배열을 만드니까
		//이제 인원 수만큼 성적을 입력받아야 한다.
		for (int i = 0; i < score.length; i++) {//score.length말고 inwon을 적어도 된다.
			score[i] = scan.nextInt();//score 배열의 0번째 방을 초기화 시켰다. 스캐너로 입력 받은 값으로 초기화 시킨 것이다.
		}
	}
	
	public static void main(String[] args) {
		Method_Prac1 mp1 = new Method_Prac1();
		Scanner sc = new Scanner(System.in);
		mp1.q01_1(sc.nextInt());//main에서 인원 수가 결정되었다.
	}
}