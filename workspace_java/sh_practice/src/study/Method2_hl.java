package study;

import javax.swing.JOptionPane;

public class Method2_hl {


	public int[] getRank() {
		
		int inwon = Integer.parseInt(JOptionPane.showInputDialog("몇 명입니까?"));
		int[] score = new int[inwon];	//점수를 담을 배열
		int[] rank = new int[inwon];	//점수를 비교한 후 석차를 담을 배열
		for (int i = 0; i < inwon; i++) {
			score[i] = Integer.parseInt(JOptionPane.showInputDialog((i+1)+"번째 사람의 점수를 입력하세요."));
		}
		for (int i = 0; i < score.length; i++) {
			int cnt = 1;
			for (int j = 0; j < score.length; j++) {
				if(i!=j) {
					if(score[i]<score[j]) {
						cnt++;
					}
				}
			}
			rank[i] = cnt;
		}
		
		return rank;
	}
	
	public void printRank(int[] rank) {
		for (int i = 0; i < rank.length; i++) {
			System.out.println((i+1)+"번째 사람의 석차 : " + rank[i]);
		}
	}
	
	public static void main(String[] args) {
		Method2_hl m2 = new Method2_hl();
		m2.printRank(m2.getRank());
	}
	
}
