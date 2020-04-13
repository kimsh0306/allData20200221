package study.sungjuk;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BorderLayoutTest2{
	JFrame jf = new JFrame();//디폴트 레이아웃이 BorderLayout이다. [동,서,남,북,중앙] 원하는 위치에 배치할 수 있도록 도와주는 클래스.
	//>>버튼을 다섯 개 추가, 버튼을 사용하고 싶다면 별도의 레이아웃을 만든다.
	JPanel jp_north		= new JPanel();
	JLabel jlb_su		= new JLabel("인원수");//서쪽에 붙일 라벨 "인원수"
	JLabel jlb_su2		= new JLabel("인원수");//남쪽에 붙일 라벨 "인원수"
	JLabel jlb_inwon	= new JLabel("명");//
	JTextField jtf_inwon= new JTextField();//디폴트 생성자, 파라미터가 있는 생성자, 제공되는 클래스, 타입과 갯수를 맞춘다. 그것을 methodOverLoading이라고 한다.
	JTextField jtf_inwon2= new JTextField(15);//
	JPanel jp_south		= new JPanel();//디폴트 레이아웃이 FlowLayout으로 돼있다. 중앙에서부터 양쪽으로 펼치면서 배치해 준다.
	JPanel jp_west		= new JPanel();
	JPanel jp_east		= new JPanel();
	JPanel jp_center	= new JPanel();
	public BorderLayoutTest2() {//반환타입이 없기 때문에(반환타입은 무조건 있어야 함) "생성자".BorderLayoutTest 화면 사이즈를 변경할 수 있다.
		//>>화면 속지의 컬러
		jp_north.setLayout(new BorderLayout());//속지 레이아웃을 원래 디폴트 값인 "FlowLayout"에서 "BorderLayout"으로 바꿔주세요.
		jp_north.setBackground(Color.yellow);//yellow는 static이겠구나.
		jp_south.setBackground(Color.yellow);
		jp_south.setLayout(new FlowLayout(FlowLayout.LEFT));//위치를 왼쪽부터 시작하게 지정해 줌.
		jp_south.add(jlb_su2);
		jp_south.add(jtf_inwon2);
		jp_south.add(jlb_inwon);
		jp_west.setBackground(Color.yellow);
		jp_east.setBackground(Color.yellow);
		jp_center.setBackground(Color.gray);
		jp_north.add("West",jlb_su);//패널의 북서쪽에 "인원수"라벨을 붙여주세요.
		jp_north.add("Center",jtf_inwon);//패널의 북중앙에 텍스트입력창을 붙여주세요.
		//JFrame jf에 JPanel jp_north 다섯 개로 쪼갠 프레임에 패널로 라벨/버튼/텍스트테이블을 붙인다.
		jf.add("North",jp_north);//설정해 놓은 jp_north를 JFrame의 북쪽에 붙여라, 코드를 생성자 안에 썼다. initDisplay를 사용하지 않음.
		jf.add("South",jp_south);
		jf.add("West",jp_west);
		jf.add("East",jp_east);
		jf.add("Center",jp_center);
		jf.setSize(500,400);
		//화면에 JFrame을 출력해주세요.
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		new BorderLayoutTest2();
	}

}
