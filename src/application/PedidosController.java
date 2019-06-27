package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.stage.Stage;

public class PedidosController {

    @FXML
    private Button btnCadPed;

    @FXML
    private Button btnUpdPed;

    @FXML
    private Button btnVerPed;

    @FXML
    private Button btnExcPed;

    @FXML
    private Button btnVoltarPed;

    @FXML
    void initCadPedido(ActionEvent event) {
//    	CadPedidos cadPed = new CadPedidos();
//    	fecharTela();
//    	cadPed.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuCadPedidos.fxml"));
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
    void initExcPedido(ActionEvent event) {
//    	ExcPedidos excPed = new ExcPedidos();
//    	fecharTela();
//    	excPed.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuExcPedidos.fxml"));
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
    void initUpdPedido(ActionEvent event) {
//    	UpdPedidos updPed = new UpdPedidos();
//    	fecharTela();
//    	updPed.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuUpdPedidos.fxml"));
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
    void visuPedido(ActionEvent event) {
//    	VerPedidos verPed = new VerPedidos();
//    	fecharTela();
//    	verPed.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuVerPedidos.fxml"));
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
//      	Pedidos.getStage().close();
//    }

}