package design.book;

import java.util.List;

public class BookController {
	private static final String _DEL = "delete";	//삭제하기
	private static final String _SEL = "selete";	//상세조회
	private static final String _INS = "insert";	//입력하기
	private static final String _UPD = "update";	//수정하기
	private static final String _ALL = "detail";		//전체조회
	BookDao bDao = new BookDao();
	
	public BookVO send(BookVO pbVO) {				//파라미터 pbVO 응답 rbVO
		BookVO rbVO = new BookVO();
		String command = pbVO.getCommand();
		//insert here
		////전체조회를 제외한 네 가지 경우를 처리해 보자**********************
		
		if(_DEL.equals(command)) {
		//DELETE FROM book WHERE b_no=1
			int result = 0;
			result = bDao.bookDelete(pbVO);
			rbVO.setResult(result);
		}
		else if(_INS.equals(command)) {
		//INSERT INTO book(b_no,b_name,b_author,b_publish,b_info
		//VALUES(?,?,?,?,?)
			bDao.bookInsert(pbVO);
		}
		else if(_UPD.equals(command)) {
		//UPDATE book SET b_name=?,b_author=?,b_publish=?
			int result = 0;
			result = bDao.bookUpdate(pbVO);
			rbVO.setResult(result);
		}
		else if(_SEL.equals(command)) {
		//UPDATE b_no, b_name,b_author,b_publish FROM book
		// WHERE b_no=3
			rbVO = bDao.bookDetail(pbVO);
		}		
		return rbVO;
	}////////////////////end of send
	
	//전체조회
	public List<BookVO> sendAll(BookVO pbVO){
		System.out.println("sendAll 호출 성공");
		List<BookVO> bList = null;
		String command = pbVO.getCommand();
		if(_ALL.equals(command)) {
			bList = bDao.bookList(pbVO);
		}
		return bList;
	}////////////////////end of sendALL
}