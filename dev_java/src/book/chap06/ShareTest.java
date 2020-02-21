package book.chap06;
/*
 * 변수 2개 선언하였다.
 */
class Stest{//선언과 초기화
	int i = 1;      //non-static타입 일반변수
	static int j = 2; //static타입 정적변수
}
/*
 * 메소드 한개 선언 - methodA()
 * STest객체를 메모리에 로딩하였음. -인스턴스화
 * STest클래스의 변수, i를 1증가시킴-초기화를 했다.
 * 정적변수인 j를 1증가시킴
 */
class Stest2{//변조
	void methodA() {
		Stest st=new Stest(); //주입(인스턴스화)
		st.i = st.i + 1;//2
		Stest.j = Stest.j + 1;//3    J는 static이기때문에 직접호출 가능
		//st.i:2 , j:3
		System.out.println("methodA ==> st.i:"+st.i+" , Stest.j:"
				+Stest.j); //

	}
}
//관찰하기
public class ShareTest {
	//29-30(먼저생성-원본)-31-32-16-17(복사본)
	public static void main(String[] args) {
		Stest st=new Stest();
		Stest2 st2=new Stest2();
		st2.methodA();
		st.i+=3; //1 -> 4 17번에서 생성된 객체가 아니라 29번 생성된 객체를 가르킴
		Stest.j=5;
		System.out.println("st.i:"+st.i+", Stest.j:"+Stest.j); //3
	}
}






/*
결론(완결편)
같은 이름의 변수로 클래스를 인스턴스화 할 수 있다.
이 때 주소번지는 서로 다른 값을 가지고 있다.
static이 붙은 변수는 인스턴스화 없이 사용할 수 있다.
그리고 또 static이 붙은 변수는 하나가 공유되는 것이다.
그렇기 때문에 위에서 methodA에서 출력한 J값과 main메소드 안에서 출력된 j값이
서로같다.
그러나 변수 i는 static이 없으니까.... 하나가 아니라 복사본이 변경되는 것이다.
따라서 methodA에서 출력한 i값과 main메소드 안에서 출력된 i값이
서로 다를 수 밖에 없다.	

*/