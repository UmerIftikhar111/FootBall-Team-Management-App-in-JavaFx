package fxml;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import application.MainApp;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Player;
import model.Trophy;

public class TrophiesOverviewController implements Initializable{

	@FXML
    public TableView<Trophy> trophyTable;	
	@FXML
    public TableColumn<Trophy, String> tNameCol;
	@FXML
    public TableColumn<Trophy, String> tYearCol;
	@FXML
    public TableColumn<Trophy, String> tTeamCol;
	
	public static String Name;
	
	public void initialize(URL location, ResourceBundle resources) {
		
		populateTrophyTable(Name);
	}
	
	public void populateTrophyTable(String name) {
		
		ObservableList<Trophy> displayer=FXCollections.observableArrayList();
		
		for(int i=0;i<Player.trophyModel.size();i++) {
			if(Player.trophyModel.get(i).getTeam().equals(name)) {
				
				displayer.add(Player.trophyModel.get(i));
			}
		}
		
		tNameCol.setCellValueFactory(
	            new PropertyValueFactory<>("Name"));
		tYearCol.setCellValueFactory(
	            new PropertyValueFactory<>("Year"));
		tTeamCol.setCellValueFactory(
	            new PropertyValueFactory<>("Team"));
		
		trophyTable.setItems(displayer);
	
		
	}
	
	FXMLLoader loader = new FXMLLoader();
	Stage stage;
	public void goBack(ActionEvent event) {
		Name="";
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
