package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VerProdutos extends Application{
	
	private static Stage stageVerProdutos;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuVerProdutos.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		Scene scene = new Scene(root);
		primaryStage.setTitle("Haitatsu System");
		primaryStage.setScene(scene);
		primaryStage.show();
		setStage(primaryStage);
	}

	public static Stage getStage() {
		return stageVerProdutos;
	}

	public static void setStage(Stage stage) {
		VerProdutos.stageVerProdutos = stage;
	}

}
