package foodList;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FoodView {
	
	JFrame jf_food = new JFrame();
	JPanel jp_north	= new JPanel();
	JButton jbtn_sel = new JButton("조회");
	JButton jbtn_ins = new JButton("입력");
	
	String[] cols = {"번호","이름","점수","설명"};
	String[][] data = new String[0][4];
	
	//이제 dtm에 넣어준면 된다.
	DefaultTableModel dtm_food = new DefaultTableModel(data, cols);
	//dtm은 정보만 가지고 있으니까 이제 양식을 가진 애도 필요한다. 그것이 Jtable
	
	JTable jt_food = new JTable(dtm_food);
	//테이블의 양이 많아질 때를 대비해서 스크롤바를 넣어줄 수 있도록 하자.
	JScrollPane js_food = new JScrollPane(jt_food
										, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
										, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	FoodLogic fLogic = new FoodLogic(this);//***
	
	public void initDisplay() {
		
		jbtn_sel.addActionListener(fLogic);//***
		jbtn_ins.addActionListener(fLogic);//***
		jbtn_save.addActionListener(fLogic);
		
		jp_north.setLayout(new GridLayout(1, 2));//1행 2열
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		
		jf_food.add("North",jp_north);
		jf_food.add("Center", js_food);
		
		jf_food.setSize(400,300);
		jf_food.setVisible(true);
		
	}
	
	JDialog jd_insert = new JDialog();
	
	JPanel jp_insert = new JPanel();
	JButton jbtn_save = new JButton("저장");
	
	
	JPanel 		jp_center 	= new JPanel();
	JLabel 		jl_no		= new JLabel("no");
	JTextField 	jtf_no		= new JTextField();
	JLabel 		jl_name		= new JLabel("name");
	JTextField 	jtf_name 	= new JTextField();
	JLabel 		jl_score	= new JLabel("core");
	JTextField 	jtf_score 	= new JTextField();
	JLabel 		jl_info		= new JLabel("info");
	JTextArea 	jta_info 	= new JTextArea();
	JScrollPane js_info	 	= new JScrollPane(jta_info);
	
	
	public void insertView() {
		jp_insert.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_insert.add(jbtn_save);
		
		jp_center.setLayout(null);
		jl_no.setBounds(10,10,60,30);
		jtf_no.setBounds(80,10,150,30);
		jl_name.setBounds(10, 50, 60, 30);
		jtf_name.setBounds(80, 50, 150, 30);
		jl_score.setBounds(10, 90, 60, 30);
		jtf_score.setBounds(80, 90, 150, 30);
		jl_info.setBounds(10, 130, 60, 30);
		js_info.setBounds(80, 130, 150, 100);
		
		jp_center.add(jl_no);
		jp_center.add(jtf_no);
		jp_center.add(jl_name);
		jp_center.add(jtf_name);
		jp_center.add(jl_score);
		jp_center.add(jtf_score);
		jp_center.add(jl_info);
		jp_center.add(js_info);
		
		jd_insert.setLayout(new BorderLayout());
		jd_insert.add("North",jp_insert);
		jd_insert.add("Center", jp_center);
		
		jd_insert.setSize(400,350);
		jd_insert.setVisible(true);
		
	}
	
	
	public FoodView(){
		initDisplay();
		//insertView();
	}
	
	public static void main(String[] args) {
		FoodView fView = new FoodView();
		
	}
}
	
	
