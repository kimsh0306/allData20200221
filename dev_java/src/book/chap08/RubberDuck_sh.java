package book.chap08;

public class RubberDuck_sh extends Duck_sh{
	public void fly() {
		System.out.println("나는 날지 못합니다.");
	}
	@Override
	public void swimming() {
		//재정의
		System.out.println("나는 물 위에 뜰 수 있지만 잠수는 불가능합니다.");
	}
}
