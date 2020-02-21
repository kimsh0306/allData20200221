package book.chap08;

public class CarTest_sh {

	public static void main(String[] args) {
		//myCar로 접근할 수 있는 변수의 갯수는 몇 개 일까요? speed
		//myCar로 호출할 수 있는 메소드의 갯수는 몇 개 일까요? stop()
		Car myCar 		= null;
		myCar 			= new Car();
		myCar.speed 	= 10;
		System.out.println(myCar.speed);
		//herCar로 접근할 수 있는 변수의 갯수는 몇 개 일까요? carColor, volumn, speed
		//herCar로 호출할 수 있는 메소드의 갯수는 몇 개 일까요? volumnUp(), volumnDown(), stop()
		Tivoli herCar 	= null;
		Car himCar 		= null;
		himCar 			= new Tivoli();
		himCar.speed 	= 20;
		System.out.println(himCar.speed);
		System.out.println(himCar);
		himCar.stop();
		System.out.println(himCar.speed);
		myCar.stop();
		System.out.println(myCar.speed);
	}
}
