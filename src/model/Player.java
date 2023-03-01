package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Player {

	SimpleStringProperty  firstName,lastName, age, position, team, shirtNumber, salary;
	
	public Player(String firstName, String lastName, String age, String position, String team, String shirtNumber,
			String salary) {
		super();
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.age = new SimpleStringProperty(age);
		this.position = new SimpleStringProperty(position);
		this.team = new SimpleStringProperty(team);
		this.shirtNumber = new SimpleStringProperty(shirtNumber);
		this.salary = new SimpleStringProperty(salary);
	}

	Player(){
		
	}

	public static ObservableList<Trophy> trophyModel=FXCollections.observableArrayList(
				new Trophy("Champions League","2015","Barcelona"),
				new Trophy("LaLiga","2018","Al-Nassr")
	);
	
	
	
	
	public static ObservableList<Trophy> getTrophyModel() {
		return trophyModel;
	}

	public static void setTrophyModel(ObservableList<Trophy> trophyModel) {
		Player.trophyModel = trophyModel;
	}

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(SimpleStringProperty firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(SimpleStringProperty lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age.get();
	}

	public void setAge(SimpleStringProperty age) {
		this.age = age;
	}

	public String getPosition() {
		return position.get();
	}

	public void setPosition(SimpleStringProperty position) {
		this.position = position;
	}

	public String getTeam() {
		return team.get();
	}

	public void setTeam(SimpleStringProperty team) {
		this.team = team;
	}

	public String getShirtNumber() {
		return shirtNumber.get();
	}

	public void setShirtNumber(SimpleStringProperty shirtNumber) {
		this.shirtNumber = shirtNumber;
	}

	public String getSalary() {
		return salary.get();
	}

	public void setSalary(SimpleStringProperty salary) {
		this.salary = salary;
	}
	
	
}
