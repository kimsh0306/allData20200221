package book.hyelim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import study.hyelim.DBConnectionMgr;


public class BookDao {

	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con = null;//연결 통로 역할 하는 애
	PreparedStatement pstmt = null;//오라클에 갔다오는 애
	ResultSet rs = null;//커서이다. 결과를 받아주는 애
	//이 4개가 db연동을 할 때 필요한 애들이다.
	
	List<Map<String, String>> bList = new ArrayList<>();//<>는 비워놔도 된다.
	//이제 db연동을 하는 메소드를 만들어보자.
	public List<Map<String, String>> getBookList() {
		//오라클에 보낼 sql문을 작성해보자
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT b_no, b_title, b_author, b_info");
		sql.append(" FROM book");
		
		try {
			
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());//con이라는 연결통로를 통해서 sql이라는 쿼리문을 가지고 오라클에 갔다온다.
			rs = pstmt.executeQuery();//pstmt가 오라클에 갔다오면 그 결과를 받아준다.
				//SELECT문 일 때는 pstmt.exectueQuery() 메소드 사용
				//UPDATE, INSERT, DELETE 일 때는 pstmt.executeUpdate() 메소드를 사용한다.
			//rs를 통해 결과를 받아줬으니까 그 결과를 자바에 저장시키자
			//우선 한 로우를 저장시킬 맵을 만들자
			Map<String, String> bMap = null;//어차피 할 로우를 저장시킬 때마다 새로운 bMap이 필요하다. 그러니까 아래의 while문 안에서 생성한다.
			while(rs.next()) {
				bMap = new HashMap<String, String>();
				bMap.put("num", Integer.toString(rs.getInt("b_no")));
				bMap.put("title", rs.getString("b_title"));
				bMap.put("author", rs.getString("b_author"));
				bMap.put("info", rs.getString("b_info"));
				bList.add(bMap);
			}
			//여기까지 오면 bList가 완성된 것이다.
		} catch (SQLException e) {
			System.out.println("SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("그 외의 오류");
			e.printStackTrace();
		}
		return bList;//bList는 List<Map<String, String>>
	}
	
	public static void main(String[] args) {
		BookDao bDao = new BookDao();
		bDao.getBookList();//이 메소드를 실행 시키면 bDao 안에 있는 getBookList 안에 있는  bList가 생겼을 것이지만,
						//나는 그걸 사용할 수 없다. 그럼 어떻게 해야할까. >> bList를 전역변수로 만들었다.
		System.out.println(bDao.bList.size());
		for(Map<String, String> mm : bDao.bList) {
			int num = Integer.parseInt(mm.get("num"));
			String title =  mm.get("title");
			String author =  mm.get("author");
			String info =  mm.get("info");
			System.out.println(num + ", "  + title  + ", " + author  + ", " + info);
		}
		//만약 bDao.bList의 3번 인덱스 방의 정보만 출력하고 싶다면
		System.out.println(bDao.bList.get(3).get("num"));
		
	}
	
}
