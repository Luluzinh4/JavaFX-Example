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
import javafx.scene.input.MouseEvent;
//import javafx.stage.Stage;

public class CadProdutosController {

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
    private Button btnCadProduto;

    @FXML
    private Button btnCadCancelar;
    
    @FXML
    private TextField resultConfirm;

    @FXML
    void criarCodPedido(MouseEvent event) {
    	resultConfirm.clear();
    	//Verificar a contagem de produtos no banco de dados.
//    	Random rand = new Random();
//    	Integer numero = rand.nextInt();
//    	codProd.setText(numero.toString());
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	Integer codigo = cnx.countQtd(2) + 1;
    	codProd.setText(codigo.toString());
    }

    @FXML
    void criarNovoProduto(ActionEvent event) {
    	ConexaoSQL cnx = new ConexaoSQL();
    	
    	if(validarDados()) {
    		//Inserção no banco de dados
    		//Carregando array com dados
    		ArrayList<Object> dados = new ArrayList<>();
    		dados.add(Integer.parseInt(codProd.getText()));
    		dados.add(nomeProd.getText());
    		dados.add(descProd.getText());
    		dados.add(Float.parseFloat(vlUnitProd.getText()));
    		dados.add(Integer.parseInt(qtdProd.getText()));
    		
    		if(cnx.criar(2, dados)) {
    			resultConfirm.setText("Produto Criado!");
    		} else {
    			resultConfirm.setText("Produto Não Criado!");
    		}
    	} else {
    		resultConfirm.setText("Dados Inválidos!");
    	}
    	limpar();
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

//	void fecharTela() {
//		CadProdutos.getStage().close();	
//	}
	
	boolean validarDados() {
		String codigoProd = codProd.getText();
		
		if(codigoProd.isEmpty()) {
			return false;
		}
		return true;
	}
	
	void limpar() {
		codProd.clear();
		nomeProd.clear();
		descProd.clear();
		vlUnitProd.clear();
		qtdProd.clear();
	}

}

