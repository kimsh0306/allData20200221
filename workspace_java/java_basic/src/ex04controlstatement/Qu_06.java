package ex04controlstatement;
/*
문제6] 파일명 : Qu_06.java
 아래 코드의 삼항연산자를 if~else문으로 변경해보시오.

 public static void main(String[] args)
 {
 	int num1=50, num2=100;
 	int big, diff;

 	big = (num1>num2)? num1:num2;
 	System.out.println(big);

 	diff = (num1>num2)? num1-num2: num2-num1;
 	System.out.println(diff); 
 }
 실행결과]
 100
 50 
 */
public class Qu_06 {

	public static void main(String[] args) {

		int num1=50, num2=100;
     	int big, diff;
     	
     	//big = (num1>num2)? num1:num2; //조건?참:거짓;
		if(num1>num2){
			big = num1;
		}
		else{
			big = num2;
		}
     	System.out.println(big);
     	

     	//diff = (num1>num2)? num1-num2: num2-num1;     	
     	if(num1>num2) {
     		diff = num1-num2;
     	}
     	else {
     		diff = num2-num1;
     	}     	
     	System.out.println(diff);

	}

}
