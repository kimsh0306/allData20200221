package ex06array;

public class Array01_1 {

	public static void main(String[] args) {
		/*
		 �ڹٿ����� �迭�� Ŭ������ ���� �����ϰԵȴ�.
		 ������ �迭�� ��(Heap)������ ����ǰ�, �Ҵ�� �޸���
		 �ּҰ��� ��ȯ�Ѵ�. �׷��� �迭��(�迭����)�� �ּҰ�(������)��
		 �Ҵ�ް� �ȴ�.
		 */
		
		//ũ�Ⱑ 3�� int�� �迭�����̹Ƿ� index�� 0~2���� �����ȴ�.
		int[] numArr =new int[3];
		numArr[0]=10;
		numArr[1]=20;
		numArr[2]=30;
		
		//������ �迭�� �޸� �������� ��µȴ�.
		System.out.println("�迭��(numArr)="+numArr);
		//�迭�� ����� �������� 0������ ���� ��µȴ�.
		System.out.println("numArr 2������ ��:"+numArr[2]);
		
		
		
		
		/*
		 �迭�� ���� �� �ʱ�ȭ
		 	: �迭�� �������� ������ ����ϱ� ���� �����ϹǷ�,
		 	������ ���ؼ�  �Ϲ������� �ݺ����� ����ϰԵȴ�.
		 	
		 	�迭��.length => �ش� �迭�� ũ�Ⱑ ��ȯ�ȴ�. �Ʒ��ǰ�� 4�� ��ȯ��.
		 */
		int[] arrNumber = new int[4];
		for(int i=0; i<arrNumber.length; i++) {
			arrNumber[i] = i+10;
		}
		for(int i=0; i<4; i++) {
			System.out.println(i+"�����ǰ�="+arrNumber[i]);
		}
		System.out.println("===================");
		
		
		
		/*
		 ��ü�迭
		 	: �⺻�ڷ����� �����ϴ� �迭�� �ƴ϶�, ��ü�� ��������
		 	������ �뵵�� �����ϴ� �迭�� �������� �����ϴ�.
		 */
		String[] strArr = new String[3];
		strArr[0] = "java";
		strArr[1] = "jsp";
		strArr[2] = "spring";
		for(int j=0; j<strArr.length; j++) {
			System.out.println(strArr[j]);
		}
		System.out.println("==================");
		
		
		
		
		
		System.out.println("�迭�� ����� �ʱ�ȭ");
		System.out.println("���1 : �迭�� ���� ���� �ʱ�ȭ");
		int[] initArr = new int[1];
		initArr[0] = 100;
		System.out.println("initArr[0]="+initArr[0]);
		
		/*
		 �迭�� ����� ���ÿ� �ʱ�ȭ�� �ϴ°�� �ڹ� �����Ϸ��� �ʱⰪ��
		 ������ ���� ũ�⸦ �����Ҽ� �����Ƿ� �̷���� ũ��� �����ϵ���
		 ��ӵǾ��ִ�.
		 */
		System.out.println("���2 : ����� ���ÿ� �ʱ�ȭ1");
		//int[] initArr2 = new int[3] {1, 20, 300}; //�����߻�
		int[] initArray2 = new int[] {1, 20, 300};
		
		/*
		 �迭 ����� ������ ���� �迭�� ��� �����Ѵ�. �̶� new �� ����
		 �������� ���� �� �� �ִ�.
		 */
		System.out.println("���3 : �ʱⰪ������ ����");
		int[] initArr3 = {11, 13, 17, 19, 23};
		int arrSum=0;
		for(int x=0; x<initArr3.length; x++) {
			arrSum += initArr3[x];
		}
		System.out.println("�迭���������="+arrSum);
	
	}

}
