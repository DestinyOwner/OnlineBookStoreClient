package Book;

import java.awt.Font;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ClientRunner.Agent;
import RMI.ResultMessage;

@SuppressWarnings("serial")
public class CatalogDelPanel extends JPanel{
	private BookUIController bookUIController;
	
	private JLabel delLabel;
	private DirectoryComBox catalogComBox;
	
	public CatalogDelPanel(BookUIController bookUIController){
		this.bookUIController = bookUIController;
	}
	
	public BookUIController getBookUIController(){
		return bookUIController;
	}
	
	public void init(){
		setLayout(null);
		setSize(425, 100);
		
		delLabel = new JLabel("选择所要删除的图书类别:");
		delLabel.setSize(250, 50);
		delLabel.setFont(new Font("楷体_gb2312", Font.PLAIN, 22));
		delLabel.setLocation(50, 10);
		
		catalogComBox = new DirectoryComBox();
		try{
			ResultMessage resultMessage = Agent.bookService.getAllDirectories();
			@SuppressWarnings("unchecked")
			ArrayList<DirectoryPO> list = resultMessage.getResultSet();
			if(list != null){
				for(int i = 0; i < list.size(); i ++){
					catalogComBox.addItem(list.get(i));
				}
			}
		}catch(RemoteException re){
			re.printStackTrace();
		}
		catalogComBox.setSize(100, 40);
		catalogComBox.setFont(new Font("楷体_gb2312", Font.PLAIN, 23));
		catalogComBox.setFocusable(false);
		catalogComBox.setLocation(310, 15);
		
		
		add(delLabel);
		add(catalogComBox);
	}
	
	public int getDirectoryID(){
		return ((DirectoryPO)catalogComBox.getSelectedItem()).getID();
	}
}
