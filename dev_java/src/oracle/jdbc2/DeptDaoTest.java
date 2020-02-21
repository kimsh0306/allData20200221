package oracle.jdbc2;
//화면없이 테스트 하기
public class DeptDaoTest {
	DeptDao dDao = new DeptDao();
	int result = 0; //입력결과|수정결과|삭제결과
	//조회하기 테스트
	public void selectTest(DeptVO dVO) {
		System.out.println("selectTest 호출 성공");
		dDao.deptList(dVO.getDeptno());
	}
	//등록하기 테스트
	public void insertTest(DeptVO dVO) {
		System.out.println("insertTest 호출 성공");
		int insertresult = dDao.deptInsert(dVO.getDeptno()//********************
					  , dVO.getDname()
					  , dVO.getLoc());
		System.out.println("입력 성공유무:"+insertresult);
	}
	//수정하기 테스트
	public void updateTest(DeptVO dVO) {
		System.out.println("UpdateTest 호출 성공");
		
		int updateresult = dDao.deptUpdate(dVO.getDname()
				      , dVO.getLoc()
				      , dVO.getDeptno());
		System.out.println("수정 성공유무:"+updateresult);
	}
	//삭제하기 테스트
	public void delectTest(DeptVO dVO) {
		System.out.println("delectTest 호출 성공");
		result = dDao.deptDelete(dVO.getDeptno());
		System.out.println("삭제 성공유무:"+result);
		
	}
	public static void main(String[] args) {
		DeptDaoTest ddt = new DeptDaoTest();
		//화면이 아직 완성되지 않았으므로 통합테스트는 불가하다.
		//하지만 단위테스트는 언제나 가능
		DeptVO dVO = new DeptVO();
		dVO.setDeptno(61);
//		dVO.setDname("품질관리팀");
//		dVO.setLoc("인천");
		ddt.selectTest(dVO);
		
		dVO = null;					//기존의 연결고리를 끊는다.*************
		dVO = new DeptVO();			//새로운 객체를 조립시작
		dVO.setDeptno(61);
		dVO.setDname("품질관리팀");
		dVO.setLoc("인천");
		ddt.insertTest(dVO);
		
		dVO = null;					//기존의 연결고리를 끊는다.*************
		dVO = new DeptVO();			//새로운 객체를 조립시작
		dVO.setDeptno(61);
		dVO.setDname("품질관리팀");
		dVO.setLoc("인천");
		ddt.updateTest(dVO);
		
		dVO = null;					//기존의 연결고리를 끊는다.*************
		dVO = new DeptVO();			//새로운 객체를 조립시작
		dVO.setDeptno(61);
		ddt.delectTest(dVO);
	}
}
