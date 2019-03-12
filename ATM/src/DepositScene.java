import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DepositScene {
	
	public static void display(Stage window , Atm ATM  , User currentUser , AdminTableScene tableScene)
	{
		window.setTitle("ATM Deposit");
		
		// Grid Pane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//  Label
		Label depositLabel = new Label("Deposit Amount");
		GridPane.setConstraints(depositLabel , 0 ,0);
		
		// Deposit Input
		TextField depositInput = new TextField();
		depositInput.setPromptText("e.g.: 123.5");
		GridPane.setConstraints(depositInput , 1 ,0);
		
		// Deposit Button
		Button depositButton = new Button("Deposit");
		GridPane.setConstraints(depositButton , 0 ,1);

				
		// go Back Button
		Button goBackButton = new Button("Go Back");
		GridPane.setConstraints(goBackButton , 1 ,1);

		// Add actors to Grid Pane
		grid.getChildren().addAll(depositLabel , depositInput ,  goBackButton , depositButton);
		
		
		// Buttons Functionality
		
		goBackButton.setOnAction(e -> MainMenueScene.display(window, ATM, currentUser, tableScene));
		
		depositButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent event)
			{
				int isSuccess = currentUser.deposit(Double.parseDouble(depositInput.getText()));
				if(isSuccess == 1)
					AlertBox.display("Success", "Transcation made Successfully");
				else AlertBox.display("Error", "Enter a non-zero amount to Deposit");
			}});
		
		
		
		// Create Scene and show
		Scene scene = new Scene(grid,300,200);
		window.setScene(scene);
		window.show();

		
		
	}
}
