package book.chap02;

public class SonataSimulation {

	public static void main(String[] args) {
		Sonata meCar = new Sonata();
		meCar.carColor="흰색"; //초기화를 다시 했다.
		meCar.carColor="자주색"; //초기화를 다시 했다.
		//변수의 값은 재정의 가능하다.
		//발자취 null -> 흰색 -> 자주
		//숫자가 검색속도가 빠르다.
		System.out.println(meCar.carColor);
	}

}
