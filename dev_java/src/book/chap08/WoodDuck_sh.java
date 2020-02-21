package book.chap08;

public class WoodDuck_sh extends Duck_sh{ //Duck클래스에 상속됐다.
	@Override//부모클래스의 메소드를 재정의
	public void quack() {
		System.out.println("무음");
	}
	
}
