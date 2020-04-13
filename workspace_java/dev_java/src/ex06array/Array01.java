package ex06array;

/*
 * 1차배열, 2차배열 - 초기화하기, 꺼내서 사용하기
 * 배열에 담긴 정보를 꺼낼 수 있다.(반복문과 조건문 활용)
 * 개선된 for문 연습 - 컬렉션 프레임워크
 * 객체배열 따로 정리하기
 * 
 * 성적처리 방법
 * jumsus[i][j]
 * 변수 i는 row수 - 사람 구분
 * 변수 j는 column수 - 과목 구분
 * 총점 구하기 
 * for문 한개로 가능하다 | 아니다
 * 만일 아니다 2개일 것이다.
 * 만일 강호동의 총점을 구한다면 i가 고정된 상태에서 j가 변해야 한다.| 아니다.
 * 
 * 메소드를 사용할 것인가?
 * 1단계 - main메소드 안에만 코딩한다.
 * 2단계 - 메소드로 꺼내어 보기
 * 
 * 총점과 평균 규하기에 배열을 사용할 것인가?
 * 총점
 * int korTotal =0;
 * int engTotal =0;
 * int mathTotal =0;
 * 
 * 평균은 계산한 결과를 바로 출력하기
 */
public class Array01 {

	
	
	static int[][] arr= {
			{100,80,90},//강호동
			{60,70,90},	//유재석
			{80,70,70},	//강감찬
			{90,90,90},
			{80,80,80},
	};
	
	static String[] names ={"강호동","유재석","강감찬","김유신","이성계"};
	static String[] title = {"이름","국어","영어","수학","총점","평균","석차"};
	
	
	static int total[]=new int[5];
	static int rank[]=new int[5];
	
	
	public static void main(String[] args) {
			int kortot=0;
			int engtot=0;
			int mathtot=0;
			int nameTot=0;
			
			//타이틀 찍기
			for(int i=0; i<title.length; i++) {
				System.out.printf("%-10s",title[i]);
			}
			System.out.println();
			System.out.println("================================================");
			
			
			//점수 찍기
			for(int i=0; i<arr.length; i++) {
				//total=0;
				//System.out.print(names[i]);     //학생이름
				System.out.print(i+1);
				
				for(int j=0; j<arr[1].length; j++) {
					System.out.printf("%7d",arr[i][j]);
					total[i]+=arr[i][j];   //학생 총점 구하기
				}
				
				
				System.out.println("   "+total[i]+"    "+(double)total[i]/arr[i].length);
			}
			
	
			  
					
			
			//과목 총점구하기  (변수로 처리함) -> (나중에 배열로 처리)			
			
			//총점 국어
			for(int j=0; j<5; j++) {
					kortot += arr[j][0];  //국어의 합
					engtot += arr[j][1];  //영어의 합
					mathtot += arr[j][2]; //수학의 합
				}
			
	
			  
			  
			System.out.println("================================================");
			System.out.println("총점:  "+kortot+"    "+ engtot+"    "+mathtot);
	
			//석차
			  for(int i = 0 ; i < 5 ; i++){
				  	
				   for(int j = 1; j < 5 ; j++){
					   if(total[i] < total[j]) {
						   rank[i] = rank[i]+1;
					   }
				       else if(total[i] == total[j])
				    	   rank[i] = rank[i];
				   		}
				   System.out.print("석차:"+(rank[i]+1));
				  }
	} //end of main
}//end of class
