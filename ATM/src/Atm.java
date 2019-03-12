import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.geometry.*;
// This class represents the ATM machine which stores the users data
public class Atm {

	private ObservableList<User> tableContents =FXCollections.observableArrayList(); // save contents of adminTable
	
	
	public ObservableList<User> getTableContents()
	{
		return tableContents;
		
	}
	
	public void setTableContents(ObservableList<User> tableContents)
	{
		this.tableContents =  tableContents;
		
	}


	
	public User searchUser (User user)
	{
		
		int x = 0;
		int i = tableContents.size();
		if(i == 0)
			return null;
		
		
		while(x < i) {
			if(user.getCardNumber().equals(tableContents.get(x).getCardNumber()) && user.getPassword().equals(tableContents.get(x).getPassword()))
				return tableContents.get(x);
		x++;	
		}
		return null;
		
				
		
	}
}
