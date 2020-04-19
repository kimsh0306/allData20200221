package book.hyelim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class BookLogic implements ActionListener{

	/*ActionListener라는 인터페이스를 상속받은 것이다.
	인터페이스를 상속 받으면 그 인터페이스 안에 선언 되어있는 추상 메소드를 구현을 꼭 해줘야 한다.
	그래서 클래스 명인 BookLogic에 에러 빨간 줄이 나타난다.
	거기에 마우스 오버 해보면 Add unimplemented method가 나타나고,
	그걸 클릭하면 ActionLi
	
	 * 추상 메소드
	ActionListener라는 인터페이스가 존재한다는 것은 그 인터페이스가 정의 되었다는 말이다.
	그러면 그 인터페이스 안에 어떤 내용들이 있을텐데, 그 내용들 중에 추상 메소드가 있어서 인터페이스를
	상속받을 때는 그 인터페이스가 가진 추상 메소드를 꼭! 구현 해줘야 한다.
	추상메소드란, 인터페이스가 꼭 가져야 하는 어떤 기능...이라고 생각하자.
	예를 들어 ActionListener라면 이벤트 처리를 꼭 해줘야하니까 ActionPerformed라는 추상 메소드를 가지고있다.
	하지만 사용자가 이벤트 처리를 하면서 어떤 행동?을 원하는 지는 상황마다 다를 것이다.
	예를 들어, 어떤 때는 이벤트가 들어오면 어떤 문장을 출력하게 하고 싶을 수도 있고, 어떤 때는 이벤트가 들어오면
	다른 어떤 메소드를 실행시키고 싶을 수도 있다. 이게 당연한 상황이다. 다시 말해서, ActionListener는
	이벤트 처리를 해주는 ActionPerformed라는 메소드를 무조건 가지고 있어야 한다. 왜냐면 그게 ActionLister라는
	인터페이스를 상속받는 목적이니까. 하지만 ActionPerformed 안에서 어떤 행동을 할 지는 결정되지 않아서 ActionLister라는
	인터페이스를 정의 할 때 어떤 행동을 할 지 정의해주지 못 했다. 그래서 인터페이스를 만들 때는 그냥 ActionPerformed를 *추상메소드*로 남겨놓고,
	 사용자가 이 인터페이스를 상속 받을 때 이 메소드를 구현하게끔 한 것이다.
	결론 : 인터페이스를 상속 받을 땐 추상 메소드를 구현해줘야 한다.
	 */
	
	/*
	 * BookLogic.java
	 * 여기에서 ActionListener를 처리해줄 것이다.
	 * ActionPerformed 메소드를 여기에다 만든다는 뜻이다.
	 * 버튼을 누르면 여기서 이벤트 처리가 되는데,
	 * 조회 버튼을 누르면 Dao에서 정보를 가지고 와야 하고
	 * 추가 버튼을 누르면 Dao를 통해 DB에 값을 추가해주니까
	 * '이 클래스에서(BookLogic) Dao 클래스를 인스턴스화 해야겠다...!'
	 * 라는 생각을 할 수 있다.
	 * 
	 * 암튼. 이 클래스에서는 BookView의 이벤트를 처리해준다. 그래서 BookView도 필요하다는
	 * 것을 생각할 수 있다.
	 * 근데 이벤트 처리를 해주려면 BookView의 원본이 필요하다. this로 받아와야 한다는 말이다.
	 * 처음에 화면은 BookView에서 띄운다. 그리고 BookView에 있는 버튼(조회, 추가)을 누른다고 생각해보자.
	 * 버튼을 눌러서 그 이벤트 처리를 BookLogic에서 해준다. 그럼 BookLogic에서는
	 * Dao와 연결되어 데이터를 가지고 오고, 그것을 다시 BookView로 넘겨줘야 한다.
	 * 근데 넘겨줄 때 맨 처음에 열린 화면에 그 데이터를 띄워줘야 할 것이다.
	 * 만약 여기서 BookView를 새로 생성했다면, 처음에 화면을 띄운 BookView와 
	 * 여기서 생성한 BookView의 주소번지가 다르다. 그러면 화면에 정보를 나타내지 못 한다.
	 * 그러니까 지금은 BookView와 BookLogic이 서로 필요한 상황이라는 것이다.
	 * 근데 또 생각해야 할 것이, BookView가 화면을 띄워주는 클래스이기 때문에 이 원본이 변해선 안 된다.
	 * 그러니까 BookLogic과 BookView 사이의 인스턴스화를 어떻게 해야 하나 생각해보면 BookView에서
	 * BookLogic bLogic = new BookLogic(this);//여기 this에는 BookView의 원본 주소번지가 들어간다.
	 * 이렇게 하면 될 것이다. 이렇게 하면 BookLogic의 생성자를 호출하면서 BookView 자기 자신의 주소번지를 넘긴다.
	 * 그러면 BookLogic에서는 BookView 타입의 파라미터를 갖는 생성자를 가지고 있어야 한다.
	 * 그리고 그 파라미터를 받아서 이 클래스(BookLigic)에 있는  BookView 타입의 변수에 저장시켜주면
	 * 이제 이 클래스에서는 BookView의 원본 주소번지를 가지게 된다.
	 * 결국, 이 클레스에서는 BookView를 인스턴스화 하지 않는다. 생성자 안에서 BookView의 주소번지를 받을 뿐이다.
	 */
	BookView bView = null; //원본 주소번지를 받아서 이 클래스의 ActionPerformed에서 사용을 할 것이다.
	//이걸 전역변수로 선언 해놓고, 여기에 생성자의 파라미터로 받은 bView를 저장하자.
	
	//생성자
	public BookLogic(BookView bView) {
		this.bView = bView;//파라미터로 받은 값을 전역변수에 저장을 시켜주었다. 이제 전역변수인 this.bView에는
		//화면을 띄운 BookView인 그 원본 주소번지가 저장되어있다.
		System.out.println("BookLogic 생성자에서 BookView를 받아서 저장해주었다.");
		//위의 출력문이 나오면 성공적으로 연결 되었다는 뜻이다.
	}
	BookDao bDao = new BookDao();
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 발생할 때마다 이 메소드가 자동으로 호출된다. 호출이 되면서 발생된 그 이벤트의 정보가 ae에 담긴다.
		Object obj = ae.getSource();//ae.getSource()를 하면 ae의 주소번지를 가져온다.
		//getSource()의 반환타입이 Object라서 Object 타입의 변수 obj에 담아주었다.
		
		//버튼을 클릭할 때 이 메소드가 수행된다. 확인해보자. 
		System.out.println("이벤트 발생");
		System.out.println("이벤트 정보 : " + ae + "\n이벤트 주소번지 : " + ae.getSource());
		
		//만약 조회 버튼을 눌렀다면??
		if(obj == bView.jbtn_sel) {//발생한 이벤트의 주소번지가 jbtn_sel이라면 사용자는 조회버튼을 누른 것이다.
			System.out.println("조회 버튼 눌렀다.");//이 때는 조회와 관련된 행동을 하고 하고 싶으니까 if문으로 어떤 이벤트가 발생했는지 구분을 한 것이다.
			//여기서 Dao를 사용하자
			List<Map<String, String>> bookList = bDao.getBookList();
			//bookList에 db의 정보가 담겼다. 이제 이걸 이용해서 View의 화면에 뿌려보자
			/*
			 * 테이블에 db의 정보 나타내기
			 * 우선, 실질적인 데이터는 dtm이 가지고 있다. 그래서 db에서 가져온 데이터를 dtm에 넣어줄 것이다.
			 * 근데 dtm의 임시 저장 공간으로 BookView에서 data라는 배열을 넣어줬었는데, 그건 생각하지 말자.
			 * 그냥 임시로 데이터를 넣을 수 있는 공간을 만들어놓은 것일 뿐이라고 생각하자.
			 * 데이터가 생기면  그냥 dtm에 넣어주면 된다.
			 */
			//bookList에 데이터가 담겨있다. 이 데이터를 한 줄 한 줄 dtm에 추가해 줄 것이다.
			//bookList의 각각의 방마다 한 줄 한 줄 추가해줄 데이터를 가지고 있다. Map을 말 하는 것이다.
			//그러니까 Map 하나가 dtm의 한 줄이 된다는 소리다. 오라클 테이블의 한 로우를 가져와서 Map에 담았던 것을 생각하자
			//다시 말 하면 List의 방 하나에 한 로우에 담을 정보들이 들어있다는 말이다.
			for(int i = 0; i<bookList.size(); i++) {
				/* **dtm에 로우 추가하는 방법**
				 * dtm에 한 로우를 추가하려면 벡터가 필요하다. 원래 그렇다.
				 * 벡터에다가 정보를 넣어놓고 그 벡터 자체를 dtm에 addRow시키면 dtm에 한 줄이 추가 된다.
				 * 여기서는 벡터에 책 제목, 저자, 설명을 추가 시키고, 그 벡터를 dtm에 추가 시키면 된다.
				 */
				Vector<String> aRow = new Vector<>();
//				aRow.add("dldldl");//이렇게 값을 입력하면 0번부터 차례로 채워진다.
//				aRow.add(0, "안녕");//이렇게 인덱스와 값을 적으면 인덱스번째 방에 값이 들어간다. 0번째 방에 안녕이라는 값이 들어간다.
				aRow.add(bookList.get(i).get("title"));
				aRow.add(bookList.get(i).get("author"));
				aRow.add(bookList.get(i).get("info"));
				bView.dtm_book.addRow(aRow);
			}
		} 
		else if(obj == bView.jbtn_ins) {
			System.out.println("입력 버튼 눌렀다.");
		}
	}
	
	public static void main(String[] args) {
	}
	
}
