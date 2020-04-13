package Qu0129;

public class FibonacciNumbers {
		
	void fibonacci() {
		int[] array = new int[21];
		array[1]=1;	
		System.out.println("array["+1+"]"+array[1]);
		for(int i=2; i<array.length;i++) {
			array[i]=array[i-2]+array[i-1];
			System.out.println("array["+i+"]"+array[i]);
	}
}   
}
