package book.chap08;

public class Tivoli extends Car{
	String carColor;
	int volumn;
	//생성자는 전변을 초기화해준다.
	Tivoli(){					//생성자 안에서 초기화.
		carColor = "남색";
		volumn = 0;
	}
	@Override
	public void stop() {		//정지하는 기능
		System.out.println("Override stop호출 성공");
		if(speed>0) {
		speed = speed -1;		//브레이크 페달을 밟을 때마다 속도 감소
		}
	}
	public void volumnUp() {	//볼륨 조절하는 메소드
		volumn += 1;
	}
	public void volumnDown() {
		volumn -= 1;
	}
}
