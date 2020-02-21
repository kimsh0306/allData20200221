package method.temperature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class SeoulTempDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	/*
	 * 서울 기상통계 정보로 부터 최근 10년 년도 가져오기
	 */
	public String[] getYearList() {
		String years[] = null;
		StringBuilder sb = new StringBuilder();
		SELECT
	    DISTINCT (TO_CHAR(TO_DATE(sdate),'YYYY')) ta_year   
	    FROM seoultemp
	    WHERE TO_CHAR(TO_DATE(sdate),'YYYY')
	    >TO_CHAR(sysdate,'YYYY')-11
	    ORDER BY TO_CHAR(TO_DATE(sdate),'YYYY')
		try {//물리적으로 떨어져 있는 서버에 ip주소로 접근하니까 예외가 발생할 가능성이 있음.try사용을 권장함
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();//오라클에게 부탁하는 중. sb.append("SELECT dname FROM dept"); 이 셀렉트 문 처리해 줄래?
			Vector<String> v = new Vector<>();//배열의 갯수를 정할 수 없어서
			while(rs.next()) {
				String dname = rs.getString("dname");
				v.add(dname);
			}
			years = new String[v.size()];
			v.copyInto(years);//0~? 방에 한 번에 값을 넣는다.타입,파라미터 갯수 맞춰야 한다.
		}catch(Exception e) {
			
		}
		//years = new String[10];
		return years;
	}

}
