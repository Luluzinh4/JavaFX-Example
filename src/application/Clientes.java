package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Clientes extends Application{
	
	private static Stage stageClientes;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("HaitatsuClientes.fxml"));
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

	public static Stage getStage() {
		return stageClientes;
	}

	public static void setStage(Stage stage) {
		Clientes.stageClientes = stage;
	}

}
