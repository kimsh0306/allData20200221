package Falcon;

public class F34_StringBuilder {

	public static void main(String[] args) {
		//String은 변경이 불가능한 문자열의 표현을 위한 클래스이지만,
		//StringBuilder와 StringBuffer는 변경이 가능한 문자열의 표현을 위한 클래스이다.
		//StringBuilder 문자열의 저장 및 변경을 위한 메모리 공간을 '버퍼'라고 한다.
		//이 메모리 공간은 그 크기가 자동으로 조절된다.
		//가장 중요한 메소드는 append와 insert이다.
		//StringBuilder는 java.lang패키지에 묶여 있어 특별한 선언 없이 인스턴스 생성이 가능하다.
		StringBuilder strBuf = new StringBuilder("AB");
		strBuf.append(25);
		strBuf.append('Y').append(true);	//25의 끝에 Ytrue가 추가로 저장
		
		System.out.println(strBuf);
		
		//위치가 2인 지점에(0부터 시장) A(0)B(1)이 다음 부분에 두 번째 전달인자를 문자 형태로 저장하겠다.
		strBuf.insert(2, false);
		//StringBuilder의 length메소드는 저장된 문자의 개수 정보를 반환,
		//이 문장은 문자'Z'를 인자로 append 메소드를 호출하는 것과 같다.
		strBuf.insert(strBuf.length(), 'Z');
		
		System.out.println(strBuf);
		
		//StringBuffer는 쓰레드에 안전하지만, StringBuilder는 쓰레드에 안전하지 못하다.
	}
}
