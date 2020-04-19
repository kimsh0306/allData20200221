package study.hyelim;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookView {
	
	JFrame jf_book = new JFrame();
	JPanel jp_north = new JPanel();			//버튼을 붙일 패널
	JButton jbtn_sel = new JButton("조회");	//파라미터로 버튼에 표시할 문자 넣어주기
	JButton jbtn_ins = new JButton("추가");
	
	String[] cols = {"책제목","저자","설명"};
	String[][] data = new String[0][3];
	DefaultTableModel dtm_book = new DefaultTableModel(data,cols);

	JTable jt_book = new JTable(dtm_book);//JTable은 그냥 양식일 뿐이다. 데이터를 넣을 수 없다는 것이다.
	
	//JScrollPane은 데이터의 양이 많을 경우 스크롤바를 제공해 준다.
	JScrollPane js_book = new JScrollPane(jt_book, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
												 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//BookLogic에서 이벤트를 처리하기 위해 BookLogic을 인스턴스화 한다.
	//여기서 this를 넣는 것은 원본 주소번지가 변하면 안되기 때문이다.
	BookLogic bLogic = new BookLogic(this);
	
	//화면 구성
	public void initDisplay() {
		//JPanel은 기본 레이아웃이 FlowLayout이다.
		//GridLayout으로 설정하자.
		jp_north.setLayout(new GridLayout(1, 2));//1행2열로 칸이 만들어졌다.
		//이제 버튼 추가
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		
		//JFrame의 기본 레이아웃은 BorderLayout이다.
		//BorderLayout은 동,서,남,북 중앙에 Component가 배치된다.
		jf_book.add("North",jp_north);//North방향에 jp_north를 추가해줬다.
		jf_book.add("Center",js_book);
		
		///여기까지 했으면 JFrame의 구성이 끝났다. 이제 눈에 보이게 하자.
		
		jf_book.setSize(300,400);//크기를 가로 300에 세로 400으로 설정했다.
		jf_book.setVisible(true);//눈에 보이게 해줬다.
	}
	
	//생성자를 만들어 보자.
	public BookView() {
		initDisplay();
	}
	
	
	public static void main(String[] args) {
		//화면 그리는 메소드인 initDisplay를 BookView의 생성자가 호출하게 설정해 뒀다.
		//그러니까 여기서 디폴트 생성자를 이용해서 BookView를 인스턴스화 해주면 화면이 나타날 것이다.
		BookView bView = new BookView();
		
		
		
	}
	
}
