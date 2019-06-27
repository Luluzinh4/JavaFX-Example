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

public class UpdProdutosController {

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
    private Button btnUpdProduto;

    @FXML
    private Button btnUpdCancelar;

    @FXML
    private TextField resultConfirm;

    @FXML
    private Button btnSearchProd;

    @FXML
    private TextField resultPesquisa;

    @FXML
    void updateProduto(ActionEvent event) {
    	String codigoProd = codProd.getText();
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	
    	ArrayList<Object> dadosUpd = new ArrayList<>();
    	
    	dadosUpd.add(nomeProd.getText());
    	dadosUpd.add(descProd.getText());
    	dadosUpd.add(vlUnitProd.getText());
    	dadosUpd.add(qtdProd.getText());
    	
    	if(cnx.atualizar(2, codigoProd, dadosUpd)) {
    		resultConfirm.setText("Produto Atualizado!");
    		limpar();
    		codProd.clear();
    	} else {
    		resultConfirm.setText("Produto Inválido!");
    	}
    	//limpar();
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
//    	UpdProdutos.getStage().close();
//    }
    
    void limpar() {
		//codProd.clear();
		nomeProd.clear();
		descProd.clear();
		vlUnitProd.clear();
		qtdProd.clear();
	}

}
