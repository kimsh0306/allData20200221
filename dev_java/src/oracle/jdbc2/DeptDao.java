package oracle.jdbc2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.util.DBConnectionMgr;
public class DeptDao {
	Connection 			con = null;
	PreparedStatement 	pstmt = null;
	ResultSet 			rs = null;
	DBConnectionMgr		dbMgr = DBConnectionMgr.getInstance();
//부서 집합에서 조회하는 메소드 선언하기
//SELECT deptno, dname, loc FROM dept WHERE deptno = 10;
//테이블에 있는 컬러명을 파라미터의 변수명으로 사용한다.
	public DeptVO[] deptList(int deptno){
		//조회 결과가 n건 일 수 있으므로 객체 배열로 받아야 한다.
		DeptVO[] dvos = null;
		//쿼리문을 작성할 때 String 대신 StringBuilder를 사용하자.
		StringBuilder sb = new StringBuilder(); //쿼리문 쓸 때는 무조건 StringBuilder
		sb.append("SELECT deptno, dname, loc FROM dept WHERE deptno = ?");
		//예외처리 권고
		try{
			con = dbMgr.getConnection();	//오라클 서버의 연결통로를 만든다.
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, 10);
			rs = pstmt.executeQuery();
		}catch (Exception e) {
			
		}finally {		//이 안에서 에러가 발생하더라도 자원받납은 무조건 꼭 처리해 주세요.
			//사용한 자원은 반납해 주세요.
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return dvos;
	}
//메소드 오버로딩이라고 한다.
//무조건 파라미터의 갯수가 다르거나 혹은 파라미터의 타입이 달라야 한다.
//SELECT deptno, dname, loc FROM dept WHERE deptno>10 AND dname=?;
	public DeptVO deptList(int deptno, String dname){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT deptno, dname, loc FROM dept WHERE deptno = ?");
		try{
			
		}catch (Exception e) {
			
		}finally {		//이 안에서 에러가 발생하더라도 자원받납은 무조건 꼭 처리해 주세요.
			//사용한 자원은 반납해 주세요.
			dbMgr.freeConnection(con, pstmt);
		}
		return null;
	}
//신규 부서 정보를 등록하는 메소드 선언하기
//INSERT INTO dept(deptno, dname, loc) values(?,?,?);
	public int deptInsert(int deptno, String dname, String loc) {
		int result = 0;//1=성공, 0=실패
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO dept(deptno, dname, loc) values(?,?,?)");
		try{
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			
		}finally {		//이 안에서 에러가 발생하더라도 자원받납은 무조건 꼭 처리해 주세요.
			//사용한 자원은 반납해 주세요.
			dbMgr.freeConnection(con, pstmt);
		}
		return result;
	}
//기존 부서 정보를 수정하는 메소드 선언하기
//UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?
	public int deptUpdate(String dname, String loc, int deptno) {
		int result = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE dept SET dname=?, loc =? WHERE deptno=?");
		try{
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			int i=0;
			pstmt.setInt(++i, deptno);
			pstmt.setString(++i, dname);
			pstmt.setString(++i, loc);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			
		}
		return result;
	}
//사라진 부서 정보 반영하는 메소드 선언하기
//DELETE FROM dept WHERE deptno = ?
	public int deptDelete(int deptno) {
		int result = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM dept WHERE deptno = ?");
		try{
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			int i=0;
			pstmt.setInt(++i, deptno);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			//delete문에 에러가 발생했을 때 delete문을 출력하는 문장을 작성할 수 있는데
			//이때 변수 sb를 사용할 수 있다|없다
			System.out.println(sb.toString());
		}finally {		//이 안에서 에러가 발생하더라도 자원받납은 무조건 꼭 처리해 주세요.
			//사용한 자원은 반납해 주세요.
			dbMgr.freeConnection(con, pstmt);
		}
		return result;
	}
}
