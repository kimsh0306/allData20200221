package book.chap05;

import java.util.Random;


public class RandomGame {
	//세잘 숫자를 채번하는 메소드입니다.
	//세게임 버튼을 누르거나 강제 종료 후 다시 시작할 때 호출됩니다.
	
	int com[] = new int[3]; 
	int strike=0;
	
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

	
	
	

	
	public static void main(String[] args) {
		
	}

}
