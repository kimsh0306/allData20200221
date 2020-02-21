package test.d20200219;
//Test3에서 주석 참고
public class Bank {
	//아래 두 문장에서 null;과 "";의 차이를 아는가?**
	String name = null;		//예금주
	//String name2 = "";
	String account = null;	//계좌번호
	int cash = 0;			//잔액
	
	//생성자-생성자의 역할을 아는가?
	//생성자는 초기화를 하는 곳이다.
	public Bank() {
		
	}
	//위와 아래의 차이를 알아야 한다.
	public Bank(String name, String account, int cash) {
		this.name = name;
		this.account = account;
		this.cash = cash;
	}
	
	//입금하는 메소드, money가 필요하다=>얼마를 입금할 건가?
	//money가 잔액에 합산되야 한다.
	//얼마를 입금할 거니? - 파라미터
	//static을 붙이면 안되는 이유? 수많은 사람들이 사용하는 것이기 때문에 전역변수가 최선이다.**
	public void deposit(int money) {	//입금하기
		cash = cash+money;				//잔액 계산
	}
	
	//인출하는 메소드, money가 필요하다=>얼마를 인출할 건가?
	//얼마를 인출할 거니? - 파라미터
	//파라미터를 먼저 챙겨라**
	//요청 다음이 응답이다.
	public void take(int money) {
		//잔액 >= 돈: true | false**
		//잔액 cash는 하나여야 하기 때문에 전역변수**
		if(cash >= money) {
			cash = cash - money;
		}else if(cash < money) {		//else보다 직관적인 else if를 사용하자.
			System.out.println("잔액이 부족합니다.");
			return;						//return을 잘 챙기자**
		}
		System.out.println("123");
	}
	//toString() 메소드의 역할을 말할 수 있는가.
	public String toString() {
		String accountINFO = "예금주는 "+name+"이고, 계좌번호는 " +account+"이고, 잔액은 "+cash+"원입니다.";
		//return "예금주는 김유신이고, 계좌번호는 123-456-789, 잔액은 30000원입니다.";	//상수 싫어요.
		return accountINFO;
	}
	
	public void print() {
		System.out.printf("예금주는 %s이고, 계좌번호는  %s이고, 잔액은  %d입니다."//%d 십진수의 약자=>int같은 약속된 언어
							,name,account,cash);
	}
}
