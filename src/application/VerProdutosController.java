package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VerProdutosController {

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
    private Button btnVerVoltar;

    @FXML
    private TextField resultConfirm;

    @FXML
    private Button excluirConfirm;

    @FXML
    private TextField resultPesquisa;

    @FXML
    void procurarProduto(ActionEvent event) {
    	resultPesquisa.clear();
    	if(validarCodProduto()) {
    		//Procura no banco de dados e seta os valores no campo
    		nomeProd.setText("Teste");
    	} else {
    		resultPesquisa.setText("Código Inválido");
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
    	//Verifica se existe o código dentro do banco de dados
    	String codigo = codProd.getText();
    	if (codigo != null && codigo != "") {
    		return true;
    	}
    	return false;
    }
    
    void fecharTela() {
    	VerProdutos.getStage().close();
    }

}
