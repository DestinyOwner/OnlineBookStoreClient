package Book;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;

@SuppressWarnings("serial")
public class DirectoryComBox extends JComboBox<DirectoryPO>{
	public DirectoryComBox(){
		super();
		this.setRenderer(new MyCellRenderer());
	}
	
	
	public int getDirectoryID(String name){
		for(int i = 0; i < this.getItemCount(); i ++){
			if(name.equals(((DirectoryPO)this.getItemAt(i)).getName())){
				return ((DirectoryPO)this.getItemAt(i)).getID();
			}
			i ++;
		}
		return 0;
	}
}

class DirectoryItem{
	private String name;
	public DirectoryItem(DirectoryPO directoryPO){
		this.name = directoryPO.getName();
	}
	
	public String getName(){
		return name;
	}
}

@SuppressWarnings("serial")
class MyCellRenderer extends DefaultListCellRenderer{

	@SuppressWarnings("rawtypes")
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		this.setText(((DirectoryPO)value).getName());
		return this;
	}
	
}
