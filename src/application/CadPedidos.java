package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadPedidos extends Application {
	
	private static Stage stageCadPedidos;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuCadPedidos.fxml"));
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
		return stageCadPedidos;
	}

	public static void setStage(Stage stage) {
		CadPedidos.stageCadPedidos = stage;
	}

}
