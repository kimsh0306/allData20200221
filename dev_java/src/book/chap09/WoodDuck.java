package book.chap09;

public class WoodDuck extends Duck {
	public WoodDuck() {
		flyBehavior = new FlyNoWay();	//선언부에 인터페이스가 왔다. 다형성을 누릴 수 있다.
	}
	@Override
	public void display() {	//템플릿 메소드
		// TODO Auto-generated method stub

	}

}
