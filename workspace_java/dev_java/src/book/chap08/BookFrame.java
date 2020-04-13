package book.chap08;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookFrame extends JFrame{					//JFrame을 상속받음, JFrame이 아빠.
	String cols[] = {"도서명", "저자"};
	String data[][] = new String[0][2];
	DefaultTableModel dtm_book = new DefaultTableModel(data,cols);
	JTable jtb_book = new JTable(dtm_book);				//
	JScrollPane jsp_book = new JScrollPane(jtb_book);	//
	
	public BookFrame() {
		ArrayList<Book1> library = new ArrayList<>();
		//두 번째 칸에 두 번째 책 정보를 넣어 보자.
		Book1 b1 = new Book1();
		b1.b_title = "태백산맥";
		b1.b_author = "조정래";		
		library.add(b1);
		
		b1 = new Book1();								//같은 걸 쓰고 싶다. Book1을 지웠다.
		b1.b_title = "토지";
		b1.b_author = "박경리";		
		library.add(b1); 								//반드시 해줘야 한다.
		System.out.println("size :"+library.size());	//책 두 권 => size는 2가 출력.
		
		Vector<String> v = new Vector<>();
		v.add(library.get(0).b_title);
		v.add(library.get(0).b_author);
		dtm_book.addRow(v);
		
		v = new Vector<>();								//Vector<String>를 지웠다.
		v.add(library.get(1).b_title);					//get(1) ()에 숫자를 쓸 수 있는가.
		v.add(library.get(1).b_author);
		
		dtm_book.addRow(v);								//addRow 순서대로 넣어준다.
		this.add("Center", jsp_book);					//this 자기 자신의 클래스 주소값
		this.setSize(600, 300);							//상속받은 JFrame의 메소드(add,setSize,setVisible)를 사용했다.
		this.setVisible(true);							//
		
	}
	
	public static void main(String[] args) {
		new BookFrame();
	}

}
