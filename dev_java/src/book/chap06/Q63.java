package book.chap06;
//{ } 안에 변수가 선언되있으면 거기안에서만 사용가능하다. (지역변수)
public class Q63 {

	 public static void main(String[] args) {
		 int i=0;
		 for (;i<= 10;i++){
			 if(i>6) break; //i가 7이면   break; for문 밖으로 나감
		 }
		 //여기로 나감
		 System.out.println(i);  //오류  i가 for문 지역변수이므로 밖으로나가면 소멸
	}
} 

