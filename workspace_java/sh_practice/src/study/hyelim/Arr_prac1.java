package study.hyelim;

public class Arr_prac1 {
	/*
	 * 배열 선언하기
	 * 자료형[] 배열명 = new 자료형[배열크기];
	 * 자료형 배열명[] = new 자료형[배열크기]; //선언부('=' 기준 왼쪽 부분)의 []의 위치는 상관 없다.
	 * 자료형 배열명[] = {##, ##, ##}; //이렇게 크기를 정하지 않고 값을 바로 넣어줘도 된다.
	 */
	
	public static void main(String[] args) {
		
		int[] number = new int[5];
		for (int i = 0; i < number.length; i++) {
			number[i] = i+1; 
		}
//		for(자료형 변수명 : 배열명) {
//			실행문
//		}
		//for문이 돌아가면서 num이 number 안에 있는 값 자체가 된다.
		//지금 방 안에 1, 2, 3, 4, 5 가 들어있으니까 num은 for문이 실행됨에 따라 
		//1, 2, 3, 4, 5가 대입된다. 그래서 num을 출력하면 number의 방 안에 있는 내용이 출력된다.
		for(int num : number) {
			System.out.print(num + " ");
		}
		
	}
}
