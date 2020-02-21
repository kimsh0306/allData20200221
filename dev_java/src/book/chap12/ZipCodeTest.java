package book.chap12;

import java.util.Vector;

import com.google.gson.Gson;

import method.zipcode.ZipCodeSearchApp;
import oracle.jdbc2.ZipCodeList;
import oracle.jdbc2.ZipCodeVO;

public class ZipCodeTest {
	public void gsonFormat(Vector<ZipCodeVO> v) {
		Gson g = new Gson();
		String temp = g.toJson(v);
		System.out.println(temp);
	}

	public static void main(String[] args) {
		//메소드 호출 할 수 없다.
		//ZipCodeTest 인스턴스화를 해야 한다.
		ZipCodeTest zcTest = new ZipCodeTest();
		ZipCodeSearchApp zcApp = new ZipCodeSearchApp();
		Vector<ZipCodeVO> v = zcApp.refreshData(null,"가산동");
		//선언한 다음에 호출한다.
		zcTest.gsonFormat(v);
		System.out.println(v.size());
		for(int i=0;i<v.size();i++) {
			ZipCodeVO zcVO = v.get(i);				//벡터에서 꺼낸 i가 누구니? 타입이 뭐야? VO
			System.out.println(zcVO.getAddress());	//getter는 String 타입.
		}
	}
}
