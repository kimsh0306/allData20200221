package study;

import java.util.Scanner;

public class Method2 {

	/*
	 * getRank()
	 * 1. 인원 수 입력 받기
	 * 2. 입력 받은 인원 수만큼 성적 입력받기
	 * 3. 석차를 구해서 입력 받은 순서대로 다시 저장시키기
	 * 	 3명이고, 100, 30, 70 을 입력 받았다면 1, 3, 2 를 저장시키기
	 * 4. 3번에서 저장한 값을 반환하기
	 * 
	 * printRank()
	 * 1. 입력받은 배열을 출력하기
	 *  
	 */
	
	
	public static void main(String[] args) {
		System.out.println("인원 수를 입력하세요:");
		Scanner sc = new Scanner(System.in);
		int su = sc.nextInt();
		System.out.println("인원 수는 "+ su+"명입니다.");
		sc.close();
		
		int sungjuk[] = new int[su];
		
		System.out.println("성적을 차례대로 입력하세요:");
		Scanner sj = new Scanner(System.in);
		
		//(입력받을 값, 몇일지는 모른다.)횟수가 정해져 있으면 for문을 쓴다.
		for(int i=1;i>=su;i++) {
			sungjuk[i] = sj.nextInt();
		}
		sj.close();
		
		for(int i=1;i>=sungjuk.length;i++) {
			System.out.println(sungjuk[i]);
		}
		
	}
	
}

