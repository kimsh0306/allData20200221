package oracle.jdbc2;

public class ZipCodeList2_1 {

	
	
	public static void main(String[] args) {
		java.util.Vector<ZipCodeVO> v
			= new java.util.Vector<ZipCodeVO>();//인스턴스화 됐지만 아직 data 없음. 넣기 전 단계. 주소번지는 갖고 있다.
		ZipCodeVO zcVO = null;
		ZipCodeVO zcVOS[] = null;//아직 방 크기를 결정할 수 없음. 알 수 없음
		int i = 0;
		while(i<3) {
			zcVO = new ZipCodeVO();
			System.out.println("zcVO주.번가 바뀐다.");
			v.add(zcVO);
			i++;
		}
		for(int x=0;x<v.size();x++) {
			//Vector에 0번째 들어있는 주소번지는 ZipCodeVO타입니다.
			ZipCodeVO zVO = v.get(x);
			System.out.println(zVO);
		}
		zcVOS = new ZipCodeVO[v.size()];
		System.out.println("배열의 크기는 "+zcVOS.length);//3
		//zcVOS가 가리키는 객체 배열에 들어있는 정보를 출력해 보세요.
		//insert here
		//zcVOS.length는 배열의 방크기(갯수) - 3개 있다.
		v.copyInto(zcVOS);
		for(int y=0;y<zcVOS.length;y++) {
			//zcVOS[y] = v.get(y);
			//zcVOS[1] = v.get(0);
			//zcVOS[2] = v.get(0);
			//배열[0] = 벡터[0]
			System.out.println(zcVOS[y]);//null, null, null
		}
		//리턴타입이 void이지만 값을 유지하게 할 수 있다.
		//파라미터로 넘긴 주소번지에 v에 저장되어 있는 주소번지를 복제해주는 메소드.
		//저 배열의 세 개 방안에 ZipCodeVO가 초기화 될 수 있도록 코드를 작성해 보세요.
	}
}
