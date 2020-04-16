package study.hyelim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDao {
	//try문 안에서 생성하기 위해 전역변수 자리에 null로 선언 
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//getPersonlist()서 가져온 값을 담을 List
	List<Map<String,Object>> pList = null;
	//한 로우, 한 로우 각각의 로우의 정보를 담을 map
	Map<String,Object>	pMap = null;
	
	public void getPersonlist() {
		//pstmt가 오라클에 갈 때 요청하는 문장을 가지고 가야한다.
		//pstmt가 이 문자열을 가지고 오라클 서버로 가서 sql문으로 작용한다.
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT P_no,P_name,P_height,p_loc");
		sql.append(" FROM Personlist");//두 줄로 작성할 때 앞에 공백 넣어야 한다.
		
		try {
			pList = new ArrayList<>();
			con = dbMgr.getConnection();
		
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery(); //테이블에 대한 정보가 여기에 담겼다.
			while(rs.next()) {
				//로우마다 새로 map에 담겠다.
				pMap = new HashMap<String, Object>();
				//rs에 담긴 정보를 확인하기 위해서 map에 담아준다.
				pMap.put("p_no", rs.getInt("p_no"));
				pMap.put("p_name", rs.getString("p_name"));
				pMap.put("p_height", rs.getDouble("p_height"));
				pMap.put("p_loc", rs.getString("p_loc"));
				pList.add(pMap);
			}
			System.out.println(pList.size());
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		PersonDao pd = new PersonDao();
		pd.getPersonlist();
		int aa = (int) pd.pList.get(0).get("p_no");
		System.out.println(aa);
	}
}
