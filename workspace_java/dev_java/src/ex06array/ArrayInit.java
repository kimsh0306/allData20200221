package ex06array;

public class ArrayInit {

	public static void main(String[] args) {
		/*
		 1�����迭, 2�����迭�� ������� ũ�Ⱑ ������ ��쿡��
		 ��ü ��Ұ� 0���� ä������.
		 */
		int[] arr = new int[3];
		System.out.println("arr[0]="+arr[0]);
		
		int[][] arr2 = new int[3][4];
		System.out.println("arr[0][0]="+arr2[0][0]);
		
		/*
		 1���� �迭�� ��� ����� ������ ���� ��ü ũ�Ⱑ �����ȴ�.
		 2���� �迭�� ��� ���� ū ����� ������ ���� ũ�Ⱑ �����ǹǷ�
		 �Ʒ��� ���� �ڸ����� ������ ��� null������ ä������ �ȴ�.
		 */
		int[] arrDim = {1,2,3};
		System.out.println("arrDim[0]="+arrDim[0]);
		
		int[][] arr2Dim = {
				{1},
				{2,3}
		};
		System.out.println("arr2Dim[0][0]="+arr2Dim[0][0]);
		System.out.println("arr2Dim[0][1]="+arr2Dim[0][1]);/*
				���ܹ߻�. �ش��Ҵ� null���̹Ƿ� ����� �Ұ���.
			*/
	}
}
