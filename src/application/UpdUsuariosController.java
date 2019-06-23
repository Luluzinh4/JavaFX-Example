package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdUsuariosController {

    @FXML
    private TextField codUsuario;

    @FXML
    private TextField nomeUsuario;

    @FXML
    private TextField cpfUsuario;
    
    @FXML
    private TextField loginUsuario;

    @FXML
    private PasswordField senhaUsuario;

    @FXML
    private Button btnUpdCancelar;

    @FXML
    private Button btnUpdUsuario;

    @FXML
    private TextField resultConfirm;

    @FXML
    private Button btnUpdPesquisar;

    @FXML
    void atualizarUsuario(ActionEvent event) {
    	String codigoUser = codUsuario.getText();
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	
    	ArrayList<Object> dadosUpd = new ArrayList<>();
    	
    	dadosUpd.add(nomeUsuario.getText());
    	dadosUpd.add(cpfUsuario.getText());
    	dadosUpd.add(loginUsuario.getText());
    	dadosUpd.add(senhaUsuario.getText());
    	
    	if(cnx.atualizar(4, codigoUser, dadosUpd)) {
    		resultConfirm.setText("Usuário Atualizado!");
    		limpar();
    		codUsuario.clear();
    	} else {
    		resultConfirm.setText("Usuário Inválido");
    	}
    }

    @FXML
    void pesquisarUsuario(ActionEvent event) {
    	limpar();
    	resultConfirm.clear();
    	String codigoUser = codUsuario.getText();
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	
    	try {
    		ArrayList<String> resultado = cnx.selecionar(4, codigoUser);
    		
    		if(!resultado.isEmpty()) {
    			nomeUsuario.setText(resultado.get(0));
    			cpfUsuario.setText(resultado.get(1));
    			loginUsuario.setText(resultado.get(2));
    			senhaUsuario.setText(resultado.get(3));
    		} else {
    			resultConfirm.setText("Código Inválido");
    			codUsuario.clear();
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void voltarUsuarios(ActionEvent event) {
    	Usuarios user = new Usuarios();
    	fecharTela();
    	user.start(new Stage());
    }
    
    void fecharTela() {
    	UpdUsuarios.getStage().close();
    }
    
    void limpar() {
    	nomeUsuario.clear();
    	cpfUsuario.clear();
    	loginUsuario.clear();
    	senhaUsuario.clear();
    }

}
