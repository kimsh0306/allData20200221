package ex06array;

public class ArrayInit {

	public static void main(String[] args) {
		
		/*
		1차원배열, 2차원배열에 상관없이 크기가 지정된 경우에는 
		전체 요소가 0으로 채워진다. 
		 */
		int[] arr = new int[3];
		System.out.println("arr[0]="+ arr[0]);
		
		int[][] arr2 = new int[3][4];
		System.out.println("arr2[0][0]="+ arr2[0][0]);
		
		/*
		1차원 배열의 경우 요소의 갯수를 통해 전체 크기가 결정된다. 
		2차원 배열의 경우 가장 큰 요소의 갯수에 의해 크기가 결정되므로
		아래와 같이 자리수가 부족한 경우 null값으로 채워지게 된다. 
		 */
		int[] arrDim = {1, 2, 3};
		System.out.println("arrDim[0]="+ arrDim[0]);
		
		int[][] arr2Dim = {
				{1},
				{2,3}
		};
		System.out.println("arr2Dim[0][0]="+ arr2Dim[0][0]);
		System.out.println("arr2Dim[0][1]="+ arr2Dim[0][1]);/*
					예외발생됨. 해당 요소는 null값이므로 출력이 불가능.
				*/
	}

}
