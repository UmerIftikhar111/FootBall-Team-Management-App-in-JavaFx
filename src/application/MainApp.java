package application;

import java.io.FileInputStream;

import fxml.PlayerController;
import fxml.TrophiesOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Player;

public class MainApp extends Application{

	public static String systemPath = "C:\\Users\\Dell\\Documents\\Eclipse-Projects\\FootballApp";
	
	FXMLLoader loader = new FXMLLoader();
	public static Stage stage;
	
	public static ObservableList<Player> playersModel;
	
	public static void initialize(){
		playersModel=FXCollections.observableArrayList(
				new Player("Lionel","Messi","35","CF","Barcelona","10","10000"),
				new Player("Christiano","Ronaldo","40","CF","Al-Nassr","7","10000")
	    );
	}
	
	public ObservableList<Player> getPlayersData() {
		return playersModel;
	}
	
    public static void main(String[] args) {
    	initialize();
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
    	try {
			String fxmlDocPath = "C:\\Users\\Dell\\Documents\\Eclipse-Projects\\FootballApp\\src\\fxml\\RootLayout.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root = (AnchorPane) loader.load(fxmlStream);
			Scene scene = new Scene(root,700,700);
			stage.setScene(scene);			
			stage.show();
			
						
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    
    public void showTrophiesDialog(ActionEvent event) {
    	
    	try {
			String fxmlDocPath = systemPath+"\\src\\fxml\\TrophyDialog.fxml";
			
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root = (AnchorPane) loader.load(fxmlStream);
			stage=(Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root,500,470);
			stage.setScene(scene);
			stage.show();
			
						
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
}
