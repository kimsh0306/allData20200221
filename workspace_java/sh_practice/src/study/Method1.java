package study;

import javax.swing.JOptionPane;

public class Method1 {

	public int[] gugudan(int dan) {
		int result = 0;
		int[] jj = new int[9];
		for(int j=1;j<=9;j++) {
			result = dan*j;	
			jj[j-1] = result;
		}
		return jj;
	}
	
	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog("구구단 몇 단을 출력 하시겠습니까?");
		int inputNum = Integer.parseInt(input);
		Method1 mt = new Method1();
		mt.gugudan(inputNum);
		
		
		//mt.gogodan(inputNum) => 반환 타입 자체이다. 배열 자체로 볼 수 있다.
		//mt.gogodan(inputNum)[0] => jj[0]과 같다.
		for(int i=0;i<9;i++) {
			System.out.println(inputNum+"단 :"+inputNum+"x"+(i+1)+"="+mt.gugudan(inputNum)[i]);
		}
		
		
		////////
		/*
		 * inputNum을 파라미터로 받아서 해당하는 구구단 출력하는 메소드 만들기
		 * 
		 * 예) inputNum이 4라면 4단이 출력되도록 한다.
		 * 
		 */
		

		
		
//		for(int i=2;i>9;i++) {
//			for(int j=1;j>9;j++) {
//				int result = i*j;
//			}
//		}
	}
	
}
