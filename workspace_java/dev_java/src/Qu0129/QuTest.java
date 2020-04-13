package Qu0129;

public class QuTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		for(int i=1; i<=100; i++) {
			if(i%5==0 &&i%7==0) {
				System.out.println(i+"= fizz, Buzz");
			}
			else if(i%5==0) {
				System.out.println(i+"= fizz");
			}
			else if(i%7==0) {
				System.out.println(i+"= Buzz");
			}else {
				System.out.println(i);
			}
			
		}
	}

}
