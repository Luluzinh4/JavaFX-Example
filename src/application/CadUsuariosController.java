package application;

import java.util.ArrayList;

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
    private TextField loginUsuario;

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
    	resultConfirm.clear();
//    	Random rand = new Random();
//    	Integer valor = rand.nextInt();
//    	
//    	codUsuario.setText(valor.toString());
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	Integer codigo = cnx.countQtd(4) + 1;
    	codUsuario.setText(codigo.toString());
    }

    @FXML
    void criarNovoUsuario(ActionEvent event) {
    	//resultConfirm.setText("Usuário Criado");
    	ConexaoSQL cnx = new ConexaoSQL();
    	
    	if(validarDados()) {
    		ArrayList<Object> dados = new ArrayList<>();
    		dados.add(Integer.parseInt(codUsuario.getText()));
    		dados.add(nomeUsuario.getText());
    		dados.add(cpfUsuario.getText());
    		dados.add(loginUsuario.getText());
    		dados.add(senhaUsuario.getText());
    		
    		if(cnx.criar(4, dados)) {
    			resultConfirm.setText("Usuário Criado!");
    		} else {
    			resultConfirm.setText("Usuário Não Criado!");
    		}
    	} else {
    		resultConfirm.setText("Dados Inválidos!");
    	}
    	limparTela();
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
    
    boolean validarDados() {
    	String codigoUser = codUsuario.getText();
    	
    	if(codigoUser.isEmpty()) {
    		return false;
    	}
    	return true;
    }
    
    void limparTela() {
    	codUsuario.clear();
    	nomeUsuario.clear();
    	cpfUsuario.clear();
    	loginUsuario.clear();
    	senhaUsuario.clear();
    }

}
