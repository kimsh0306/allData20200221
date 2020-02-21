package ocjp.basic;

public class B {
	void methodA() {	
	}
	
	static void methodB() {	
	}
	public static void main(String[] args) {
		B b = new B();
		b.methodA();
		methodB();
		//methodA(); 주소값없이 쓰려면 static으로 B메소드를 선언해줘야한다.
	}
}
