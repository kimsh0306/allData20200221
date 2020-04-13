package book.chap05;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JButtonTest {

	public static void main(String[] args) {
		
	
		JPanel jp_north = new JPanel();
		
		TelBook tb = new TelBook();
		TelBook b_tb[]= new TelBook[4];
		
		GridLayout glay = new GridLayout(1,4);
		String jbtn_label[] = {"조회","입력","수정","삭제"};
		JButton jbtn_sel = null;
		JButton jbtn_ins = null;
		JButton jbtn_upd = null;
		JButton jbtn_del = null;
		
		tb.jbtn_sel=new JButton("조회");
		tb.jbtn_ins=new JButton("입력");
		tb.jbtn_upd=new JButton("수정");
		tb.jbtn_del=new JButton("삭제");
		
		b_tb[0]=tb;
		tb=new TelBook();
		
		tb.jbtn_sel=new JButton("새로운 조회1");
		tb.jbtn_ins=new JButton("새로운 입력1");
		tb.jbtn_upd=new JButton("새로운 수정1");
		tb.jbtn_del=new JButton("새로운 삭제1");
		b_tb[1]=tb;
		tb=new TelBook();
		
		tb.jbtn_sel=new JButton("새로운 조회2");
		tb.jbtn_ins=new JButton("새로운 입력2");
		tb.jbtn_upd=new JButton("새로운 수정2");
		tb.jbtn_del=new JButton("새로운 삭제2");
		b_tb[2]=tb;
		tb=new TelBook();
		
		
		tb.jbtn_sel=new JButton("새로운 조회3");
		tb.jbtn_ins=new JButton("새로운 입력3");
		tb.jbtn_upd=new JButton("새로운 수정3");
		tb.jbtn_del=new JButton("새로운 삭제3");
		b_tb[3]=tb;
		tb=new TelBook();
		
		System.out.println(b_tb[0]);
		System.out.println(b_tb[1]);
		System.out.println(b_tb[2]);
		System.out.println(b_tb[3]);
		
		
		JFrame jf_tel = new JFrame();
		//속지의 레이아웃을 GridLayout 1,4 로우 한개 컬럼 4개로 n분할
		
		
		jf_tel.setSize(400, 600);
		//jf_tel.setSize(400, 600);
		jf_tel.setTitle("테스트");  //프로그램 타이틀

		
		jp_north.setLayout(glay);
		jp_north.add(b_tb[0].jbtn_sel);
		jp_north.add(b_tb[0].jbtn_ins);
		jp_north.add(b_tb[1].jbtn_upd);
		jp_north.add(b_tb[1].jbtn_del);
		
		
		jf_tel.add("North",jp_north);
		jf_tel.setVisible(true);    //api를 보면서 파라미터값을 제대로 넣을줄 알아야함
		
		
		
		
		
		
		
	}

}
