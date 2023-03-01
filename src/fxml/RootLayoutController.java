package fxml;

import java.io.FileInputStream;


import application.MainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RootLayoutController {

	FXMLLoader loader = new FXMLLoader();
	Stage stage;
	
	
	public void redirect(ActionEvent event) {
		try {
			String fxmlDocPath = MainApp.systemPath+"\\src\\fxml\\PlayerOverview.fxml";
			
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root = (AnchorPane) loader.load(fxmlStream);
			stage=(Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root,800,800);
			stage.setScene(scene);
			stage.show();
			
						
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
}
