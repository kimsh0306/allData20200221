package ex06array;

public class ArrayAndMethod {
	
	public static void main(String[] args) {
		
		/*`
		 �迭�� ����� ���ÿ� �ʱ�ȭ. ����� ������ ���� ũ�� ������.
		 */
		int[] arr= {1,2,3,4,5};
		/*
		 �迭 ������ ������ ����. ���� �����ϰ� �ִ� �迭�� ����.
		 */
		int[] ref;
		System.out.println("�ʱ�ȭ ���� ���");
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		
		/*
		�迭���� �Ű������� �����ϴ°��� �迭�� ������(�ּҰ��� �����ϴ°��̴�.)
		������ ��쿡�� �ش� ���� �״�� ���޵ȴ�. arr-> @32fsr3
		 */
		ref=addAllArray(arr, 7);
		
		/*
		 addAllArray() �޼ҵ忡�� ��ȯ�ϴ� ���� ó���� �����޴�
		 �迭�� �ּҰ��̹Ƿ�, ��������� ref�� ������ �迭��
		 �����ϰ� �ȴ�.
		 */
		System.out.println("�޼ҵ� ȣ���� ���");
		
		/*
		 arr�� ref�� ������ �������� ������ �Ǿ����Ƿ�
		 �Ʒ� ����� ������ ����� ���´�.
		 */
		for(int i=0; i<ref.length; i++) {
			System.out.print(ref[i]+" ");
		}
		System.out.println();
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	static int[] addAllArray(int[] ar, int addVal) {
		for(int i=0; i<ar.length; i++) {
			ar[i] += addVal;
	 	}
		return ar;
	}
}
