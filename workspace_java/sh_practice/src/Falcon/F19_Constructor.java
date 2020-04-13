package Falcon;

class Number {
	int num;
	
	public Number(int n) {
//		num = 10;
		num = n;
		System.out.println("생성자 호출");
	}
}

public class F19_Constructor {
	public static void main(String[] args) {
//		Number num1 = new Number();
		Number num1 = new Number(10);
		System.out.println(num1.num);
	}
}
