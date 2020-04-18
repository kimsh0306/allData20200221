package book.hyelim;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/*
 * BookView.java에서 화면을 그렸다. 그러면 이제 이벤트 처리가 필요하다. 그래서 BookLogic.java를 만들었다.
 * BookLogic과 BookView가 연결이 되어야 한다. 인스턴스화를 어떻게 할 지 고민을 한다. 결국, BookView에서
 * BookLogic을 인스턴스화 하면서 BookView 자신의 주소번지를 넘겼다. BookLogic에서는 그것을 받아서 전역변수로
 * 저장시켰다.
 * BookView에서 이벤트가 발생하면 BookLogic에서 그것을 처리한다. 그래서 BookLogic에서 ActionListener
 * 인터페이스를 상속 받았다. BookView의 jbtn_sel, jbtn_ins에 addActionLister(bLogic) 처리를 해주었다.
 * 그러면 BookView에서 jbtn_sel, jbtn_ins를 누르면 BookLogic의 ActionPerformed가 호출된다.
 * 그 안에서 발생된 이벤트가 jbtn_sel인지, jbtn_ins인지 판별한다.
 * jbtn_sel이라면 BookDao.java를 통해 DB에 있는 값을 불러와야 한다.
 * BookDao.java를 만들었고, 그 안에getBookList()메소드를 선언했다.
 * getBookList()에서는 DB연동을 하고, List<Map<String, String>> 타입의 변수 bList를 반환해준다.
 * BookLogic에서 bList를 bookList로 저장해주었다. 그럼 그 bookList안에는 DB의 데이터가 들어있다.
 * bookList는 List<Map<String, String>> 타입이다. 그럼 각각의 방 안에 Map이 담겨있는 것이고, 그 Map에는
 * 한 로우의 정보가 담겨있다. 그 정보를 꺼내서 BookView의 dtm_book에 담기 위해 for문을 이용해서 각각의 방에 접근을 하고,
 * 방에 접근을 해서 정보를 빼서 벡터에 담았다. 벡터에 담고 나서는 dtm_book에 addRow 시켜줬다. 벡터에 담는 이유는
 * DataTableModel에 addRow라는 메소드가 있는데, 그 메소드의 파라미터가 벡터로 지정되어있기 때문이다.
 * for문 안에서 한 줄 한 줄 dtm_book에 추가를 시켜줄 것이고, for문이 끝나면 DB의 정보가 모두 들어간 상태가 된다.
 * 이렇게 하면 조회 동작 끝!
 */
public class BookView {

	JFrame jf_book = new JFrame();
	
	JPanel jp_north = new JPanel();//버튼을 붙일 패널
	JButton jbtn_sel = new JButton("조회");//파라미터로 버튼에 표시할 문자 넣어주기
	JButton jbtn_ins = new JButton("입력");
	
