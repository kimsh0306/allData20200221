package ocjp.basic;

public class WrapperTest {

	public static void main(String[] args) {
		int i=5;
		//6번의 변수 i에 대한 Wrapper클래스라고 함.
		Integer oi = new Integer(5);
		//원시형 타입 i는 메소드를 호출할 수 없다.
		//System.out.println(i.intValue()); 원시타입은 값이나오기때문에 메소드x
		System.out.println(oi.intValue()); //클래스이며 메소드를 가질수있다.
		
		Double pi = new Double(3.14);
		double d = pi.doubleValue();
		double d1 = pi; //오토박싱-자동으로 원시형과 참조형 사이에 타입을 맞춰줌.
		System.out.println(d1);
		Boolean b= new Boolean(false);
		boolean ab=b.booleanValue();
	}

}
