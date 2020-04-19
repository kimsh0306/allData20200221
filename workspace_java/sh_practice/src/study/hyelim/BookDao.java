package study.hyelim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookDao {

	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	List<Map<String,String>> bList = new ArrayList<>();
	
	//db를 연동하는 메소드
	public List<Map<String, String>> getBookList() {
		//오라클에 보낼 sql문
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT b_no, b_title, b_author, b_info");
		sql.append(" FROM book");
		
		try {
			
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			Map<String, String> bMap = null;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}

}
