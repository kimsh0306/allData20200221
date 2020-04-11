package com.jdbc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;

import com.util.DBConnectionMgr;

public class PLSQLTest {
   DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
   Connection con = null;
   CallableStatement cstmt = null;
   public void empSalUpdate() {
      int result = 0;
      try {
         con = dbMgr.getConnection();
         cstmt = con.prepareCall("{call proc_emp_salupdate(?,?)}");
         BufferedReader br = 
               new BufferedReader(
                     new InputStreamReader(System.in));
         System.out.print("사원번호를 입력하세요 :");
         String v_empno = br.readLine();
         cstmt.setInt(1, Integer.parseInt(v_empno));
         cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);         
         result = cstmt.executeUpdate();
//         con.commit();
//         con.rollback();
         System.out.println("result : "+cstmt.getString(2));
      } catch (Exception e) {
         System.err.println("[Exception] : "+e.toString());
      }
   }
   public static void main(String[] args) {
      PLSQLTest pl = new PLSQLTest();
      pl.empSalUpdate();
   }

}