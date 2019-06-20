package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadClientesController {

    @FXML
    private Button btnCadCliente;

    @FXML
    private Button btnCadCancelar;

    @FXML
    private TextField resultConfirm;

    @FXML
    private TextField codCliente;

    @FXML
    private TextField nomeCliente;

    @FXML
    private TextField cpfCliente;

    @FXML
    private TextField rgCliente;

    @FXML
    private TextField cnpjCliente;

    @FXML
    private ComboBox<?> bancoCliente;

    @FXML
    private TextField agCliente;

    @FXML
    private TextField contaCliente;

    @FXML
    private TextField endCliente;

    @FXML
    private TextField compCliente;

    @FXML
    private TextField bairroCliente;

    @FXML
    private TextField cidadeCliente;

    @FXML
    private TextField cepCliente;

    @FXML
    private TextField telCliente;

    @FXML
    private TextField emailCliente;

    @FXML
    void criarCodCliente(MouseEvent event) {
    	resultConfirm.clear();
    	//Verificar a contagem de clientes no banco de dados.
    	Random random = new Random();
    	Integer codigo = random.nextInt();
    	codCliente.setText(codigo.toString());
    }

    @FXML
    void criarNovoCliente(ActionEvent event) {
    	if(validarDados()) {
    		//Inserção no banco de dados
    		resultConfirm.setText("Cliente Criado!");
    	} else {
    		resultConfirm.setText("Dados Inválidos!");
    	}
    	limpar();
    }

    @FXML
    void voltarClientes(ActionEvent event) {
    	Clientes cli = new Clientes();
    	fecharTela();
    	try {
			cli.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    void fecharTela() {
    	CadClientes.getStage().close();
    }
    
    boolean validarDados() {
		return true;
	}
	
	void limpar() {
		codCliente.clear();
		nomeCliente.clear();
		cpfCliente.clear();
		rgCliente.clear();
		cnpjCliente.clear();
		agCliente.clear();
		contaCliente.clear();
		endCliente.clear();
		compCliente.clear();
		bairroCliente.clear();
		cidadeCliente.clear();
		cepCliente.clear();
		telCliente.clear();
		emailCliente.clear();
	}

}
