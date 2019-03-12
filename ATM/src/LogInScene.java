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

// this is the logInScene 
public class LogInScene {

	public static void display (Stage window , AdminTableScene tableScene ,  Atm ATM) // void so no need to make instance to call method
	{

		window.setTitle("ATM Log-in");

		
		// Grid Pane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		// Card Number Label
		Label nameLabel = new Label("Card Number");
		GridPane.setConstraints(nameLabel , 0 ,0);

		// Card Number Input
		TextField nameInput = new TextField();
		nameInput.setPromptText("e.g.: 0000 for admin");
		GridPane.setConstraints(nameInput , 1 ,0);
		
		// Password Label
		Label passLabel = new Label("Password");
		GridPane.setConstraints(passLabel , 0 ,1);
		
		// Password Input
		TextField passInput = new TextField();
		passInput.setPromptText("e.g.: 0000 for admin");
		GridPane.setConstraints(passInput , 1 ,1);
				
		// Log-In Button
		Button logInButton = new Button("Enter");
		GridPane.setConstraints(logInButton , 1 ,2);
		
		
		// Add actors to Grid Pane
		grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,logInButton);
		
		// Create Scene and show
		Scene scene = new Scene(grid,300,200);
		window.setScene(scene);
		window.show();
		
		
		// Log-in Button Functionality
		logInButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent event)
			{
				if(nameInput.getText().equals("0000") && passInput.getText().equals("0000"))
					tableScene.display(window , ATM);
				
				else if (ATM.searchUser(new User(nameInput.getText() , passInput.getText() )) != null)
					MainMenueScene.display(window, ATM , ATM.searchUser(new User(nameInput.getText() , passInput.getText() )) , tableScene);
				
				else AlertBox.display("Error", "Credit Card Number or Password are Incorrect");
			}});
		
		
	}
}


