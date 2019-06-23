package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VerClientes extends Application {
	
	private static Stage stageVerClientes;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuVerClientes.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Haitatsu System");
			primaryStage.setScene(scene);
			primaryStage.show();
			setStage(primaryStage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Stage getStage() {
		return stageVerClientes;
	}

	public static void setStage(Stage stage) {
		VerClientes.stageVerClientes = stage;
	}

}
