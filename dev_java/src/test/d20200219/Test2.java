package test.d20200219;
/*
 2.	1부터 1000까지 숫자중 2의 배수이거나(for문 안에 if문)** 
 	5의 배수인 숫자의 합을 구하는 소스코드와 결과화면 스크린 샷을 제출하시오.
 	=> (2의 배수, 5의 배수)조건 두 개 if문 두 개를 한 개로.
 	[요구사항] 
   	가. 단, 2와 5의 공배수인 경우 제외
   	나. while문 버전과  for문 버전으로 두가지 소스코드를 작성하시오
   	
   	if if => if
   	for문<->while문 변경 가능해야 한다.**
   	for문 break|continue 쓸 수 있다.
   	while문 
 */
public class Test2 {
//초기화, 제어문의 패턴, 전체적인 그림을 보자(for문 안에 if문)
//무한루프를 방지하는 코드********
//while문 => break를 꼭 생각해야 한다.
//continue의 빈도는 break보다 낮기 때문에 break가 더 중요!!
//break를 잘 쓰는 사람이 되자.
	public static void main(String[] args) {
		int dap1= 0, dap2 = 0;		//지변은 반드시 초기화해야 한다.
		int i=0;
		for(i=1;i<=1000;i++) {
			if(i%2==0 && i%5==0) {
				//제외
				continue;
			}else if(i%2==0 || i%5==0) {
				dap1=dap1+i;
			}
		}
		i=1;//i를 초기화 할 수 있는가*********
		while(i<=1000) {
			if(i%2==0 && i%5==0) {
				//제외
				continue;
			}else if(i%2==0 || i%5==0) {
				dap2=dap2+i;
			}
			System.out.println(i);
			i++;//무한루프 방지코드, 이 자리에 쓸 수 있는가********
		}
	}
}
