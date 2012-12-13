package Book;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CatalogAddPanel extends JPanel{
	private BookUIController bookUIController;
	
	private JLabel newKindLabel;
	private JTextField newKindField;
	
	public CatalogAddPanel(BookUIController bookUIController){
		this.bookUIController = bookUIController;
	}
	
	public BookUIController getBookUIController(){
		return bookUIController;
	}
	
	public void init(){
		setLayout(null);
		setSize(425, 250);
		
		newKindLabel = new JLabel("请设置图书类别");
		newKindLabel.setSize(140, 50);
	}
}
