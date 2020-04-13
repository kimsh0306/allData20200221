package ex06array;

/*
 Call by value(���� ���� ȣ��)
 	�޼ҵ� ȣ��� ���õ� �������� �Ű������� ���� ���� �����Ҵ�
 	�޸��� "����"�� ���� ���� ���޵ȴ�.
 	�׷��� �ٸ� �޼ҵ�(����)���� ���� ������ �ִ��� ȣ����
 	�޼ҵ��� ������ ���� ������ ��ġ�� �ʴ´�.
 	
 	�޸��� �������κ��� ���ÿ����� ����ϴ� ���̽���
 	main�� ȣ��� �޼ҵ�� ���� �ٸ� �����̹Ƿ� ���ο���
 	������ ��ġ�� �ʴ°��� Ư¡�̴�.
 */
public class CallByValue {
	
	public static void main(String[] args) {
		
		int first=100, second=200;
		//���1: first:100, second:200
		System.out.println("[main�޼ҵ��-ȣ����]"
				+"first="+first+", second="+second);
		callByValue(first, second);
		//���3: first:100, second:200
		System.out.println("[main�޼ҵ��-ȣ����]"
				+"first="+first+", second="+second);

	}
	
	public static void callByValue(int fNum, int sNum) {
		int temp;
		temp = fNum;
		fNum = sNum;
		sNum= temp;
		//���2: first:200, second:100
		System.out.println("[callByValue�޼ҵ��"
				+"first="+fNum+",second="+sNum);
	}
}
