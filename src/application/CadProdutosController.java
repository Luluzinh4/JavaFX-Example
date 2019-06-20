package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    	Random rand = new Random();
    	Integer numero = rand.nextInt();
    	codProd.setText(numero.toString());
    }

    @FXML
    void criarNovoProduto(ActionEvent event) {
    	if(validarDados()) {
    		//Inserção no banco de dados
    		resultConfirm.setText("Produto Criado!");
    	} else {
    		resultConfirm.setText("Dados Inválidos!");
    	}
    	limpar();
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

	void fecharTela() {
		CadProdutos.getStage().close();	
	}
	
	boolean validarDados() {
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

