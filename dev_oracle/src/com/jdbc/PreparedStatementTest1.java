package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedStatementTest1 {

	public static void main(String[] args) {
		String url	 = "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
		String user	 = "scott";
		String pw	 = "tiger";
		Connection con 			= null;//java.sql.*
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		Scanner scan 			= new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("con"+con);
			System.out.println("사원번호를 입력하세요.");
			int u_empno = scan.nextInt();
			StringBuilder sql = new StringBuilder();
			sql.append("SECECT ename, job FROM emp");
			sql.append("WHERE empno=?");
			pstmt = con.prepareStatement(sql.toString());
			//insert here 처리
			pstmt.setInt(1, u_empno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("ename:"+rs.getString(1)
								  +" job:"+rs.getString(2));
			}else {
				System.out.println("조회 결과가 없습니다.");
			}
		} catch (ClassNotFoundException ce) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
		} catch(Exception e) {
			//스택영역에 쌓여있는 에러 메시지의 history를 출력하고 line번호도 출력한다.
			e.printStackTrace();
		} finally {
			System.out.println("정상적으로 처리가 되었을 때도 실행됨.");
			//사용한 자원 반납하기
			//반납 할 때는 생선된 역순으로 처리하기
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		System.out.println("여기");
	}
}