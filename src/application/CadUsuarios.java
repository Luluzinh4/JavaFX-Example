package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadUsuarios extends Application {
	
	private static Stage stageCauUsuarios;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuCadUsuarios.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Haitatsu System");
			primaryStage.setScene(scene);
			primaryStage.show();
			setStage(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public static Stage getStage() {
		return stageCauUsuarios;
	}

	public static void setStage(Stage stage) {
		CadUsuarios.stageCauUsuarios = stage;
	}

}
