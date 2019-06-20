package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UpdProdutos extends Application{

	private static Stage stageUpdProdutos;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("HaitatsuVerProdutos.fxml"));
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
		return stageUpdProdutos;
	}

	public static void setStage(Stage stage) {
		UpdProdutos.stageUpdProdutos = stage;
	}

}
