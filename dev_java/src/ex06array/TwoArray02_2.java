package ex06array;

public class TwoArray02_2 {

	public static void main(String[] args) {
		
		int[][] arr2Dim = new int[3][4];
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<4; j++) {
				arr2Dim[i][j] = i+j;
			}
		}
		
		for(int n=0; n<arr2Dim.length; n++) {
			for(int m=0; m<arr2Dim[n].length; m++) {
				System.out.print(arr2Dim[n][m]+" ");
			}
			System.out.println();
		}
 
		
		
		/*
		�ó�����] ���� ������ ���� ���α׷��� �ۼ��Ͻÿ�.
		1. 2���� �迭�� �����Ѵ�. ����2, ����4
		2. ������ �̿��Ͽ� �迭�� �ʱ�ȭ�Ѵ�.
		3. �迭��ü��Ҹ� �Ű������� ���޵� ������ŭ 
			������Ų��. 
		4. �����Ǳ� ��, �� �迭�� ����Ѵ�. 
		5. ���� �޼ҵ������ �����Ѵ�. twoDimPlus()
		 */
		
		int[][] twoArray = new int[2][4];
		for(int i=0; i<twoArray.length; i++) {
			for(int j=0; j<twoArray[i].length; j++) {
				twoArray[i][j] = (int)(Math.random()*100);
			}
		}
		
		System.out.println("=�ʱ�ȭ��============");
		showArray(twoArray);
		
		twoDimPlus(twoArray,10);
		
		System.out.println("=�޼ҵ�ȣ����===========");
		showArray(twoArray);
		
		
	}

	
	
	static void showArray(int[][] arr2) {
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.printf("%-3d",arr2[i][j]);
			}
			System.out.println();
		}
	}
	
	static void twoDimPlus(int[][] arr2, int plusNum) {
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				arr2[i][j] += plusNum;
			}
		}
	}
}
