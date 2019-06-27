package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.stage.Stage;

public class ClientesController {

    @FXML
    private Button btnCadCli;

    @FXML
    private Button btnUpdCli;

    @FXML
    private Button btnVerCli;

    @FXML
    private Button btnExcCli;

    @FXML
    private Button btnVoltarCli;

    @FXML
    void initCadCliente(ActionEvent event) {
//    	CadClientes cadCli = new CadClientes();
//    	fecharTela();
//    	cadCli.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuCadClientes.fxml"));
			Scene scene = new Scene(root);
			App.getStage().setTitle("Haitatsu System");
			App.getStage().setScene(scene);
			App.getStage().show();
			//setStage(primaryStage);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initExcCliente(ActionEvent event) {
//    	ExcClientes excCli = new ExcClientes();
//    	fecharTela();
//    	excCli.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuExcClientes.fxml"));
			Scene scene = new Scene(root);
			App.getStage().setTitle("Haitatsu System");
			App.getStage().setScene(scene);
			App.getStage().show();
			//setStage(primaryStage);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initUpdCliente(ActionEvent event) {
//    	UpdClientes updCli = new UpdClientes();
//    	fecharTela();
//    	updCli.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuUpdClientes.fxml"));
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
    void visuCliente(ActionEvent event) {
//    	VerClientes verCli = new VerClientes();
//    	fecharTela();
//    	verCli.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuVerClientes.fxml"));
			Scene scene = new Scene(root);
			App.getStage().setTitle("Haitatsu System");
			App.getStage().setScene(scene);
			App.getStage().show();
			//setStage(primaryStage);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void voltarHaitatsu(ActionEvent event) {
//    	Main main = new Main();
//    	fecharTela();
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
    
//    void fecharTela() {
//      	Clientes.getStage().close();
//    }
}
