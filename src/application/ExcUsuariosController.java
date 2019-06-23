package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ExcUsuariosController {

    @FXML
    private TextField codUsuario;

    @FXML
    private TextField nomeUsuario;

    @FXML
    private TextField cpfUsuario;

    @FXML
    private Button btnExcCancelar;

    @FXML
    private Button btnExcUsuario;

    @FXML
    private TextField resultConfirm;

    @FXML
    private Button btnExcPesquisar;

    @FXML
    void excluirUsuario(ActionEvent event) {
    	resultConfirm.setText("Usu�rio Exclu�do");
    	limparTela();
    	codUsuario.clear();
    }

    @FXML
    void pesquisarUsuario(ActionEvent event) {
    	String codigo = codUsuario.getText();
    	
    	if(codigo.equals("123")) {
    		nomeUsuario.setText("Teste");
    	} else {
    		limparTela();
    		codUsuario.clear();
    		resultConfirm.setText("C�digo Inv�lido");
    	}
    }

    @FXML
    void voltarUsuarios(ActionEvent event) {
    	Usuarios user = new Usuarios();
    	fecharTela();
    	user.start(new Stage());
    }
    
    void fecharTela() {
    	ExcUsuarios.getStage().close();
    }
    
    void limparTela() {
    	nomeUsuario.clear();
    	cpfUsuario.clear();
    	nomeUsuario.clear();
    }

}
