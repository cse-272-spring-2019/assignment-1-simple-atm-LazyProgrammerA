// JavaFx imports
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

// A program to Simulate ATM machine

// Now main inherits functionality of Application class
public class Main extends Application  { 

	public static void main(String[] args) {
		launch(args); // looks for start method and runs it	

	}
	
	Stage window;
	public void start(Stage primaryStage)
	{
		window = primaryStage;
		window.setTitle("ATM");  // set title of window to ATM
		window.setWidth(600);
		window.setHeight(300);
		AdminTableScene tableScene = new AdminTableScene();
		Atm ATM = new Atm();
		LogInScene.display(window , tableScene , ATM);
		
		
		
		window.show();  // Finally display the window
		
	}

}
