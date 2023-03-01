module FootballApp {
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
	opens model to javafx.graphics, javafx.fxml, javafx.base;
	opens fxml to javafx.graphics, javafx.fxml, javafx.base;
}
