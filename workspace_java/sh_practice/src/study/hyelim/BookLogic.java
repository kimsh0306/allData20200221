package study.hyelim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class BookLogic implements ActionListener{
	/*
	추상메소드
	ActionListener라는 인터페이스가 존재한다는 것은 그 인터페이스가 어떤 누군가에 의해 정의되었다는 말이다.
	그러면 그 인터페이스 안에 어떤 내용들이 있을텐데, 그 내용들 중에 추상 메소드가 있다.
	인터페이스를 상속받을 때는 그 추상 메소드를 꼭 구현해 줘야 한다.
	추상메소드란, 인터페이스가 꼭 가져야 하는 어떤 기능...이라고 생각하자.
	
	이 클래스에서는 BookView의 이벤트를 처리해 준다. 그래서 BookView도 필요하다는 것을 생각 할 수 있다.
	근데 이벤트를 처리 해주려면 BookView의 원본이 필요한다. this로 받아와야 한다는 말이다.***
	처음에 창은 BookView에서 띄운다. 그리고 BookView에 있는 버튼을 누른다고 생각해 보자.
	버튼을 눌러서 그 이벤트 처리를 BookLogic에서 해준다. 그럼 BookLogic에서는 
	Dao와 연결되어 데이터를 가지고 오고, 그것을 다시 BookView로 넘겨줘야 한다.
	근데 넘겨줄 때 맨 처음에 열린 화면에 그 데이터를 띄워줘야 할 것이다.
	만약 여기서 BookView를 새로 생성했다면, 처음에 화면을 띄운 BookView와 
	여기서 생성한 BookView의 주소번지가 다르다. 그러면 화면에 정보를 나타내지 못 한다.
	그러니까 지금은 BookView와 BookLogic이 서로 필요한 상황이라는 것이다.
	근데 또 생각해야 할 것이, BookView가 화면을 띄워주는 클래스이기 때문에 이 원본이 변해선 안 된다.
	그러니까 인스턴스화 할 때는 BookView에서 한다.***
	*/
	
	/*
	ActionListener 안에는 추상 메소드가 있다. ActionListener라는 인터페이스를 상속받았다.
	인터페이스를 상속 받으면 그 인터페이스 안에 선언 되어있는 추상 메소드 구현을 꼭 해줘야 한다.
	BookLogic에 에러 빨간 줄이 나타난다.
	거기에 마우스 오버 해보면 Add unimplemented method가 나타나고,
	그걸 클릭하면 ActionListener
	*/
	
	/*
	여기에서 ActionLisener를 처리해 줄 것이다.
	ActionLisener 메소드를 여기에다 만든다는 뜻이다.
	버튼을 누르면 여기서 이벤트 처리가 되는데,
	조회 버튼을 누르면 Dao에서 정보를 가지고 와야 하고
	추가 버튼을 누르면 Dao를 통해 DB에 값을 추가해주니까
	'이 클래스에서(BookLogic) Dao 클래스를 인스턴스화 해야겠다.'
	라는 생각을 할 수 있다.
	*/
	
	//원본 주소번지를 받아서 이 클래스의 ActionPerformed에서 사용을 할 것이다.
	//이걸 전역변수로 선언 해놓고, 여기에 생성자의 파라미터로 받은 bView를 저장하자.
	BookView bView = null;
	
	//생성자
	public BookLogic(BookView bView) {
		this.bView = bView;
	}
	
	BookDao bDao = new BookDao();
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();//ae.getSource()를 하면 ae의 주소번지를 가져온다.
		
		if(obj == bView.jbtn_sel) {
			List<Map<String,String>> bList = bDao.getBookList();
			
		}
		
			
		
	}
}
