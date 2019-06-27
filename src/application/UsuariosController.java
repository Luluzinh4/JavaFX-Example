package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.stage.Stage;

public class UsuariosController {

    @FXML
    private Button btnCadUsers;

    @FXML
    private Button btnVoltarUsers;

    @FXML
    private Button btnExcUsers;
    
    @FXML
    private Button btnUpdUsers;

    @FXML
    void initCadUser(ActionEvent event) {
//    	CadUsuarios cadUser = new CadUsuarios();
//    	fechaTela();
//    	cadUser.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuCadUsuarios.fxml"));
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
    void initexcUsers(ActionEvent event) {
//    	ExcUsuarios excUser = new ExcUsuarios();
//    	fechaTela();
//    	excUser.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuExcUsuarios.fxml"));
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
    void initUpdUsers(ActionEvent event) {
//    	UpdUsuarios updUser = new UpdUsuarios();
//    	fechaTela();
//    	updUser.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuUpdUsuarios.fxml"));
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
    void voltarConfig(ActionEvent event) {
//    	Config conf = new Config();
//    	fechaTela();
//    	conf.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuConfig.fxml"));
			Scene scene = new Scene(root);
			App.getStage().setTitle("Haitatsu System");
			App.getStage().setScene(scene);
			App.getStage().show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
//    void fechaTela() {
//    	Usuarios.getStage().close();
//    }

}
