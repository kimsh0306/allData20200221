package study.hyelim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * 이벤트 처리 순서
 1. 이벤트 소스를 지원하는 이벤트 처리 인터페이스를 implements한다.
 2. ActionListener가 선언하고 있는 추상 메소드를 재정의 하기
 3. jbtn_exit.addActionListener(this) 호출하여 이벤트 소스와
 	이벤트 처리를 담당하는 클래스를 연결하기
 */

public class BaseBallGame {
	
	//화면과 관련된 코드 추가 시작
	JFrame		jf_bbgame	= new JFrame();
	JMenuBar	jmb_bbgame	= new JMenuBar(); //JFrame 안에 메뉴바를 추가하기
	JMenu		jm_game		= new JMenu("게임");//JMenuBar안에 들어갈 메뉴 추가하기
	JMenu		jm_info		= new JMenu("도움말");
	//JMenuItem : JMenu 아래에 들어갈 메뉴 내용들
	JMenuItem	jmi_next	= new JMenuItem("다음게임"); //버튼말고 JMenuItem을 사용해서 메소드 재사용성을 증명
	JMenuItem	jmi_clear	= new JMenuItem("지우기");
	JMenuItem	jmi_dap		= new JMenuItem("정답");
	JMenuItem	jmi_exit	= new JMenuItem("나가기");
	JTextArea	jta_display	= new JTextArea("");
	JScrollPane	jsp_display	= new JScrollPane(jta_display);
	JTextField	jtf_input	= new JTextField();
	JButton		jbtn_next	= new JButton("다음게임");
	JButton		jbtn_clear	= new JButton("지우기");
	JButton		jbtn_dap	= new JButton("정답");
	JButton		jbtn_exit	= new JButton("나가기");
	
	//JTextArea와 JTextField를 붙일 속지 추가하기
	JPanel jp_center = new JPanel();
	//버튼 4개를 붙일 속지 추가하기
	JPanel jp_east = new JPanel();
	
	//화면과 관련된 코드 추가 끝
	
	
	//디폴트 생성자 선언하기
	public BaseBallGame() {
		//생성자 안에서 메소드를 호출하면 인스턴스화 없이도 호출이 가능하다.
		initDisplay();
	}
	//****************************************************//
	
	//나가기 버튼 처리
	public void exitGame() {
		System.exit(0);
	}//메소드 중심의 코딩 전개 : 재사용성을 높이는 코딩의 첫 단계이다.
	
	//화면 처리하기
	public void initDisplay() {
		
		jp_center.setLayout(new BorderLayout());//보더레이아웃을 해야 동서남북을 설정할 수 있다.
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_input);
		jbtn_next.setBackground(new Color(214,240,255));
		jbtn_next.setForeground(new Color(0,0,0));
		jbtn_clear.setBackground(new Color(196,222,255));
		jbtn_clear.setForeground(new Color(0,0,0));
		jbtn_dap.setBackground(new Color(255,216,216));
		jbtn_dap.setForeground(new Color(0,0,0));
		jbtn_exit.setBackground(new Color(234,234,234));
		jbtn_exit.setForeground(new Color(0,0,0));
		jp_east.setLayout(new GridLayout(4,1));
		jp_east.add(jbtn_next);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_exit);
		jf_bbgame.add("Center",jp_center);
		jf_bbgame.add("East",jp_east);
		//////////메뉴바 추가 시작//////////////
		jm_game.add(jmi_next);
		jm_game.add(jmi_clear);
		jm_game.add(jmi_dap);
		jm_game.add(jmi_exit);
		
		//메뉴를 메뉴바에 붙이기
		jmb_bbgame.add(jm_game);
		jmb_bbgame.add(jm_info);
		jf_bbgame.setJMenuBar(jmb_bbgame);
		//////////메뉴바 추가 끝//////////////
		
		
		jf_bbgame.setTitle("야구숫자게임");
		jf_bbgame.setSize(600,450);
		jf_bbgame.setVisible(true);
	}
	
	
	int com[] = new int[3];
	int my[] = new int[3];//my[0]=0 my[1]=0 my[2]=0
	//세자리 숫자를 채번하는 메소드 입니다.
	//새게임 버튼을 누르거나 강제 종료 후 다시 시작할 때 호출됩니다.
	public void ranCom() {
		Random r = new Random();//0.0~
		com[0] = r.nextInt(10);//0.0~10.0
		do {
			com[1] = r.nextInt(10);//0.0~10.0
		}while(com[0]==com[1]);
		do {
			com[2] = r.nextInt(10);//0.0~10.0			
		}while((com[0]==com[2])||(com[1]==com[2]));
	}
	//insert here -  account메소드 구현 /////////////////////////

	
	public static void main(String[] args) {
		
		BaseBallGame bbGame = new BaseBallGame();
		
	}
	
}







