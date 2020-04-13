package ex04controlstatement;

/*
문제2] 파일명 : Qu_02.java
세개의 숫자중 최대값을 구하는 프로그램을 작성하시오
샘플코드]
int n1=99, n2=150, n3=199;

 */
public class Qu_02 {

	public static void main(String[] args) {

		int n1=99, n2=150, n3=199;
		
		//비교의 대상이 될 기준값을 설정한다(보통은 첫번째값)
		int maxValue = n1;
		 
		//두번째값과 비교후 크다면 max값을 교체
		if(maxValue < n2) {
			maxValue = n2;
		}
		//세번째값과 비교후 크다면 max값을 교체
		if(maxValue < n3) {
			maxValue = n3;
		}
		
		System.out.println("최대값은:"+ maxValue);

	}

}






