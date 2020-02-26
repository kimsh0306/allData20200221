package book.chap12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/*
 * 인터페이스는 단독으로 인스턴스화 할 수 없다.
 * 반드시 구현체 클래스가 있어야 한다.
 * 컬렉션프레임워크에서 제공되는 모든 클래스는 객체타입만 담을 수 있다.
 */
public class MapTest {
	Map<String,Object> pMap = new HashMap<>();
	public void showAllDept2() {
		Object keys[] = pMap.keySet().toArray();
		for(int i=0;i<keys.length;i++) {
			String key = (String)keys[i];
			System.out.println(key + ", "+pMap.get(key));
		}
	}
	
	public void showAllDept() {
		Iterator<String> ir = null;	//Iterator(인터페이스)? Map에 담긴 정보를 꺼내는데 필요한 메소드를 제공함.
		Set<String> keys = pMap.keySet();
		ir = keys.iterator();
		while(ir.hasNext()) {
			String key = ir.next();	//deptno, dname, loc
			int deptno = 0;
			String dname = null;
			String loc = null;
			if(pMap.get(key) instanceof Integer) {
				deptno = Integer.parseInt(pMap.get(key).toString());
			}
			if(pMap.get(key) instanceof String) {
				if("dname".equals(key)) {
					dname = pMap.get(key).toString();
				}else if("loc".equals(key)) {
					loc = pMap.get(key).toString();
				}
			}
			System.out.println(deptno+", "+dname+", "+loc);
		}///////////end of While
	}///////////////end of 
	public static void main(String[] args) {
		//단독으로 인스턴스화 할 수 없다.
		//이런 자료형은 오브젝트 타입만 담을 수 있다.
		//Map<String,Object> mt.pMap = new Map<>();	//오류 발생
		//Map<String,String> mt.pMap = new HashMap<>();//오류 발생
		MapTest mt = new MapTest();
		mt.pMap.put("deptno", 10);
		mt.pMap.put("dname", "ACCOUNTING");
		mt.pMap.put("loc", "NEW YORK");
		mt.showAllDept();
//		System.out.println(mt.pMap.get("deptno"));
//		System.out.println(mt.pMap.get("dname"));
//		System.out.println(mt.pMap.get("loc"));
	}
}
