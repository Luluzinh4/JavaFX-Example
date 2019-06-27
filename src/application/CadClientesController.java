package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
//import javafx.stage.Stage;

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
    void criarCodCliente(MouseEvent event) {
    	resultConfirm.clear();
    	//Verificar a contagem de clientes no banco de dados.
//    	Random random = new Random();
//    	Integer codigo = random.nextInt();
//    	codCliente.setText(codigo.toString());
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	Integer codigo = cnx.countQtd(1) + 1;
    	codCliente.setText(codigo.toString());
    }

    @FXML
    void criarNovoCliente(ActionEvent event) {
    	ConexaoSQL cnx = new ConexaoSQL();
    	
    	if(validarDados()) {
    		//Acrescentar mais um na variável auxiliar
    		//AuxiliaryClass.setQtdClientes(AuxiliaryClass.getQtdClientes() + 1);
    		
    		//Carregando dados no array
    		ArrayList<Object> dados = new ArrayList<>();
    		dados.add(Integer.parseInt(codCliente.getText()));
    		dados.add(nomeCliente.getText());
    		dados.add(cpfCliente.getText());
    		dados.add(rgCliente.getText());
    		dados.add(cnpjCliente.getText());
    		dados.add(bancoCliente.getText());
    		dados.add(agCliente.getText());
    		dados.add(contaCliente.getText());
    		dados.add(endCliente.getText());
    		dados.add(compCliente.getText());
    		dados.add(bairroCliente.getText());
    		dados.add(cidadeCliente.getText());
    		dados.add(cepCliente.getText());
    		dados.add(telCliente.getText());
    		dados.add(emailCliente.getText());
    		
    		if(cnx.criar(1, dados)) {
    			resultConfirm.setText("Cliente Criado!");
    		} else {
    			//AuxiliaryClass.setQtdClientes(AuxiliaryClass.getQtdClientes() - 1);
    			resultConfirm.setText("Cliente não criado.");
    		}
    	} else {
    		resultConfirm.setText("Dados Inválidos!");
    	}
    	limpar();
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
//    	CadClientes.getStage().close();
//    }
    
    boolean validarDados() {
    	String codigoCli = codCliente.getText();
    	
    	if(codigoCli.isEmpty()) {
    		return false;
    	}
		return true;
	}
	
	void limpar() {
		codCliente.clear();
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
