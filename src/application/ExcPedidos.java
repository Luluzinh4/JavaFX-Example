package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExcPedidos extends Application {
	
	private static Stage stageExcPedidos;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuExcPedidos.fxml"));
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
		return stageExcPedidos;
	}

	public static void setStage(Stage stage) {
		ExcPedidos.stageExcPedidos = stage;
	}

}
