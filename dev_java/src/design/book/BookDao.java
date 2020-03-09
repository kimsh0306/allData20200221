package design.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConnectionMgr;

public class BookDao {
	
	//DB연동에 필요한 것
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public int bookDelete(BookVO pbVO) {
		//int
		System.out.println("bookDelete");
		return 0;
	}

	public int bookInsert(BookVO pbVO) {
		System.out.println("bookInsert");
		return 0;
		
	}

	public int bookUpdate(BookVO pbVO) {
		System.out.println("bookUpdate");
		return 0;
		
	}

	public BookVO bookDetail(BookVO pbVO) {
		System.out.println("bookDetail");
		return null;
	}

	public List<BookVO> bookList(BookVO pbVO) {
		System.out.println("bookList() 호출 성공");
		List<BookVO> bookList = new ArrayList<BookVO>();
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT b_no, b_title, b_author, b_publish, b_info");
			sql.append("  FROM book"									);
			sql.append(" WHERE b_no=?"									);//2
			con = dbMgr.getConnection();
			//insert here
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			BookVO rbVO = null;
			while(rs.next()) {
				rbVO = new BookVO();
				rbVO.setB_no(rs.getInt("b_no"));
				rbVO.setB_name(rs.getString("b_title"));
				rbVO.setB_author(rs.getString("b_author"));
				rbVO.setB_publish(rs.getString("b_publish"));
				bookList.add(rbVO);
			}
			System.out.println("bookList.size():"+bookList.size());
		}catch (SQLException se) {
			System.out.println(se.toString());
			System.out.println("[query]"+sql.toString());	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}

}
