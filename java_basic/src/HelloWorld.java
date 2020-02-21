/*
주석	
- 컴파일의 대상에서 제외되는 문장을 의미한다.
- 본인이나 타인의 소스코드를 쉽게 분석할수 있도록 하기위해 사용된다.
- 형태1 : 블럭단위주석 */
	/*
		여러줄에 걸친 주석을 
		사용할 수 있다.
	 */
// -형태2 : 라인단위주석
//			한줄에 하나씩의 주석을 작성할 수 있다.

public class HelloWorld {
	
	/*
	항상 프로그램의 출발점은 main메소드(함수)로부터 시작된다. 
	자바런처를 통해 실행하게되면 자동으로 호출되어 동작하게 된다. 
	 */
	public static void main(String[] args) {
		
		System.out.println("Hello World~~!!");
		System.out.println("처음 만나는 Eclipse..!!");

	}

}
