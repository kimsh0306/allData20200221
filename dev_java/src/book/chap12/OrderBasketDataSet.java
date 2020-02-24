package book.chap12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBConnectionMgr;

//단위 테스트용
public class OrderBasketDataSet {
	//세트로 외운다. 조회할 때는 세 가지.
	Connection con 	= null;
	PreparedStatement pstmt = null;
	ResultSet rs 	= null;
	//DB를 연동할 때 여기 까지. 네 가지.
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	
//main메소드를 직접 컨트롤 할 수 없다. JVM이 컨트롤하기 때문에.
	public ArrayList<OrderBasketVO> getList2()  //getList2로 변경***
	{
		ArrayList<OrderBasketVO> al = new ArrayList<OrderBasketVO>();
		StringBuilder sql = new StringBuilder();                            
		sql.append("SELECT                                                  	");
        sql.append("	 decode(b.rno,1,a.indate_vc,2,'총계') indate_vc			");
        sql.append("	,sum(qty_nu) t_qty				                        ");
        sql.append("	,sum(qty_nu*price_nu) t_price	                        ");
        sql.append("FROM t_orderbasket a                                   	    ");
        sql.append("	,(SELECT rownum rno FROM dept WHERE rownum <3)b   		");
        sql.append("GROUP BY decode(b.rno,1,a.indate_vc,2,'총계')          		");
        sql.append("ORDER BY decode(b.rno,1,a.indate_vc,2,'총계')          	 	");
		
        //힌트를 얻기 위해서 트라이캐치 사용.
        try {
        	con = dbMgr.getConnection();
        	pstmt = con.prepareStatement(sql.toString());
        	rs = pstmt.executeQuery();
        	//VO는 한 번에 한 개 로우만 담을 수 있어요. 두 개 로우는 안되죠.
        	//VO에는 변수 하나에 한 개 값만 담는 변수를 선언했기 때문이죠.
        	OrderBasketVO obVO = null;
        	while(rs.next()) {
        		obVO = new OrderBasketVO();
        		//오라클에서 꺼낸 값은 rs로 꺼내고 
        		//위에서 꺼낸 값은 obVO에 선언된 변수 중 indate_vc변수에 값을 
        		//담아주세요.
        		//왜 setter메소드로 값을 자꾸만 담는 거야?
        		obVO.setIndate_vc(rs.getString("indate_vc"));
        		obVO.setT_qty(rs.getInt("indate_vc"));
        		obVO.setT_price(rs.getInt("indate_vc"));
        		al.add(obVO);
        	}
        		
        }catch(SQLException se) {//오라클에서 발생되는 에러메시지 잡기
        	//자바에러는 이클립스에서 잡고 오라클 에러는 토드에서 잡는 게 좋겠다.
        	System.out.println(se.toString());
        }catch(Exception e) {//자바 전체에서 발생되는 에러메시지 잡기
        	System.out.println(e.toString());
        }
        return al;//al=null;
	}
	public ArrayList<OrderBasketVO> getList()
	{
		ArrayList<OrderBasketVO> al = new ArrayList<OrderBasketVO>();
		OrderBasketVO obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-19");
		obVO.setT_qty(150);
		obVO.setT_price(560000);
		al.add(obVO);
		
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-20");
		obVO.setT_qty(105);
		obVO.setT_price(360000);
		al.add(obVO);
		
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("총계");
		obVO.setT_qty(255);
		obVO.setT_price(920000);
		al.add(obVO);
		
		return al;
	}
	
//	public static void main(String[] args) {
//		//이렇게는 잘 쓰지 않는 이유를 아는가.
//		//ArrayList<Integer> a12 = new ArrayList<Integer>();
//		
//		ArrayList<OrderBasketVO> al = new ArrayList<OrderBasketVO>();
//		OrderBasketVO obVO = new OrderBasketVO();
//		obVO.setIndate_vc("2020-02-19");
//		obVO.setT_qty(150);
//		obVO.setT_price(560000);
//		al.add(obVO);
//		
//		obVO = new OrderBasketVO();
//		obVO.setIndate_vc("2020-02-20");
//		obVO.setT_qty(105);
//		obVO.setT_price(360000);
//		al.add(obVO);
//		
//		obVO = new OrderBasketVO();
//		obVO.setIndate_vc("총계");
//		obVO.setT_qty(255);
//		obVO.setT_price(920000);
//		al.add(obVO);
//		
//		//개선된 for문
//		for(OrderBasketVO obVO2:al) {
//			System.out.print(obVO2.getIndate_vc()+"   "+obVO2.getT_qty()+"   "+obVO2.getT_price()+"\n");
//		}
//		
//		System.out.println(al.get(0).getT_price());
//	}

}
