package book.chap12;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//JFrame을 상속받았으므로 자식 클래식인 OrderBasketTest클래스의 인스턴스 변수로
//부모가 가진 변수나 메소드를 누릴 수 있다.
public class OrderBasketTest extends JFrame {
	//헤더정보 추가하기
	String cols[] = {"날짜","판매수량","매출액"};
	String data[][] = new String[0][3]; //[로우][컬럼]
	
	//화면그리기
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	
	//서로 연관(의존도)이 있는 클래스 사이에서 별도의 메소드나 코딩 없이 
	//생성자의 파라미터를 통해서 값을 초기화 할  수 있다.***
	JTable jtb = new JTable(dtm);
	
	//제이스크롤에 붙이지 않으면 헤더 정보를 따로 해줘야 하므로 제이스크롤을 사용 한다.
	JScrollPane jsp = new JScrollPane(jtb);
	
	public OrderBasketTest() {
		
	}
	
	public void initDisplay() {
		//제이스크롤을 붙일 때 제이프레임의 센터에 붙인다.
		this.add("Center",jsp);
		this.setSize(500, 400);
		this.setVisible(true);
		dataSetMapping();
	}
	
	public void dataSetMapping() {
		OrderBasketDataSet ds = new OrderBasketDataSet();
		ArrayList<OrderBasketVO> al = ds.getList2();	  //getList2로 변경***
		for(int x=0;x<al.size();x++) {
			Vector v= new Vector();
			v.add(al.get(x).getIndate_vc());
			v.add(al.get(x).getT_qty());
			v.add(al.get(x).getT_price());
			dtm.addRow(v);
		}
	}
	public static void main(String[] args) {
		OrderBasketTest obt = new OrderBasketTest();
		obt.initDisplay();
	}

}
