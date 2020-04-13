package ocjp.basic;

public class A {
	int x;//전변
	
	void methodA() {
		int z; //지역변수
	}
	
	boolean check() {  //메소드 선언
		x++;
		return true;
	}
	
	void zzz() {
		x=0;
	//	z=0;  [에러발생]선언이 안되있음. 지역변수 사용할 수 없음
		
		//앞에 괄호에서 결과가 True이므로 뒤에 명제가 참이든 거짓이든 상관없이 실행문은 반드시 실행됨.
		if((check() | check()) || check()) {
			x++; //현재 변수 x값은 유지되고 있다.
		}
		System.out.println("x====> "+x);
	}
	
	
	public static void main(String[] args) {
		new A().zzz();

	}

}
