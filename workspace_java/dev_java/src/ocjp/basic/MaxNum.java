package ocjp.basic;
//메소드를 설계할 수 있다. max
//리턴타입은 뭘로 하지?  int
//파라미터는 몇 개로 할까? 2개
//파라미터의 타입은 어떡하지? 나는 정수형 값을 반환할꺼야  int형 두개
import java.util.Scanner;

public class MaxNum {
	
	double max(double fn, double sn) {
		double maxNumber = 0.0;
		
		if(fn>sn) {
			maxNumber=fn;
		}else 
			maxNumber=sn;
		return maxNumber;
	}
	

}
