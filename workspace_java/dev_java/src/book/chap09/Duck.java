package book.chap09;

public abstract class Duck {
	public FlyBehavior flyBehavior = null;
	final int eye = 2;		
	Duck(){
		
	}
	public void performFly() {
		flyBehavior.fly();
	}
	public void fly() {
		System.out.println("오리는 날 수 있어요.");
	}
	public abstract void display(); //추상 메소드
	public void swimming() {		//일반 메소드. 바디가 있으니까.
		System.out.println("모든 오리는 물 위에 뜹니다. 가짜 오리도 물 위에 뜨죠.");
	}
}
