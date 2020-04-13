package ex04controlstatement;
/*
 break문: 
 	반복문이나 switch문에서 주로 사용되면 블럭 내에서
 	break를 만나게 되면 해당 블럭을 탈출한다.
 	만약 중첩된 반복문의 블럭이라면 가장 가까운 블럭 하나만
 	탈출하게 된다.
 continue문:
 	반복문에서 continue를 만나면 블럭의 처음으로 돌아가서
 	조건을 확인한다. 따라서 continue 아래 문장은 실행되지 않는다.
 */
public class BreakContinue {

	public static void main(String[] args) {

		int i = 0;
		while(true) {
			i++;
			System.out.printf("[i가 %d일때]\n", i);
			
			/*
			 문장 내에서 break, continue를 사용할 때는 반드시 아래와 같이
			 if문을 사용해야 한다. 조건부로 실행되거나 그렇지 않게 처리해야 컴파일러가 
			 에러를 발생시키지 않는다.
			 */
			System.out.println("continue이전 출력문");
			if(i%2==0) continue;
			System.out.println("continue이후 출력문");
			
			System.out.println("break이전 출력문");
			if(i==3) break;
			System.out.println("break이후 출력문");
		}
		
		/*
		 중첩된 반복문 안에서 break를 만나면 '가장 가까운 반복문 하나를 탈출'
		 하게 된다.
		 */
		for(int x=1 ; x<=5 ; x++) {
			System.out.println("x="+x);
			
			for(int y=1 ; y<=5 ; y++) {
				System.out.println("y="+y);
				if(y==3)
					break;//y로 반복되는 for문만 탈출한다.
			}
		}

	}

}
