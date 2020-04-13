package ex03operator;

public class ShortCircuitEvaluation {
	
	/*
	SCE(Short-Circuit Evaluation)
		하나의 조건검사만으로 결과를 알수있는 경우 JAVA컴파일러는
		뒤의 조건을 수행하지 않고 건너뛰게된다. 이 경우 변수의
		값을 변경하는 코드가 있다면 실행되지 않으므로 주의해야 한다.
	 */
	public static void main(String[] args) {

		int num1=0, num2=0;
		boolean result;
		
		/*
		&& (논리And)의 경우 둘중 하나만 false이면 false를 반환하므로
		첫번째 조건이 false이면 두번째 조건은 검사하지 않는다. 
		 */
		result = (num1+=10)<0 && (num2+=10)>0;
		System.out.println("result="+ result);
		System.out.println("num1="+ num1 +", num2="+ num2);
		
		/*
		||(논리Or)의 경우 둘중 하나만 true이면 true를 반환하므로
		첫번째 조건이 true이면 두번째 조건은 실행하지 않는다. 
		 */
		result = (num1+=10)>0 || (num2+=10)>0;
		System.out.println("result="+ result);
		System.out.println("num1="+ num1 +", num2="+ num2);
		
		/*
		따라서 num2의 결과가 프로그램에 영향을 미치게 된다면 별도의
		처리가 필요하므로 코드작성에 주의해야 한다. 
		 */
	}

}
