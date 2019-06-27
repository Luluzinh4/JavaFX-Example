package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
//import javafx.stage.Stage;

public class MainController {

	@FXML
    private Button btnClientes;

    @FXML
    private Button btnPedidos;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnConfig;

    @FXML
    private Text close;

    @FXML
    void userConfig(ActionEvent event) {
//    	Config config = new Config();
//    	closeTela();
//    	config.start(new Stage());
    	
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

    @FXML
    void verClientes(ActionEvent event) {
//    	Clientes cli = new Clientes();
//    	closeTela();
//    	try {
//			cli.start(new Stage());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuClientes.fxml"));
			Scene scene = new Scene(root);
			App.getStage().setTitle("Haitatsu System");
			App.getStage().setScene(scene);
			App.getStage().show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
    }

    @FXML
    void verPedidos(ActionEvent event) {
//    	Pedidos ped = new Pedidos();
//    	closeTela();
//    	try {
//			ped.start(new Stage());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuPedidos.fxml"));
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
    void verProdutos(ActionEvent event) {
//    	Produtos prod = new Produtos();
//    	closeTela();
//    	try {
//			prod.start(new Stage());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuProdutos.fxml"));
			Scene scene = new Scene(root);
			App.getStage().setTitle("Haitatsu System");
			App.getStage().setScene(scene);
			App.getStage().show();
			//setStage(primaryStage);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
//    void closeTela() {
//    	Main.getStage().close();
//    }
        
}
