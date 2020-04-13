package ex06array;

public class TwoArray02_1 {

	public static void main(String[] args) {
		
		/*
		 �Ʒ��� ���� 2�����迭�� �ʱ�ȭ�ϸ� ����ũ��3, ����ũ��4�� �����ȴ�.
		 �ʱ�ȭ�� ��Ұ� ���� �κ��� null�� ä������ �ȴ�.
		 ��null�� : �ƹ��͵� ���� ���� �ϰ��´´�. �� �ݰ��� ���Ѵ�.
		 */
		int[][] arr= {
				{1,2},
				{3,4,5},
				{6,7,8,9}
		};
		/* 
		 2�����迭���� "�迭��.length"�� ����ϸ� ����ũ�Ⱑ ��ȯ�ȴ�.
		 */
		System.out.println("�迭�� ����ũ��:"+arr.length);
		
		/*
		 ������ ����ũ��� �ʱ�ȭ�� ���¿� ���� �ٸ��� �ִ�.
		 �Ʒ��� 0��->2, 2��->4�� ũ�⸦ ����Ѵ�.
		 */
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d����ũ��:%d\n",i,arr[i].length);
		}
		System.out.println("�迭 ����ϱ�");
		System.out.println("arr[0][1]="+arr[0][1]);
		/*
		ArrayIndexOutOfBoundsException ���ܹ߻���.
		��, �迭�� index�� �ʰ��ߴٴ� ��.
		System.out.println("arr[0][3]="+arr[0][3]);//���ܹ߻�
		*/
	}
}
