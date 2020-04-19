package foodList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import oracle.jdbc.driver.DBConversion;
import study.hyelim.DBConnectionMgr;

public class FoodDao {

	DBConnectionMgr 	dbMgr 	= DBConnectionMgr.getInstance();
	Connection 			con 	= null; //연결통로 역할
	PreparedStatement 	pstmt 	= null; //실제로 오라클에 요청하러 다녀 오는 역할
	ResultSet 			rs 		= null; //결과를 받아줄 수 있는 커서
	
	
	//여기에서 db연결을 해줄 것이다.
	public List<Map<String, String>> getFoodList() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT f_no, f_name, f_score, f_infor");
		sql.append(" FROM foodList");
				
		List<Map<String, String>> fList = new ArrayList<Map<String,String>>();
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();	//rs에 오라클에서 가지고 온 데이터가 들어간다.
			
			
			Map<String, String> fMap = null;
			
					
			//오라클은 결과가 몇 개인지 모른다. 그래서 while문
			//while문이 돌 때마다 fMap을 생성해 준다.
			while(rs.next()) {
				fMap = new HashMap<String, String>();
				fMap.put("no", Integer.toString(rs.getInt("f_no"))); //getInt => 인트 타입을 가져오겠다.
				fMap.put("name", rs.getString("f_name"));
				fMap.put("score", Double.toString(rs.getDouble("f_score")));
				fMap.put("info", rs.getString("f_infor"));
				fList.add(fMap);
				
			}
			//|fMap|fMap|fMap|....이런 식으로 fList에 fMap이 담긴다.
			System.out.println(fList.size());
			
		} catch (SQLException e) {
			System.out.println("SQL오류발생!!!");
			e.printStackTrace();
			e.toString();
			System.out.println(e.getStackTrace());
			
		} catch (Exception e) {//모든 오류를 잡아 준다.
			System.out.println("그 외의 오류발생!!!");
			e.printStackTrace();
		}
		return fList;
	}
	
	//저장버튼을 눌렀을 때 insertRow()실행
	public void insertRow(FoodVO fVO) {
		//System.out.println("insertRow() 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO foodList VALUES(");
		sql.append("?,?,?,?)");
		
		System.out.println(fVO.getNo());
		System.out.println(fVO.getName());
		System.out.println(fVO.getScore());
		System.out.println(fVO.getInfo());
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, fVO.getNo());
			pstmt.setString(2, fVO.getName());
			pstmt.setDouble(3, fVO.getScore());
			pstmt.setString(4, fVO.getInfo());
			int result = pstmt.executeUpdate();//executeUpdate()의 반환타입이 int이다. 실패하면 0, 성공하면 1
			if(result == 0) {
				JOptionPane.showMessageDialog(null, "실패했습니다.");
			}
			else {
				JOptionPane.showMessageDialog(null, "성공했습니다. result: "+result);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL오류발생!!! - insertRow()");
			e.printStackTrace();
			e.toString();
			System.out.println(e.getStackTrace());
			
		} catch (Exception e) {//모든 오류를 잡아 준다.
			System.out.println("그 외의 오류발생!!! - insertRow()");
			e.printStackTrace();
		}
		
	}
	
	
	public FoodDao() {
		
	}
	
	public static void main(String[] args) {
		FoodDao fDao = new FoodDao();
	}
	
}
