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
public class TransactionHistoryScene {
	
	private TableView<User> table;
	private Atm ATM;
	private Stage window;
	private User currentUser;
	private int index =0;
	public void  display (Stage window , Atm ATM  , User currentUser , AdminTableScene tableScene)
	{
window.setTitle("ATM Log-in");

		
		// Grid Pane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		
		// Transaction Label
		Label transactionTextLabel = new Label("Transaction Done");
		GridPane.setConstraints(transactionTextLabel , 0 ,0);
					
		// Transaction Label
		Label transactionLabel = new Label();
//		if(currentUser.getTransactionHistory()[0] >= 0)
//			transactionLabel.setText("Deposit");
//		else transactionLabel.setText("Withdraw");
		double temp = currentUser.getTransactionHistory()[index];
		if(currentUser.gettransactionNumber() == 0)
			transactionLabel.setText("None");
		else if(temp == 0)
			transactionLabel.setText("Balance Inquiery");
		else if(temp > 0)
			transactionLabel.setText("Deposit");
		else transactionLabel.setText("Withdraw");
			GridPane.setConstraints(transactionLabel , 1 ,0);
		
			// Transaction change Label
			Label transactionChangeLabel = new Label("Change In Balance");
			GridPane.setConstraints(transactionChangeLabel , 2 ,0);
		// Transaction Label
			
		Label transactionAmountLabel = new Label();
		
		if(currentUser.gettransactionNumber() == 0)
			transactionAmountLabel.setText("None");
		else transactionAmountLabel.setText((String.valueOf(currentUser.getTransactionHistory()[0])));
		GridPane.setConstraints(transactionAmountLabel , 3 ,0);
		
		// Balance Text Label
				Label balanceTextLabel = new Label("");
				if(currentUser.gettransactionNumber() > 0)
					balanceTextLabel.setText("Balance After Transaction");
				
				GridPane.setConstraints(balanceTextLabel , 0 ,1);
							
		// Balance Amount Label
				Label balanceAmountLabel = new Label("");
				if(currentUser.gettransactionNumber() > 0)
					balanceAmountLabel.setText(String.valueOf(currentUser.getCurrentBalance()));;
				GridPane.setConstraints(balanceAmountLabel , 1 ,1);
		
		
		// Go Back Button
		Button goBackButton = new Button("Back");
		GridPane.setConstraints(goBackButton , 0 ,2);
				
		// previous Button
		Button prevButton = new Button("Previous");
		GridPane.setConstraints(prevButton , 1 ,2);
						
						

		// Next Button
		Button nextButton = new Button("Next");
		nextButton.setDisable(true);
		GridPane.setConstraints(nextButton , 2 ,2);
		
		
		// Add actors to Grid Pane
		grid.getChildren().addAll(transactionChangeLabel , transactionTextLabel , transactionLabel , transactionAmountLabel,balanceTextLabel , balanceAmountLabel , goBackButton,prevButton , nextButton);
		
		// Create Scene and show
		Scene scene = new Scene(grid,300,200);
		window.setScene(scene);
		window.show();
		
		

		

		// Buttons Functionality
		nextButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent event)
			{
				if(index == 0 ) 
					return;
				if(index == 1)
					nextButton.setDisable(true);
				
				prevButton.setDisable(false);
				index--;
				double temp = currentUser.getTransactionHistory()[index];
				if(currentUser.gettransactionNumber() < index+1)
					{
					transactionLabel.setText("None");
					transactionAmountLabel.setText("None");
					balanceTextLabel.setText("");
					balanceAmountLabel.setText("");
					return;
					}
				balanceTextLabel.setText("Balance After Transaction");
				 if(temp == 0)
					transactionLabel.setText("Balance Inquiery");
				else if(temp > 0)
					transactionLabel.setText("Deposit");
				else transactionLabel.setText("Withdraw");
				balanceAmountLabel.setText(String.valueOf(currentUser.getBalanceHistory()[index]));
				transactionAmountLabel.setText(String.valueOf(currentUser.getTransactionHistory()[index]));
				}});
		
		// prev Button Functionality
		prevButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent event)
			{
			if(index == 5 ) 
				return;
			if(index == 4)
				prevButton.setDisable(true);
				
			nextButton.setDisable(false);
			
			index++;
			double temp = currentUser.getTransactionHistory()[index];
			if(currentUser.gettransactionNumber() < index+1)
			{
			transactionLabel.setText("None");
			transactionAmountLabel.setText("None");
			balanceTextLabel.setText("");
			balanceAmountLabel.setText("");
			return;
			}
			balanceTextLabel.setText("Balance After Transaction");
			 if(temp == 0)
				transactionLabel.setText("Balance Inquiery");
			else if(temp > 0)
				transactionLabel.setText("Deposit");
			else transactionLabel.setText("Withdraw");
			balanceAmountLabel.setText(String.valueOf(currentUser.getBalanceHistory()[index]));
			
			transactionAmountLabel.setText(String.valueOf(currentUser.getTransactionHistory()[index]));
				}});
		
		goBackButton.setOnAction(e -> MainMenueScene.display(window, ATM, currentUser, tableScene));
		
		
	
	}
	
	
	
		


}
