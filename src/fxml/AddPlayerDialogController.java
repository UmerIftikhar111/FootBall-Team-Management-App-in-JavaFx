package fxml;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import application.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Player;

public class AddPlayerDialogController implements Initializable{

	@FXML
    public TextField fName;	
	@FXML
    public TextField lName;	
	@FXML
    public TextField age;	
	@FXML
    public TextField position;	
	@FXML
    public TextField shirt;	
	@FXML
    public TextField salary;	
	@FXML
    public TextField team;
	
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void addPlayer() {
		
		Player newPlayer=new Player(fName.getText(),lName.getText(),age.getText(),position.getText(),team.getText(),shirt.getText(),salary.getText());
		MainApp.playersModel.add(newPlayer);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("");
		alert.setContentText("Operation Successfull");
		alert.showAndWait();
		
	}
	
	FXMLLoader loader = new FXMLLoader();
	Stage stage;
	public void goToBackScreen(ActionEvent event) {
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
