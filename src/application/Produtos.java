package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Produtos extends Application{
	
private static Stage stageProdutos;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("HaitatsuProdutos.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Haitatsu System");
			primaryStage.setScene(scene);
			primaryStage.show();
			setStage(primaryStage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getStage() {
		return stageProdutos;
	}

	public static void setStage(Stage stage) {
		Produtos.stageProdutos = stage;
	}
	
}
