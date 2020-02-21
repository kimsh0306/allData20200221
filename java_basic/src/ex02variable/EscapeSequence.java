package ex02variable;

public class EscapeSequence {
	
	/*
	Escape Sequence(이스케이프 시퀀스) : 특정 형식에 맞게 출력하기
		위해 사용하는 문자로 \(역슬러쉬)를 붙히면 된다. 
	 */
	public static void main(String[] args) {
		
		/*
		\t : 탭(tab) 기능. 스페이스 4칸이 띄워짐.
		 */
		System.out.println("4월엔 벚꽃~~!");
		System.out.println("4월엔\t벚꽃~~!");
		
		/*
		\n : 줄바꿈(Line feed) 기능
		 */
		System.out.print("KOSMO에 오신걸 환영합니다.\n");
		System.out.print("열심히\n해봅시다.\n");
		
		/*
		\" : 쌍따옴표를 표현하고 싶을때 사용
		 */
		//System.out.println("나는 "개발자"가 되고싶어요");
		System.out.println("나는 \"개발자\"가 되고싶어요");
		 
		/*
		printf()문 : 문자열을 서식에 맞춰서 출력해야할때 사용한다.
		서식문자
			%d : 정수값 출력
			%f : 실수값 출력
			%s : 문자열 출력
			%c : 문자 출력
			%n : 줄바꿈 기능으로 \n과 동일함
		 */
		int kor=81, eng=97, math=79;
		System.out.printf("국어:%d, 영어:%d, 수학:%d%n",
				kor, eng, math);
		System.out.println("\n국어:"+ kor +", 영어:"+ eng
				+", 수학:"+ math);
		
		double avg = (kor+eng+math) / 3.0;
		System.out.printf("평균점수:%f%n", avg);
		
		
		/*
		printf()문을 통한 서식문자열 출력시 자리수 지정하기
		Ex) %4d : 정수를 출력할때 전체자리수를 4자리고 표현
			%6.2f : 실수를 출력할때 전체자리수는 6자리, 소수이하 2자리 표현
			양수일때는 우측정렬, 음수일때는 좌측정렬 되어 출력
		 */
		System.out.printf("국어:%d, 영어:%d, 수학:%d,"
				+ " 평균:%f %n",	kor, eng, math, avg);
		System.out.printf("국어:%6d, 영어:%6d, 수학:%6d,"
				+ " 평균:%7.2f %n", kor, eng, math, avg);
		System.out.printf("국어:%-6d, 영어:%-6d, 수학:%-6d,"
				+ " 평균:%-7.2f %n",	kor, eng, math, avg);
				
	}

}
