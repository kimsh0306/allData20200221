package athread.talk3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

//public class MessageRoom extends JPanel {
//테스트하는 동안에만 JFrame. 다시 JPanel로 변경했다. //이벤트처리 액션리스너
public class MessageRoom extends JPanel implements ActionListener{	
	TalkClientVer2 tc = null;
	//jp_first.add("Center",jta_display)
	//jp_first.add("South",jp_first_south)
	//JPanel 속지는 원래(디폴트) "FlowLayout"이다.
	//그러나 센터에 jta_display를 붙여야 하고, 남쪽에 jp_first_south 속지를 붙여야 하니까
	//"BorderLayout"으로 변경하자.
	JPanel 		jp_first 		= new JPanel();	//<Div id="d_msg"> id는 인스턴스 이름(jp_first)과 같다.
	StyledDocument sd_display	= new DefaultStyledDocument(new StyleContext());
	//이모티콘 때문에JTextArea가 아니라 JTextPane로. 파라미터***
	JTextPane	jta_display		= new JTextPane(sd_display);
	//센터 속지의 중앙에 배치
	JScrollPane jsp_display		= new JScrollPane(jta_display
									 ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
									 ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//남쪽에 들어갈 속지의 중앙에 jtf_msg를 배치하고(붙이고) 동쪽에 전송버튼을 배치하자. 
	//jp_first_south에 BorderLayout을 적용해야한다. initDisplay에서.
	JPanel 		jp_first_south 	= new JPanel();		//속지 남쪽에 한 개 더해서 쪼갠다.
	JTextField 	jtf_msg 		= new JTextField();
	JButton		jbtn_send 		= new JButton("전송");
	JPanel		jp_second		= new JPanel();		//중앙에 jsp_nick,남쪽에 버튼 여섯 개.(제이스크롤페인=>jsp)
	JPanel		jp_second_south	= new JPanel();		//버튼 여섯 개 놓을 하단 속지
	
	//남쪽에 들어갈 버튼 여섯 개 추가하기 - GridLayout으로 변경해야 한다.
	JButton		jbtn_whisper	= new JButton("1:1");
	JButton		jbtn_change		= new JButton("대화명변경");
	JButton		jbtn_fontColor	= new JButton("글자색");
	JButton		jbtn_emoticon	= new JButton("이모티콘");
	JButton		jbtn_blank		= new JButton("");
	JButton		jbtn_exit		= new JButton("종료");
	
	String cols[] = {"대화명"};			// 데이터 테이블의 헤더 컬럼명을 지정하기 위함.
	String data[][]	= new String[0][1];	//테이블 행,컬럼 값 지정
	//테이블 그릴 때 필요한 디폴트테이블모델**************************************************여기서 놓침
	//실제 데이터를 담는다
	DefaultTableModel 	dtm_nick = new DefaultTableModel(data,cols);	
	//데이터를 실제 테이블로 보여주는 형식
	JTable 				jtb_nick = new JTable(dtm_nick);				
	JScrollPane 		jsp_nick = new JScrollPane(jtb_nick
									  ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
									  ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	public MessageRoom(TalkClientVer2 tc) {
		this.tc = tc;
		initDisplay();
	}

	public MessageRoom() {}

	public void initDisplay() {
		//제이프레임의 레이아웃 속성 변경. 디폴트가 BorderLayout이기 때문에.
		this.setLayout(new GridLayout(1,2));
		
		//레이아웃 설정 변경-디폴트 FlowLayout에서 BorderLayout으로
		jp_second.setLayout(new BorderLayout());
		jp_second.add("Center",jsp_nick);
		jp_second_south.setLayout(new GridLayout(3,2));//인스턴스화를 해야하는 것이라 GridLayout 앞에 new를 붙여준다.
		jp_second.add("South",jp_second_south);	//jp_second_south속지를 우측 남쪽에 붙이자***
		
		//버튼 여섯 개를  남쪽 속지에 붙이자.
		jp_second_south.add(jbtn_whisper);
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_fontColor);
		jp_second_south.add(jbtn_emoticon);
		jp_second_south.add(jbtn_blank);
		jp_second_south.add(jbtn_exit);
		
		//레이아웃 설정 변경-디폴트 FlowLayout에서 BorderLayout으로  => setLayout을 호출하자.파라미터 값 알기***
		jp_first.setLayout(new BorderLayout());
		jp_first_south.setLayout(new BorderLayout());
		jp_first.add("Center",jsp_display);
		jp_first_south.add("Center",jtf_msg);
		jp_first_south.add("East",jbtn_send);
		jp_first.add("South",jp_first_south);	//jp_first_south속지를 좌측 남쪽에 붙이자***
		
		this.setBackground(Color.blue);	//배경색을 파랑으로 해줘
		//여기서 this는 JFrame, html에서는 window(윈도우라는 내장객체가 있다.)
		this.add(jp_first);         	//좌측 패널 붙이자
		this.add(jp_second);  			//우측 패널 붙이자
		this.setSize(500,400);			//가로세로 사이즈 지정
		this.setVisible(true);			//화면에 보여줘
	}
	
	//추상메소드를 오버라이드 해줘야 한다.(MessageRoom에 빨간 언더라인 해결)
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args) {
		MessageRoom mr = new MessageRoom();
		mr.initDisplay();
	}
}



/*
 ******선생님이 언급하신 내용********
 * 내장객체
 * 오브젝트 기본 개념
 * API 활용능력
 * 
 * 
 * 
 */