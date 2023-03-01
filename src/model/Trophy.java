package model;

import javafx.beans.property.SimpleStringProperty;

public class Trophy {

	
	
	SimpleStringProperty name,year,team;

	public Trophy(String name, String year, String team) {
		super();
		this.name = new SimpleStringProperty(name);
		this.year = new SimpleStringProperty(year);
		this.team = new SimpleStringProperty(team);
				
	}

	public String getName() {
		return name.get();
	}

	public void setName(SimpleStringProperty name) {
		this.name = name;
	}

	public String getYear() {
		return year.get();
	}

	public void setYear(SimpleStringProperty year) {
		this.year = year;
	}

	public String getTeam() {
		return team.get();
	}

	public void setTeam(SimpleStringProperty team) {
		this.team = team;
	}
	
	
	
	
	
	
}
