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

// This Scene Displays admin Table
public class AdminTableScene {
	
	TableView<User> table;
	TextField cardNumberInputTable, passwordInputTable ;
	Atm ATM;
	Stage window;
	public void  display (Stage window , Atm ATM)
	{
		this.window = window;
		window.setTitle("ATM Admin Control");
		window.setHeight(600);
		
		this.ATM =ATM;
		// Table
		// Card Number Column
		TableColumn<User , String> cardNumberColumn = new TableColumn<>("Card Number");
		cardNumberColumn.setMinWidth(200);
		cardNumberColumn.setCellValueFactory(new PropertyValueFactory<>("cardNumber"));
		
		// Password Column
		TableColumn<User , String> passwordColumn = new TableColumn<>("Password");
		passwordColumn.setMinWidth(200);
		passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
		
		
		// table it self
		
		table = new TableView();
		table.setItems(getadminTable());;
		table.getColumns().addAll(cardNumberColumn,passwordColumn);
		
				
		
		// Add or delete Functionality
		
		// Card Number Input
		cardNumberInputTable = new TextField();
		cardNumberInputTable.setPromptText("Card Number e.g.: 2222");
		cardNumberInputTable.setMinWidth(100);
		
		// Password Input
		passwordInputTable = new TextField();
		passwordInputTable.setPromptText("Password e.g.: 2222");
		
		
		// Buttons and Hbox
		Button addButton = new Button("Add");
		Button deleteButton = new Button("Delete");
		Button goBackButton = new Button("Go Back");
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(cardNumberInputTable,passwordInputTable,addButton,deleteButton , goBackButton);
		
		// Buttons set Action
		addButton.setOnAction(e -> addButtonClicked());
		deleteButton.setOnAction(e -> deleteButtonClicked());
		goBackButton.setOnAction(e -> goBackButtonClicked());
		
		
		// add to scene
		VBox vbox = new VBox();
		vbox.getChildren().addAll(table,hbox);
		Scene tableScene = new Scene(vbox,200,200);
		window.setScene(tableScene);
		
		
		
		
		
	}
	
	
	// Add Buttons functionality
	public void addButtonClicked()
	{
		User users = new User();
		users.setCardNumber(cardNumberInputTable.getText());
		users.setPassword(passwordInputTable.getText());
		ATM.setTableContents(table.getItems());
		
		if(cardNumberInputTable.getText().equals("") || cardNumberInputTable.getText().contains(" ")  || passwordInputTable.getText().equals("") || passwordInputTable.getText().contains(" ") )
			{AlertBox.display("Error", "Entered Invalid Data");
			return;}
		table.getItems().add(users);
		cardNumberInputTable.clear();
		passwordInputTable.clear();
		
		
		
	}
	
	// Delete Buttons functionality
	public void  deleteButtonClicked()
	{
		ObservableList<User> userSelected , allUsers;
		allUsers = table.getItems();
		userSelected = table.getSelectionModel().getSelectedItems();
		userSelected.forEach(allUsers::remove);
		ATM.setTableContents(table.getItems());
		
		

		
		
	}
	
	// Go Back Button functionality
	public void goBackButtonClicked()
	{
		LogInScene.display(window, this,ATM);
	}
	
	
	
	public ObservableList<User> getadminTable()
	{
		
		return ATM.getTableContents();
		
	}
	
	
	
		


}
