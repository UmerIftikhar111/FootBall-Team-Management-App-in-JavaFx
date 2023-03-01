package fxml;


import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;


import application.MainApp;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Player;

public class PlayerController implements Initializable {

	@FXML
    public Label fName;
	@FXML
    public Label lName;
	@FXML
    public Label age;
	@FXML
    public Label team;
	@FXML
    public Label position;
	@FXML
    public Label salary;
	
	@FXML
    public TableView<Player> playerTable;	
	@FXML
    public TableColumn<Player, String> firstNameCol;
	@FXML
    public TableColumn<Player, String> lastNameCol;
	
	public static String name; 
	
	public void initialize(URL location, ResourceBundle resources) {
	
		setPlayerData();
		
		playerTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	ObservableList<Player> selection =  playerTable.getSelectionModel().getSelectedItems();
		    	if(selection.size()>0)
		    	TrophiesOverviewController.Name=selection.get(0).getTeam();
		    	for(int i=0;i<MainApp.playersModel.size();i++) {
		    		if(MainApp.playersModel.get(i).getFirstName().equals(selection.get(0).getFirstName())) {
		    			setItems(i);
		    		}
		    	}	    	
		    }
		});
		
		
		
	}
	
	public void setPlayerData() {
		firstNameCol.setCellValueFactory(
	            new PropertyValueFactory<>("FirstName"));
		lastNameCol.setCellValueFactory(
	            new PropertyValueFactory<>("LastName"));
		
		playerTable.setItems(MainApp.playersModel);
	}

	public void setItems(int i) {
		
		fName.setText(MainApp.playersModel.get(i).getFirstName());
		lName.setText(MainApp.playersModel.get(i).getLastName());
		age.setText(MainApp.playersModel.get(i).getAge());
		team.setText(MainApp.playersModel.get(i).getTeam());
		salary.setText(MainApp.playersModel.get(i).getSalary());
		position.setText(MainApp.playersModel.get(i).getPosition());
		
		
	}
	
	public void showTrophiesDialog(ActionEvent event) {
		MainApp object=new MainApp();
		object.showTrophiesDialog(event);
	}
	
	FXMLLoader loader = new FXMLLoader();
	Stage stage;
	
	public void addNewPlayer(ActionEvent event) {
		try {
			String fxmlDocPath = MainApp.systemPath+"\\src\\fxml\\CreatePlayerDialog.fxml";			
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root = (AnchorPane) loader.load(fxmlStream);
			stage=(Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root,450,600);
			stage.setScene(scene);
			stage.show();
			
			setPlayerData();
			playerTable.refresh();
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
