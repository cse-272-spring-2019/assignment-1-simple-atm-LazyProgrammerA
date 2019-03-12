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


public class AlertBox {
	public static void display (String title , String message)
	{
		Stage window = new Stage();
		window.setWidth(400);
		window.setHeight(150);
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle(title);
		
		window.setMinWidth(250);
		
		Label label = new Label();
		
		label.setText(message);
		
		Button closeButton = new Button("Close");
		
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		
		layout.getChildren().addAll(label , closeButton);
		
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		
		window.showAndWait();
		
		
		
		
		
	}

}
