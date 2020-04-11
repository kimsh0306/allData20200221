package Falcon;

public class F39_Array3 {
	//배열의 메소드, 배열을 반환, 메소드의 선언 부분과 매개변수 부분에는 []가 추가적으로 들어갔다.
	public static int[] addAllArray(int[] ar, int addVal) {
		for(int i=0;i<ar.length;i++) {
			ar[i] += addVal;
		}
		return ar;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int[] ref;
		
		//메소드를 호출하면서 arr과 7을 인자값으로 올려준다.
		//return값 반환 8,9,10,11,12
		//arr과 ref가 같을까? 두 배열은 같다.
		//메인함수의 배열 arr과 메소드로부터 반환받은 ref는 같다.
		ref = addAllArray(arr, 7);
		
		if(arr==ref) {
			System.out.println("동일한 인스턴스 참조");
		}
		else {
			System.out.println("다른 인스턴스 참조");
		}
		for (int i=0;i<ref.length;i++) {
			System.out.println(arr[i]+" ");
		}
	}
}
