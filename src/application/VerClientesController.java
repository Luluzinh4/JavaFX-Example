package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VerClientesController {

    @FXML
    private Button btnVerVoltar;

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
    private TextField bancoCliente;

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
    private Button btnVerPesquisar;

    @FXML
    void procurarCliente(ActionEvent event) {
    	limparTela();
    	resultConfirm.clear();
    	String codCli = codCliente.getText();
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	try {
    		ArrayList<String> resultado = cnx.selecionar(1, codCli);
    		
    		if(!resultado.isEmpty()) {
    			nomeCliente.setText(resultado.get(0));
		    	cpfCliente.setText(resultado.get(1));
		    	rgCliente.setText(resultado.get(2));
		    	cnpjCliente.setText(resultado.get(3));
		    	bancoCliente.setText(resultado.get(4));
		    	agCliente.setText(resultado.get(5));
		    	contaCliente.setText(resultado.get(6));
		    	endCliente.setText(resultado.get(7));
		    	compCliente.setText(resultado.get(8));
		    	bairroCliente.setText(resultado.get(9));
		    	cidadeCliente.setText(resultado.get(10));
		    	cepCliente.setText(resultado.get(11));
		    	telCliente.setText(resultado.get(12));
		    	emailCliente.setText(resultado.get(13));
    		} else {
    			resultConfirm.setText("Código Inválido");
    			codCliente.clear();
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
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
    	VerClientes.getStage().close();
    }
    
    void limparTela() {
		nomeCliente.clear();
		cpfCliente.clear();
		rgCliente.clear();
		cnpjCliente.clear();
		bancoCliente.clear();
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
