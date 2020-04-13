package book.chap05;
/*
 * return의 용도
 * 메소드 안에서 사용할 때는 대입연산자를 통하여 반환값을 저장할 수 있다.
 * if문안에서 return을 사용할 수 있다.
 * 이렇게 하면 if문을 탈출하는가? 아니면 메소드 전체를 탈출하는지?
 */
public class ReturnTest {

	void methodA() {
		System.out.println("메소드 A 호출");
	}
	int[] methodB() {		
		return new int[3];
	}
	void methodC() {
		if(5==5) {
			System.out.println("C호출");
			return; //메소드c를 탈출하는 것임. if문을 탈출하는게 아니다
		}
		System.out.println("A호출");
	}
	
	/*
	 * 19번에서 return을 만났을때 if문만 탈출하는거면 21번이 실행될 것이다.
	 * 만일 19번이 메소드c전체를 탈출하는거라면 36번이 호출되고 종료됨.
	 */
	public static void main(String[] args) {
		ReturnTest rt = new ReturnTest();
		int ar[]= rt.methodB();
		for(int a:ar){
			System.out.println(a);
		}  
		rt.methodC();
		
		System.out.println("여기까지 출력......");
	}

}
