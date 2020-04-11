package athread.talk3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
//상속은 단일 상속밖에 안되지만 인터페이스는 무제한 사용할 수 있다.
//데이터 dtm => 테이블 => 제이스크롤페인 => (패널) => 프레임
public class WaitRoom extends JPanel implements MouseListener, ActionListener {
	TalkClientVer2 tc = null;
	JPanel jp_first = new JPanel();//대기모드 처리
	String cols[] = {"대화명","위치"};									//테이블을 만들 때 꼭 필요***
	String data[][] = new String[5][2];								//테이블을 만들 때 꼭 필요***
	//테이블 안에 값을 넣으려면 필요
	DefaultTableModel dtm_wait = new DefaultTableModel(data,cols);  //테이블을 만들 때 꼭 필요***
	JTable jtb_wait = new JTable(dtm_wait);							//테이블을 만들 때 꼭 필요***
	JScrollPane jsp_wait = new JScrollPane(jtb_wait);				//테이블을 만들 때 꼭 필요***
	
	JTableHeader jth_wait = jtb_wait.getTableHeader();
	
	JPanel jp_second = new JPanel();//단톡정보 처리
	String cols2[] = {"단톡명","현재인원"};
	String data2[][] = new String[1][2];
	DefaultTableModel dtm_room = new DefaultTableModel(data2,cols2);
	JTable jtb_room = new JTable(dtm_room);
	JScrollPane jsp_room = new JScrollPane(jtb_room);
	JTableHeader jth_room = jtb_room.getTableHeader();
	JPanel jp_second_south = new JPanel();
	JButton jbtn_create = new JButton("단톡만들기");
	JButton jbtn_in = new JButton("입장하기");
	JButton jbtn_out = new JButton("나가기");
	JButton jbtn_exit = new JButton("종료");
	JLabel jlb_banner = new JLabel();
	
	public WaitRoom(TalkClientVer2 tc) {
		this.tc = tc;
		initDisplay();
	}
	
	public void initDisplay() {
		//두 개 이상의 이벤트도 줄 수 있다.
		jbtn_in.addActionListener(this);
		
		jtb_room.addMouseListener(this);
		
		this.setLayout(new GridLayout(1,2));
		
		jth_wait.setBackground(Color.red);
		jth_wait.setForeground(Color.white);
		jtb_wait.setGridColor(Color.red);
		jtb_wait.setSelectionBackground(Color.GRAY);
		//테이블 헤더 위치 변경 꺼두기
		jth_wait.setReorderingAllowed(false);
		jp_first.setBorder(BorderFactory.createBevelBorder(1));
		jp_first.setBackground(Color.pink);
		jp_first.setLayout(new BorderLayout());
		jp_first.add(jsp_wait);
		jp_second.setBackground(Color.cyan);
		
		jp_second.setLayout(new BorderLayout());
		
		jp_second_south.setLayout(new GridLayout(2,2));
		jp_second_south.add(jbtn_create);
		jp_second_south.add(jbtn_in);
		jp_second_south.add(jbtn_out);
		jp_second_south.add(jbtn_exit);
		
		jp_second.add("Center",jsp_room);
		jp_second.add("South",jp_second_south);
		
		jlb_banner.setBorder(BorderFactory.createEtchedBorder());
		jlb_banner.setIcon(new ImageIcon("src\\athread\\room"));
		
		this.add(jp_first);
		this.add(jp_second);
		this.setBackground(Color.green);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==jtb_room) {
			JOptionPane.showMessageDialog(tc, "mousePressed");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//"입장하기"를 눌렀을 때 두 번째 탭으로 이동
		String command = e.getActionCommand();
		if("입장하기".equals(command)) {
			tc.jtp.setSelectedIndex(1);
		}
	}
}