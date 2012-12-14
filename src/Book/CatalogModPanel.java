package Book;

import java.awt.Font;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ClientRunner.Agent;
import RMI.ResultMessage;

@SuppressWarnings("serial")
public class CatalogModPanel extends JPanel{
	private BookUIController bookUIController;
	
	private JLabel preLabel;
	private JLabel postLabel;
	
	private DirectoryComBox catalogComBox;
	private JTextField postCatalog;
	
	public CatalogModPanel(BookUIController bookUIController){
		this.bookUIController = bookUIController;
	}
	
	public BookUIController getBookUIController(){
		return bookUIController;
	}
	
	public void init(){
		setLayout(null);
		setSize(425, 100);
		
		preLabel = new JLabel("选择所要修改的图书类别:");
		preLabel.setSize(250, 30);
		preLabel.setFont(new Font("楷体_gb2312", Font.PLAIN, 20));
		preLabel.setLocation(50, 10);
		
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
		catalogComBox.setSize(100, 30);
		catalogComBox.setFont(new Font("楷体_gb2312", Font.PLAIN, 20));
		catalogComBox.setFocusable(false);
		catalogComBox.setLocation(310, 10);
		
		postLabel = new JLabel("输入修改后的类别名:");
		postLabel.setSize(250, 30);
		postLabel.setFont(new Font("楷体_gb2312", Font.PLAIN, 20));
		postLabel.setLocation(50, 50);
		
		postCatalog = new JTextField();
		postCatalog.setSize(100, 30);
		postCatalog.setFont(new Font("楷体_gb2312", Font.PLAIN, 20));
		postCatalog.setLocation(310, 50);
		
		add(preLabel);
		add(catalogComBox);
		add(postLabel);
		add(postCatalog);
	}
	
	public DirectoryPO getDirectoryPO(){
		return new DirectoryPO(((DirectoryPO)catalogComBox.getSelectedItem()).getID(), postCatalog.getText().trim());
	}
}
