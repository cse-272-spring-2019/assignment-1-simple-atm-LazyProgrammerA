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

public class MainMenueScene {
	
	public static void display(Stage window , Atm ATM  , User currentUser , AdminTableScene tableScene) 
	{
		window.setTitle("ATM Main Menue");
		
		// Grid Pane
				GridPane grid = new GridPane();
				grid.setPadding(new Insets(10,10,10,10));
				grid.setVgap(8);
				grid.setHgap(10);
				
				//  Get Balance Button
				Button getBalanceButton = new Button("Balance Inquiry");
				GridPane.setConstraints(getBalanceButton , 0 ,0);
				
				//  History of Tansactions Button
				Button historyButton = new Button("Transactions History");
				GridPane.setConstraints(historyButton , 1 ,0);

				
				// Deposit Button
				Button depositButton = new Button("Deposit");
				GridPane.setConstraints(depositButton , 0 ,1);
				
				// withdraw Button
				Button withdrawButton = new Button("Withdraw");
				GridPane.setConstraints(withdrawButton , 1 ,1);
				
				// go Back Button
				Button goBackButton = new Button("Go Back");
				GridPane.setConstraints(goBackButton , 1 ,2);
		
				// Add actors to Grid Pane
				grid.getChildren().addAll(getBalanceButton , historyButton , depositButton , withdrawButton , goBackButton);
				
				
				// Buttons Functionality
				
				getBalanceButton.setOnAction(new EventHandler<ActionEvent>(){
					public void handle (ActionEvent event)
					{
						currentUser.balanceInquire();
						ShowBalanceScene.display( window , ATM  ,currentUser , tableScene);
					}});
				
				
				depositButton.setOnAction(new EventHandler<ActionEvent>(){
					public void handle (ActionEvent event)
					{
						DepositScene.display( window , ATM  ,currentUser , tableScene);
					}});
				
				withdrawButton.setOnAction(new EventHandler<ActionEvent>(){
					public void handle (ActionEvent event)
					{
						WithdrawScene.display( window , ATM  ,currentUser , tableScene);
					}});
				
				historyButton.setOnAction(new EventHandler<ActionEvent>(){
					public void handle (ActionEvent event)
					{
						TransactionHistoryScene table = new TransactionHistoryScene();
						table.display( window , ATM  ,currentUser , tableScene);
					}});
				
				
				goBackButton.setOnAction(e -> LogInScene.display(window, tableScene, ATM));
				// Create Scene and show
				Scene scene = new Scene(grid,300,200);
				window.setScene(scene);
				window.show();

				
	}
	

}
