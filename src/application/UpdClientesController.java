package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javafx.stage.Stage;

public class UpdClientesController {

    @FXML
    private Button btnUpdCliente;

    @FXML
    private Button btnUpdCancelar;

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
    private Button btnUpdPesquisar;

    @FXML
    void atualizarCliente(ActionEvent event) {
    	String codCli = codCliente.getText();
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	
    	ArrayList<Object> dadosUpd = new ArrayList<>();
		//dadosUpd.add(2);
		dadosUpd.add(nomeCliente.getText());
		dadosUpd.add(cpfCliente.getText());
		dadosUpd.add(rgCliente.getText());
		dadosUpd.add(cnpjCliente.getText());
		dadosUpd.add(bancoCliente.getText());
		dadosUpd.add(agCliente.getText());
		dadosUpd.add(contaCliente.getText());
		dadosUpd.add(endCliente.getText());
		dadosUpd.add(compCliente.getText());
		dadosUpd.add(bairroCliente.getText());
		dadosUpd.add(cidadeCliente.getText());
		dadosUpd.add(cepCliente.getText());
		dadosUpd.add(telCliente.getText());
		dadosUpd.add(emailCliente.getText());
    	
    	if(cnx.atualizar(1, codCli, dadosUpd)) {
    		resultConfirm.setText("Atualização Concluída");
    		limparTela();
    		codCliente.clear();
    	} else {
    		resultConfirm.setText("Erro na atualização");
    	}
    }

    @FXML
    void procurarCliente(ActionEvent event) {
    	limparTela();
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
//    	Clientes cli = new Clientes();
//    	fecharTela();
//    	try {
//			cli.start(new Stage());
//		} catch (Exception e) {
//			e.printStackTrace();
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
    
//    void fecharTela() {
//    	UpdClientes.getStage().close();
//    }
    
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
