package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    	if(validarDados()) {
    		//Inser��o no banco de dados
    		resultConfirm.setText("Produto Atualizado!");
    	} else {
    		resultConfirm.setText("Produto Inv�lido!");
    	}
    	limpar();
    }

    @FXML
    void procurarProduto(ActionEvent event) {
    	resultPesquisa.clear();
    	if(validarCodProduto()) {
    		//Procura no banco de dados e seta os valores no campo
    		nomeProd.setText("Teste");
    	} else {
    		resultPesquisa.setText("C�digo Inv�lido");
    	}
    }

    @FXML
    void voltarProdutos(ActionEvent event) {
    	Produtos prod = new Produtos();
    	fecharTela();
    	try {
			prod.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    boolean validarCodProduto() {
    	//Verifica se existe o c�digo dentro do banco de dados
    	String codigo = codProd.getText();
    	if (codigo != null && codigo != "") {
    		return true;
    	}
    	return false;
    }
    
    boolean validarDados() {
		return false;
	}
    
    void fecharTela() {
    	UpdProdutos.getStage().close();
    }
    
    void limpar() {
		codProd.clear();
		nomeProd.clear();
		descProd.clear();
		vlUnitProd.clear();
		qtdProd.clear();
	}

}
