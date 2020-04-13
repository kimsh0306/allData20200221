package study.sungjuk;

import javax.swing.JButton;
import javax.swing.JFrame;

	public class BorderLayoutTest{
		JFrame jf = new JFrame();//디폴트 레이아웃이 BorderLayout[동,서,남,북,중앙] 원하는 위치에 배치할 수 있도록 도와주는 클래스.
		//버튼을 다섯 개 추가, 버튼을 사용하고 싶다면 별도의 레이아웃을 만든다.
		JButton jbtn_north	= new JButton("북쪽");
		JButton jbtn_south	= new JButton("남쪽");
		JButton jbtn_west	= new JButton("서쪽");
		JButton jbtn_east	= new JButton("동쪽");
		JButton jbtn_center	= new JButton("중앙");
	public BorderLayoutTest() {//BorderLayoutTest 화면 사이즈를 변경할 수 있다.
		jf.add("North",jbtn_north);//그 위치에 들어갈 버튼의 주소번지, 코드를 생성자 안에 썼다. initDisplay를 사용하지 않음.
		jf.add("south",jbtn_south);
		jf.add("west",jbtn_west);
		jf.add("east",jbtn_east);
		jf.add("center",jbtn_center);
		jf.setSize(500,400);
		//화면에 JFrame을 출력해주세요.
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		new BorderLayoutTest();
	}

}
