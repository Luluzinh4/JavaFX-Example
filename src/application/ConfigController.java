package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.stage.Stage;

public class ConfigController {

	@FXML
    private Button btnUsers;

    @FXML
    private Button btnVoltarConfig;

    @FXML
    private Button btnLogout;

    @FXML
    void verUsuarios(ActionEvent event) {
//    	Usuarios user = new Usuarios();
//    	closeTela();
//    	user.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuUsuarios.fxml"));
			Scene scene = new Scene(root);
			App.getStage().setTitle("Haitatsu System");
			App.getStage().setScene(scene);
			App.getStage().show();
			//setStage(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void logout(ActionEvent event) {
//    	App login = new App();
//    	closeTela();
//    	login.start(new Stage());
    	
    	try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuLogin.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			App.getStage().setTitle("Haitatsu System");
			App.getStage().setScene(scene);
			App.getStage().show();
			//setStage(primaryStage);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void voltarHaitatsu(ActionEvent event) {
//    	Main main = new Main();
//    	closeTela();
//    	main.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuMain.fxml"));
			Scene scene = new Scene(root);
			App.getStage().setTitle("Haitatsu System");
			App.getStage().setScene(scene);
			App.getStage().show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
//    void closeTela() {
//    	Config.getStage().close();
//    }

}
