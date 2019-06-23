package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadUsuariosController {

    @FXML
    private TextField codUsuario;

    @FXML
    private TextField nomeUsuario;

    @FXML
    private TextField cpfUsuario;

    @FXML
    private PasswordField senhaUsuario;
    
    @FXML
    private TextField resultConfirm;

    @FXML
    private Button btnCadCancelar;

    @FXML
    private Button btnCadUsuario;

    @FXML
    void criarCodUsuario(MouseEvent event) {
    	Random rand = new Random();
    	Integer valor = rand.nextInt();
    	
    	codUsuario.setText(valor.toString());
    }

    @FXML
    void criarNovoUsuario(ActionEvent event) {
    	resultConfirm.setText("Usuário Criado");
    }

    @FXML
    void voltarUsuarios(ActionEvent event) {
    	Usuarios user = new Usuarios();
    	fecharTela();
    	user.start(new Stage());
    }
    
    void fecharTela() {
    	CadUsuarios.getStage().close();
    }

}
