package book.chap02;

public class SungJuk {
	/*
	 * 내 안에 있는 메소드라 하더라도 메소드 선언시 static이 없으면 main메소드에서
	 * 호출할 수 없다.
	 * 총점을 구해주는 메소드가 있다. 이름은 hap임.
	 * 피라미터가 있다 | 없다.
	 */
	int hap(int kor, int eng) {
		int tot = 0;
		tot = kor+eng;
		return tot;
	}
	//리턴값은 실수형으로 선언한다.
	//메소드 선언하기
	//반환타입 메소드이름(파라미터1,파라미터2,....)  ()가있으면 메소드이다.
	
	double avg(int tot,int subject) {
		return tot/subject;
	}//end of avg
	
	void prt(double avg) {
		System.out.println("두과목 평균값은 :"+avg+"입니다.");
	}
	
	/*  실행순서
	 * 31 -> 32 -> 33(국어점수) -> 34(영어점수) -> 35(호출) -> 10(33,34값이 복사됨) ->11~14(hap끝) ->
	   -> 37 -> 38 -> 19(tot 복사 가져감) -> 20,21 ->39
	 */
	public static void main(String[] args) {

		SungJuk sj=new SungJuk();
		int kor=90;
		int eng=65;
		int subject=2;
		int tot=sj.hap(kor,eng);
		System.out.println("두 과목 총점은 :"+tot);
		double avg=sj.avg(tot,subject);
		System.out.println("두과목 평균값은 :"+avg);
		
		//String m =sj.prt(avg);  void타입은 대입할수없음
		sj.prt(avg);
		
	}
}
