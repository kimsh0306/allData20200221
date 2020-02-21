package book.chap08;

public class DuckSimulation_sh {

	public static void main(String[] args) {
		Duck_sh d = new Duck_sh();
		d.quack();
		Duck_sh wd = new WoodDuck_sh(); //Duck타입 변수에 WoodDuck으로 객체주입*************
		wd.quack();
		wd.swimming();//WoodDuck에는 없지만 부모 클래스인 Duck에 있는 메소드를 누릴 수 있다.***********
	}
	
}
