package Book;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ModifyBookPanel extends JPanel{
	private BookUIController bookUIController;
	
	private JLabel modifyBookISBNLabel;
	
	private JTextField modifyBookISBNField;
	
	public ModifyBookPanel(){
		init();
	}
	
	public ModifyBookPanel(BookUIController bookUIController){
		this.bookUIController = bookUIController;
		init();
	}
	
	public void init(){
		setSize(282, 70);
		setLayout(null);
		
		modifyBookISBNLabel = new JLabel("输入所要修改的图书的ISBN:");
		modifyBookISBNLabel.setSize(280, 30);
		modifyBookISBNLabel.setFont(new Font("楷体_gb2312", Font.PLAIN, 20));
		modifyBookISBNLabel.setLocation(0, 0);
		
		modifyBookISBNField = new JTextField();
		modifyBookISBNField.setSize(180, 30);
		modifyBookISBNField.setFont(new Font("楷体_gb2312", Font.PLAIN, 20));
		modifyBookISBNField.setLocation(5, 35);
		
		add(modifyBookISBNLabel);
		add(modifyBookISBNField);
	}
	
	public BookUIController getBookUIController(){
		return bookUIController;
	}
	
	public void clear(){
		modifyBookISBNField.setText("");
	}
}
