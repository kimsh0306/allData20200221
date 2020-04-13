package com.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleCallableStatement;

public class ProcDeptList {
	String url	 = "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
	String user	 = "scott";
	String pw	 = "tiger";
	Connection con 			= null;//java.sql.*
	//포로시저를 call할 대는 CallableStatement를 사용한다.
	CallableStatement cstmt = null;
	OracleCallableStatement ocstmt = null;
	public List<Map<String,Object>> deptList(){
		List<Map<String,Object>> dList = null;
		try {
			Class.forName(arg0)
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
		
		return dList;
	}
	public static void main(String[] args) {
		ProcDeptList pdl = new ProcDeptList();
		List<Map<String,Object>> dList = null;
		dList = pdl.deptList();
		if(dList == null) {
			System.out.println("조회 결과가 없습니다.");
		} else {
			for(Map<String,Object> rMap:dList) {
				
			}
		}
	}
}
