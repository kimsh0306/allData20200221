package ex06array;

public class ArrayAndMethod {

	public static void main(String[] args) {		
		
		/*
		배열의 선언과 동시에 초기화. 요소의 갯수에 의해 크기 결정됨.
		 */
		int[] arr = {1, 2, 3, 4, 5};
		/*
		배열 변수만 선언한 상태. 아직 참조하고 있는 배열이 없음.
		 */
		int[] ref;
		System.out.println("초기화 직후 출력");				
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
		
		/*
		배열명을 매개변수로 전달하는것은 배열의 참조값(주소값을
		전달하는것이다. 정수의 경우에는 해당 값이 그대로 전달된다.
		 */
		ref = addAllArray(arr, 7);
		/*
		addAllArray() 메소드에서 반환하는 값은 처음에 전달했던 
		배열의 주소값이므로, 결과적으로 ref도 동일한 배열을 
		참조하게 된다. 
		 */
		
		System.out.println("메소드 호출후 출력");
		/*
		arr과 ref는 동일한 참조값을 가지게 되었으므로 
		아래 출력은 동일한 결과가 나온다. 
		 */
		for(int i=0 ; i<ref.length ; i++) {
			System.out.print(ref[i]+" ");
		}
		System.out.println();
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static int[] addAllArray(int[] ar, int addVal) {
		for(int i=0 ; i<ar.length ; i++) {
			ar[i] += addVal;
		}
		return ar;
	}
}
