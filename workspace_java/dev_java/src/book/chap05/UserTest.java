package book.chap05;

import java.util.Random;
import java.util.Scanner;

/*
 * 첫번째 숫자를 채번할 땐 반복할 필요가 없어요.
 * 왜냐하면 중복검사를 할 대상 카드가 없기 때문이죠
 * 
 * com[0]번에 담기는 수자는 반복할 필요가 없다.
 * 두번째 방과 세번째 방에 담기는 숫자는 같은
 * 수자를 채번할 수 있으므로 다시 채번해야 할 경우가 발생할 수 있을것이다.
 * 
 * 첫번째 방에 담긴 숫자와 두번째 방에 담길 숫자가
 * 같니?
 * 
 */

public class UserTest {
	int com[] = new int[3]; 
	int user[]= new int[3];
	//사용자가 입력한 값을 받아오는 곳
	
	
	public void ranCom() {
		Random r = new Random();
		com[0] =r.nextInt(10);
		
		do {
			com[1] = r.nextInt(10);
		}while(com[0]==com[1]);    //0번방이랑 1번방이랑 같니??  같으면 다시 뽑아
		
		do {
			com[2]=r.nextInt(10);
		//}while((첫번째 방값과 세번째 채번한 숫자가 같니?) || (두번째방 값과 세번째 채번한 숫자가 같니?));
		}while((com[0]==com[2]) || (com[1]==com[2]));
	}

	
	
	public String acount() {
		int strike=0;
		int ball=0;
			
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(com[i]==user[j]) {//내가 입력한 숫자중에 컴터에 그 숫자가 있니?
					if(i==j) {//혹시 그 숫자가 자리도 일치하는 거야?
						strike++;
					}//스트라이크 결정
					else {
						ball++;
					}
				}////////////볼카운트 확보
			}/////////////end of inner for
		}//////////////////////end of outter for
		
		if(strike==3) {
			return "정답입니다. 축하합니다.";
		}
		return strike+"strike "+ball+"ball";
	}/////end of acount
	

	public static void main(String[] args) {
		UserTest ut=new UserTest();
		ut.ranCom();
		System.out.println(ut.com[0]+" "+ut.com[1]+" "+ut.com[2]);
		System.out.println("================================");
		System.out.println("게임이 시작되었습니다.");
		System.out.println("세 자리 숫자를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		
		int z=1;
		while(z<10) {
		for(int i=0; i<3; i++) {ut.user[i] = scan.nextInt();}
		System.out.println(ut.user[0]+" "+ut.user[1]+" "+ut.user[2]);
		
		//acount 호출
		//결과출력
	
		String hint=ut.acount();
		System.out.println(z+"회말 "+hint);

		z++;
		}
		}
	}


