package ex04controlstatement;

/*
for문 : while문과 같은 반복문으로 초기값, 조건식, 증감식이 한줄에 있어
	반복의 횟수를 명시적으로 알수있는 반복문이다. 사용빈도가 가장 높다.
	형식
		for(초기값 ; 조건식 ; 증감식){
			실행문장
		}
	실행순서
		초기값 -> 조건식 확인 -> 참일때 실행문장 실행 -> 증감식
			-> 조건식 확인......반복실행됨 -> 조건이 거짓일때 for문 종료
 */
public class For {

	public static void main(String[] args) {

		/*
		for문의 실행순서
		1. 반복을 위한 변수 i를 1로 초기화
		2. 조건검사(i가 5이하이면 참)
		3. 조건이 참일때 실행문장을 실행함
		4. 증가(감소)식 실행
		5. 조건검사(3,4,5번을 반복횟수만큼 실행함)
		6. 조건이 거짓일때 for문 종료
		 */
		for(int i=1 ; i<=5 ; i++) {
			System.out.println("i="+ i);
		}
		
		 
		int sum = 0;
		for(int j=1 ; j<=100 ; j++) {
			sum += j;
		}
		System.out.println("1~100까지의합:"+ sum);
		
		/*
		연습문제] for문을 이용하여 1~10사이의 정수중 2의배수의 합을
		구하는 프로그램을 작성하시오. 
		 */
		int total = 0;
		//방법1 : if문으로 구현
		for(int i=1 ; i<=10 ; i++) {
			if(i%2==0) {
				total += i; 
			}
		}
		System.out.println("1~10사이 2의배수의합:"+ total);
		
		total = 0;//초기화
		//방법2 : if문이나 삼항연산자 없이 구현
		for(int j=0 ; j<=10 ; j+=2) {//j=j+2
			total += j;
		}
		System.out.println("1~10사이 2의배수의합:"+ total);
		
		/*
		for문의 초기식에서 선언된 변수 j는 for문이 끝나는 순간
		메모리에서 소멸된다. 여기서 사용된 변수 j를 "지역변수(Local Variable)"라
		한다. 지역변수는 해당 지역을 벗어나면 소멸되는 특징을 가지고 있다.
		
		System.out.println("위 for문에서 선언한 변수 j="+ j);		
		*/
		
		//main 지역에서 선언한 변수이므로 접근가능
		System.out.println("위 main함수 지역에서 선언한 변수 total="+ total);
		
		
		/*
		for문의 초기값을 외부(넓은지역)에서 선언하게되면 해당 변수는
		for문 안쪽(좁은지역)에서 사용가능하다. 즉 아래에서 선언한
		변수 i는 main의 지역변수가 된다. 
		 */
		int i=0;
		for( ; i<=5 ; i++) {
			System.out.println("for문 안에서의 i값="+ i);
		}
		System.out.println("for문 밖에서의 i값="+ i);
		
			
		
		/*
		시나리오] 다음의 출력결과를 보이는 for문을 작성하시오
		출력결과
			0 0 0 1
			0 0 1 0
			0 1 0 0
			1 0 0 0
		해법 : x와 y를 더해서 5개 될때 1을 출력한다. 
		 */
		System.out.println("==증가연산자 사용으로 구현==");
		for(int x=1 ; x<=4 ; x++) {
			for(int y=1 ; y<=4 ; y++) {
				if(x+y==5) {
					System.out.print("1 ");
				}
				else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
		
		/*
		for문으로 무한루프 조건을 만들때 아래와 같이 사용
		하지만 무한루프의 조건을 사용할때는 주로 while문을 사용한다. 
		 */
//		for(;;) { 
//			System.out.println("나는 for문으로 만든 무한루프"); 
//		}
		 		
		
		/*
		for문의 끝에 ;를 사용하면 반복할 문장이 없는 경우로 간주된다. 
		 */
		for (int j=0 ; j<=5 ; j++); {
			//for문과 상관없이 한번만 실행된다.
			System.out.println("어랏!나는누구?");
		}
	 
		 
				
		
		
		
		
		
		
		
		
		
		
	}

}
