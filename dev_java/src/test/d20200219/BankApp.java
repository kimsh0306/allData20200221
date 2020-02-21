package test.d20200219;

public class BankApp {

	//단위테스트 - 시나리오를 생각해 보고 메인메소드에서 단위 테스트를 처리해 보자.
	public static void main(String[] args) {
		//Bank bank = new Bank(String name, String account, int cash);	//파라미터 순서 중요
		Bank bank = new Bank("자바맨","124-456-789",10000);	//파라미터 순서 중요
		//System.out.println(bank.toString()); 				//toString의 리턴타입은 String
		
		System.out.println(bank);	//toString을 오버라이드했기 때문에 주소값이 아니라 값이 나온다.
		
		bank.deposit(15000);		//입금하는 메소드
		bank.take(30000);			//인출하는 메소드
	}
}
