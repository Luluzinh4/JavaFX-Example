package application;

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

    }

    @FXML
    void pesquisarUsuario(ActionEvent event) {

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

}
