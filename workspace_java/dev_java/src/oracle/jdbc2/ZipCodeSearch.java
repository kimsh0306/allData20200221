package oracle.jdbc2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Vector;
public class ZipCodeSearch {
	//선언부
	String dong;
	//드라이버 클래스가 필요하다.-JDBCTest에서 꺼내 쓰자.
	//URL정보도 JDBCTest에서 꺼내 쓸 수 있다.
	//user와 pw는 생략할 수 있다. - 왜? 
	Connection 			con   = null;
	PreparedStatement 	pstmt = null;
	ResultSet 			rs    = null;
	//오라클 서버와 연결통로 만들기를 메소드를 꺼내보세요.
	//메소드 뒤에 Exception을 붙이는 건 드라이브 클래스를 잘못 작성하여 에러가 아닌
	//런타임에러 즉 ClassNotFoundException을 맞을 수 있기 때문에 선언하였다.
	public Connection getConnection() throws Exception{
		System.out.println("getConnection 호출 성공");
		//오라클 회사 정보를 수집함.
		Class.forName(JDBCTest._DRIVER);
		con=DriverManager.getConnection(JDBCTest._URL
									, JDBCTest._USER
									, JDBCTest._PW);
		return con;  //확보되어 sql문을 전달할수 있다.
	}
	//사용자로 부터 동을 입력 받는 메소드를 구현해 보세요.
	public String userInput() {
		System.out.println("동을 입력하세요.");
		Scanner scan = new Scanner(System.in);
		dong = scan.nextLine();
		return dong;
	}
	//main()-userInput[동이름결정]-getZipCodeList('당산동')
	//오라클서버에게 select문 전달-응답받기
	public ZipCodeVO[] getZipCodeList(String userDong) throws Exception//예외가 발생하면 나를 호출한 곳에서 처리를 받으세요, 예외처리를 내가 하지않고 미룬다.
	{
		System.out.println("getZipCodeList 호출 성공 "+userDong);
		ZipCodeVO zcVO = new ZipCodeVO();
		ZipCodeVO zcVOS[] = null;  //검색결과 개수를 알수없기떄문에 인.화 못함
		String sql = "";
		sql+= "SELECT address as 주소, zipcode as 우편번호";
		sql+=" FROM zipcode_t"; //띄어쓰기를 반드시 지켜야한다.
		sql+=" WHERE dong LIKE '%'||?||'%'";   //조회결과가 3건일 경우
		getConnection();  //필요할때 호출하는게 좋아서 
		pstmt = con.prepareStatement(sql);//하는 일이 인스턴스화와 유사하다
		pstmt.setString(1, userDong);//?들어갈 동이름이 결정됨
		rs = pstmt.executeQuery();//오라클 서버에게 처리를 요청함
		Vector<ZipCodeVO> v = new Vector<>();
		while(rs.next()) { //1커서 이동  , 3커서이동
			zcVO = new ZipCodeVO();
			zcVO.setAddress(rs.getString("주소"));
			zcVO.setZipcode(rs.getInt("우편번호"));
			v.add(zcVO);
			System.out.println("While문 : "+rs.next());//2커서이동    //rs.next() 현재 커서위치에 데이터가있습니까??
		}
		zcVOS = new ZipCodeVO[v.size()];
		v.copyInto(zcVOS);//벡터 자료구조에 들어있는 정보를 복사하기
		//System.out.println("while문 탈출");
		//오라클 서버에 요청을 보내기
		//서버에 요청하기 전에 사용자로 부터 동이름을 먼저 입력 받아야 한다.
		//zcVO.uid_no = 10;  //다른클래스에서 임의로 변경하거나 쓰는것을 막기 위해서 private을 사용한다.
		                     //문법에러-private 왜? 웹이나 앱에서 동시사용자가 많을때 변조되면 안됨.
		zcVO.setUid_no(10);
		printZipCode(zcVOS);//메소드 호출시에 타입표시 안함.
		return zcVOS;
	}
	
	//조회된 우편번호 목록을 출력해보기
	public void printZipCode(ZipCodeVO zcVOS[]) {
		for(ZipCodeVO zVO:zcVOS) {
			System.out.println(zVO.getAddress()+"   "+zVO.getZipcode());
		}
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		//JDBCTest._USER="hr";     static만 있으니까 계정이름 변경 가능함.
		//JDBCTest._DRIVER="";     [에러발생]final이 있으니까 불가하다.
		// TODO Auto-generated method stub

		ZipCodeSearch zs= new ZipCodeSearch();
		String userDong =zs.userInput(); //일부로 전역변수로 처리함
		if(zs.dong==null) {
			System.out.println("반드시 동을 입력해야 합니다.");
			return;
		}else {
			System.out.println("당신은 "+zs.dong+"을 입력하셨습니다.");
			ZipCodeVO zcVOS[]=zs.getZipCodeList(userDong);
		}
		
	
	}

}
