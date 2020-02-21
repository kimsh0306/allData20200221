package ocjp.basic;

public class ArrayTest1 {

	static void methodA(int is[]) {   //I@15db9742
		System.out.println("methodA is : "+ is);    //hot spot
		//파라미터로 넘어온 is배열의 원본에 세번째 방에 있는 값을 0에서 10으로 오버라이트
		is[2] = 10;
	}
	
	public static void main(String[] args) {
		//배열 선언과 생성하기-방이 세개 만들어짐.
		//변수is는 배열타입이고 배열의 변수명이다.
		//ArrayTest1 arrayTest1 = new ArrayTest1();
		int is[] = new int[3];  //is 3방 생성  int타입 디폴트값 is[0]=0, is[1]=0, is[2]=0;
		//배열의 주소번지 출력해 보기
		System.out.println("main is : "+ is);    //hot spot
		//methodA(is)호출할 때 is배열의 주소번지를 메소드의 파라미터로 넘겨줌.
		methodA(is); //이 메소드에서 is[2]방에 0값 대신 10으로 제정의함.
		for(int x=0; x<3; x++) {  //초기화; 조건식; 증감식;
			System.out.println("is["+x+"]="+is[x]);
		}
		System.out.println("===========================");
		//개선된 for문 - 배열에 있는 모든 정보를 다 출력할때
		for(int a:is) {
			System.out.println(a);
		}

	}

}
