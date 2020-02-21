package book.chap08;
//자동차 - 완전 추상적이다.어떤 차? Car를 상속받아서 Tivoli를 만든다.
public class Car {
	int speed;
	Car(){					//생성자
		speed = 0;
	}
	public void stop() {	//정지하는 기능
		System.out.println("stop호출 성공");
		if(speed>0) {
		//따로 파라미터를 쓰지 않아도 전변에 speed가 공유
		speed = speed -1;	//브레이크 페달을 밟을 때마다 속도 감소
		}
	}
}
