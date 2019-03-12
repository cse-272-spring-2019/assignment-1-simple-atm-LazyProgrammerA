import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ShowBalanceScene {
	
	public static void display(Stage window , Atm ATM  , User currentUser , AdminTableScene tableScene)
	{
		window.setTitle("Balance");
		
		// Grid Pane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//  Label
		Label balanceLabel = new Label("Balance");
		GridPane.setConstraints(balanceLabel , 0 ,0);
		
		// Label
		Label balanceAmountLabel = new Label(Double.toString(currentUser.getCurrentBalance()));
		GridPane.setConstraints(balanceAmountLabel , 1 ,0);
		
		// go Back Button
		Button goBackButton = new Button("Go Back");
		GridPane.setConstraints(goBackButton , 0 ,1);

		// Add actors to Grid Pane
		grid.getChildren().addAll(balanceLabel , balanceAmountLabel ,  goBackButton);
		
		
		// Buttons Functionality
		
		goBackButton.setOnAction(e -> MainMenueScene.display(window, ATM, currentUser, tableScene));
		// Create Scene and show
		Scene scene = new Scene(grid,300,200);
		window.setScene(scene);
		window.show();

		
		
	}
}
