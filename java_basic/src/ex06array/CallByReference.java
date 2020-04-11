package ex06array;

/*
Call by reference(참조(주소)값을 통한 호출)
	: 메소드를 호출할때 참조값을 전달함으로써 서로 다른 
	지역에서도 동일한 메모리(힙영역)를 참조할수 있게 하는
	호출방법이다. 
	메소드의 지역이 서로 다르더라도 참조값을 통해 참조하므로
	A영역에서의 값의 변경을 B영역에서 그대로 참조할수 있는
	장점이 있다.
	그리고 참조값만 전달하므로 프로그램의 퍼포먼스(성능)도
	향상되고, 메모리도 절약할수 있다. 
 */
public class CallByReference {

	public static void main(String[] args) {
		
		int[] arr = {100, 200};		
		System.out.println("[메인메소드]-Swap전 출력");
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		callByReference(arr);
		
		System.out.println("[메인메소드]-Swap이후 출력");
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static void callByReference(int[] ar) {
		int temp;
		temp = ar[0];
		ar[0] = ar[1];
		ar[1] = temp;
	}	
}
