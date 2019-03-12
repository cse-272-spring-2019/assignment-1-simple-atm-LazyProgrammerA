import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WithdrawScene {
	
	public static void display(Stage window , Atm ATM  , User currentUser , AdminTableScene tableScene)
	{
		window.setTitle("ATM Withdraw");
		
		// Grid Pane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//  Label
		Label withdrawLabel = new Label("Withdraw Amount");
		GridPane.setConstraints(withdrawLabel , 0 ,0);
		
		// Withdraw Input
		TextField withdrawInput = new TextField();
		withdrawInput.setPromptText("e.g.: 123.5");
		GridPane.setConstraints(withdrawInput , 1 ,0);
		
		// Withdraw Button
		Button withdrawButton = new Button("Withdraw");
		GridPane.setConstraints(withdrawButton , 0 ,1);

				
		// go Back Button
		Button goBackButton = new Button("Go Back");
		GridPane.setConstraints(goBackButton , 1 ,1);

		// Add actors to Grid Pane
		grid.getChildren().addAll(withdrawLabel , withdrawInput ,  goBackButton , withdrawButton);
		
		
		// Buttons Functionality
		
		goBackButton.setOnAction(e -> MainMenueScene.display(window, ATM, currentUser, tableScene));
		
		withdrawButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent event)
			{
				int IsSuccess = currentUser.withdraw(Double.parseDouble(withdrawInput.getText()));
				if(IsSuccess == 1)
					AlertBox.display("Success", "Transcation made Successfully");
				else if(IsSuccess == 0) AlertBox.display("Error", "Insufficient Funds");
				else AlertBox.display("Error", "Enter a non-zero amount to Withdraw");
			}});
		
		
		
		// Create Scene and show
		Scene scene = new Scene(grid,300,200);
		window.setScene(scene);
		window.show();

		
		
	}
}
