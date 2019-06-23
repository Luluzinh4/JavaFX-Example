package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	private static Stage stageMain;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuMain.fxml"));
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
		return stageMain;
	}

	public static void setStage(Stage stage) {
		Main.stageMain = stage;
	}

}
