package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//import javafx.stage.Stage;

public class ExcProdutosController {

    @FXML
    private TextField codProd;

    @FXML
    private TextField nomeProd;

    @FXML
    private TextArea descProd;

    @FXML
    private TextField vlUnitProd;

    @FXML
    private TextField qtdProd;

    @FXML
    private Button btnExcProduto;

    @FXML
    private Button btnExcCancelar;

    @FXML
    private TextField resultConfirm;

    @FXML
    private Button excluirConfirm;

    @FXML
    private TextField resultPesquisa;

    @FXML
    void excluirProduto(ActionEvent event) {
    	String codigoProd = codProd.getText();
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	if(cnx.deletar(2, codigoProd)) {
    		resultConfirm.setText("Produto Excluído");
    		limpar();
    		codProd.clear();
    	} else {
    		resultConfirm.setText("Produto Inexistente");
    	}
    }

    @FXML
    void procurarProduto(ActionEvent event) {
    	limpar();
    	resultPesquisa.clear();
    	String codigoProd = codProd.getText();
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	
    	try {
    		ArrayList<String> resultado = cnx.selecionar(2, codigoProd);
    		
    		if(!resultado.isEmpty()) {
    			nomeProd.setText(resultado.get(0));
    			descProd.setText(resultado.get(1));
    			vlUnitProd.setText(resultado.get(2));
    			qtdProd.setText(resultado.get(3));
    		} else {
    			resultPesquisa.setText("Código Inválido");
    			codProd.clear();
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void voltarProdutos(ActionEvent event) {
//    	Produtos prod = new Produtos();
//    	fecharTela();
//    	try {
//			prod.start(new Stage());
//		} catch (Exception e) {
//			e.printStackTrace();
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
    
//    void fecharTela() {
//    	ExcProdutos.getStage().close();
//    }
    
    void limpar() {
		//codProd.clear();
		nomeProd.clear();
		descProd.clear();
		vlUnitProd.clear();
		qtdProd.clear();
		resultConfirm.clear();
	}

}
