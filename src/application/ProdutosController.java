package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.stage.Stage;

public class ProdutosController {

    @FXML
    private Button btnCadProd;

    @FXML
    private Button btnUpdProd;

    @FXML
    private Button btnVerProd;

    @FXML
    private Button btnExcProd;

    @FXML
    private Button btnVoltarProd;

    @FXML
    void initCadProduto(ActionEvent event) {
//    	CadProdutos cadProd = new CadProdutos();
//    	fecharTela();
//    	cadProd.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuCadProdutos.fxml"));
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
    void initExcProduto(ActionEvent event) {
//    	ExcProdutos excProd = new ExcProdutos();
//    	fecharTela();
//    	excProd.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuExcProdutos.fxml"));
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
    void initUpdProduto(ActionEvent event) {
//    	UpdProdutos updProd = new UpdProdutos();
//    	fecharTela();
//    	updProd.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuUpdProdutos.fxml"));
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
    void visuProduto(ActionEvent event) {
//    	VerProdutos verProd = new VerProdutos();
//    	fecharTela();
//    	verProd.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuVerProdutos.fxml"));
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
//      	Produtos.getStage().close();
//    }

}