package ex06array;
/*
 Call by reference(����(�ּ�)���� ���� ȣ��)
 	: �޼ҵ带 ȣ���Ҷ� �������� ���������ν� ���� �ٸ�
 	���������� ������ �޸�(������)�� �����Ҽ� �ְ� �ϴ�
 	ȣ�����̴�.
 	�޼ҵ��� ������ ���� �ٸ����� �������� ���� �����ϹǷ�
 	A���������� ���� ������ B�������� �״�� �����Ҽ� �ִ�
 	������ �ִ�.
 	�׸��� �������� �����ϹǷ� ���α׷��� �����ս�(����)��
 	�׻�ǰ�, �޸𸮵� �����Ҽ� �ִ�.
 */
public class CallByReference {

	public static void main(String[] args) {
		
		int[] arr = {100,200};
		System.out.println("[���θ޼ҵ�]-swap�� ���");
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]+" ");
		}
		System.out.println();
		callByReference(arr);
		
		System.out.println("[���θ޼ҵ�]-swap���� ���");
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]+ " ");
		}
	}
	
	static void callByReference(int[] ar) {
		int temp;
		temp = ar[0];
		ar[0]=ar[1];
		ar[1]=temp;
	}

}
