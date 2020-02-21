package oracle.jdbc2;

public class ZipCodeVOSimulation {

	static void methodA() {
		ZipCodeVO zcVO = new ZipCodeVO();
		ZipCodeVO zcVOS[] = new ZipCodeVO[2];
		//삼각형 안에 zipcode변수에 값 넣기
		zcVO.setZipcode(21548); //우편번호를 [각각-7번 인.화] 담았다.
		zcVOS[0]= zcVO; //사각형에 삼각형 넣기
		zcVO = new ZipCodeVO();
		//삼각형 안에 zipcode변수에 값 넣기
		zcVO.setZipcode(23598); //우편번호를 [각각-11번 인.화] 담았다.
		zcVOS[1]= zcVO;
		printZcVOS(zcVOS);//메소드파라미터로 주소번지 넘겨줌
	}
	
	static void printZcVOS(ZipCodeVO zcVOS[]) {
		for(ZipCodeVO zcVO:zcVOS) {
			System.out.println(zcVO.getZipcode());
		}
	}
	
	
	public static void main(String[] args) {
		
		ZipCodeVO zvs[] = new ZipCodeVO[2];
		ZipCodeVO zv = new ZipCodeVO();
		zv.setUid_no(10);    //쓰기 0->10
		zv.setUid_no(30);    //10 -> 30
		int uid_no =zv.getUid_no();
		
		System.out.println(uid_no);//-?30
		
		zv.setAddress("서울시 금천구 가산동");
		String ad =zv.getAddress();
		System.out.println(ad);

		methodA();
		printZcVOS(zvs);
	}

}