	//DefaultTableModel에 데이터를 담아줘야 한다.
	String[] cols = {"책 제목", "저자", "설명"};//dtm에 담길 컬럼명이다.
	String[][] data = new String[0][3];//0행 3열의 2차 배열을 만들었다.
	//데이터를 담을 예비 공간을 만들어둔 것이고, 실제 데이터를 입력 할 때는 DB연동을 통해 데이터를 가져오고,
	//그 값을 dtm에 추가해 줄 것이다.
	//0행으로 설정해둔 이유는 아직 데이터를 넣지 않았기 때문이다. 이렇게 해두면 
	//3열으로 설정해둔 이유는 컬럼이 세 개이기 때문이다.
	//dtm을 잘 이해해야 한다.
	//dtm은 실질적인 데이터가 들어가는 양식이라고 생각하자. 그러니까 컬럼을 설정해 주었고, 디비에서 가져오는 데이터를
	//넣어줄 예비 공간도 만들어 놓았다.
	DefaultTableModel dtm_book = new DefaultTableModel(data, cols);
	//위에서 배열로 생성한 것들을 dtm에 넣어주었다. 이제 컬럼으로 cols 배열을 가지고 있게 된다.
	//여기서 cols는 html에서 thead의 역할이고, data는 tbody의 역할이다. 나온 김에 한 번 생각해보자^o^
	JTable jt_book = new JTable(dtm_book);//JTable은 그냥 양식일 뿐이다. 데이터를 넣을 수 없다는 것이다.
	//실질적인 데이터는 dtm이 가지고 있으니까 JTable을 생성하면서 넣어주는 것이다.
	//파라미터로 dtm을 넣어줄 수 있는 이유는 JTable이 가지고 있는 생성자 중에 dtm을 받아서 처리해주는 생성자가 있기 때문이다.
	//API를 확인해보자..!
	JScrollPane js_book = new JScrollPane(jt_book, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED//수직방향(세로방향)스크롤바는 필요할 때 넣어주겠다.
											 	 , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//수평방향(가로방향)스크롤바는 안 넣겠다.
	//JScrollPane은 데이터의 양이 많을 경우 스크롤바를 제공해준다. JTable의 데이터가 많을 경우 여기에다 스크롤바를 넣어줄 것이기
	//때문에 파라미터로 jt_book을 넣었다.
	
	//BookLogic에서 이벤트를 처리하기 위해 BookLogic을 인스턴스화 한다.
	BookLogic bLogic = new BookLogic(this);//Logic에서 원본 주소번지가 필요한다.
	
	//이제 화면을 구성해보자.
	public void initDisplay() {
		
		//조회, 추가 버튼 이벤트처리를 Logic에서 해줄 것이다.
		jbtn_sel.addActionListener(bLogic);
		jbtn_ins.addActionListener(bLogic);
		//파라미터에 이벤트 처리를 해줄 위치를 넣어주자.
		
		//JPanel은 기본 레이아웃이 FlowLayout이다.
		//FlowLayout은 설정해준 방향에서 시작해서 순차적으로 component(버튼, 라벨 이런 추가해주는 것들)가 채워진다.
		//지금 버튼을 추가할 건데 버튼이 두 개니까 반반 넣고 싶다.
		//그러니까 jp_north의 레이아웃을 GridLayout으로 바꾼다.
		jp_north.setLayout(new GridLayout(1,2)); //1행2열로 칸이 만들어졌다. >> ㅁㅁ 이 모양이라는 뜻이다.
		//layout도 설정 해줬으니 이제 버튼을 추가한다.
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins); //만약 설정해 놓은 GridLayout보다 많은 component를 추가하면 Exception 이 일어난다. 궁금하면 해보자
		
		//JFrame의 기본 레이웃이 BorderLayout이다.
		//BorderLayout은 동, 서, 남, 북, 중앙에 Component가 배치된다.
		//순서는 모르겠지만 굳이 필요 없는 게 내가 원하는 방향으로 Component를 추가해줄 거니까 필요없다.
		jf_book.add("North", jp_north);//North 방향에 jp_north를 추가해줬다.
		//jp_north에 버튼이 들어있으니까 JFrame에 버튼 두 개가 추가된 것이다.
		jf_book.add("Center", js_book);//js_book이 가장 바깥쪽에 있으니까 dtm, jt_book 이런 거 필요 없이 js만 붙여주면 된다. 
		
		//////여기까지 했으면 JFrame의 구성이 끝났다. 이제 눈에 보이게 하자.
		
		jf_book.setSize(300,400);//크기를 가로 300에 세로 400으로 설정했다.
		jf_book.setVisible(true);//눈에 보이게 해줬다.
		
	}
	
	
	
	//생성자를 만들어보자. 디폴트 생성자를 만들어서 main에서 이 클래스를 인스턴스화 할 때
	//자동으로 화면이 실행되게끔 하자. 그러려면 생성자 안에서 initDisplay를 호출해야 한다.
	public BookView() {//디폴트 생성자이다. 생성자를 선언할 때는 반환타입을 적지 않는다.
		initDisplay();
		System.out.println("jbtn_sel의 주소 : " + jbtn_sel);
	}
	
	//main을 만들자
	public static void main(String[] args) {
		//화면 그리는 메소드인 initDisplay를 BookView의 생성자가 호출하게 설정해뒀다.
		//그러니까 여기서 디폴트 생성자를 이용해서 BookView를 인스턴스화 해주기만 하면 화면이 나타날 것이다.
		BookView bView = new BookView();
	}
	
}
