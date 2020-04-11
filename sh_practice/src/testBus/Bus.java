package testBus;

public class Bus {
	//선언부
	int busNumber;
	int passengerCount;
	int money;
	
	//버스 번호를 매개변수로 받는 생성자
	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}
	
	//승객이 버스에 탄 경우를 구현한 메서드
	public void take(int money1) {
		this.money = money1;
		passengerCount++;
	}
	
	//버스 정보를 출력하는 메서드
	public void showInfo() {
		System.out.println("버스" + busNumber +"번의 승객은"+passengerCount+"명이고, 수입은"+money+"입니다.");
	}
}
