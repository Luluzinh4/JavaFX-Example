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

public class ExcUsuariosController {

    @FXML
    private TextField codUsuario;

    @FXML
    private TextField nomeUsuario;

    @FXML
    private TextField cpfUsuario;
    
    @FXML
    private TextField loginUsuario;

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
//    	resultConfirm.setText("Usuário Excluído");
//    	limparTela();
//    	codUsuario.clear();
    	
    	String codigoUser = codUsuario.getText();
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	if(cnx.deletar(4, codigoUser)) {
    		resultConfirm.setText("Usuário Excluído");
    		limparTela();
    		codUsuario.clear();
    	} else {
    		resultConfirm.setText("Usuário Inexistente");
    	}
    }

    @FXML
    void pesquisarUsuario(ActionEvent event) {
    	limparTela();
    	resultConfirm.clear();
    	String codigoUser = codUsuario.getText();
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	
    	try {
    		ArrayList<String> resultado = cnx.selecionar(4, codigoUser);
    		
    		if(!resultado.isEmpty()) {
    			nomeUsuario.setText(resultado.get(0));
    			cpfUsuario.setText(resultado.get(1));
    			loginUsuario.setText(resultado.get(2));
    			//senhaUsuario.setText(resultado.get(3));
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
//    	Usuarios user = new Usuarios();
//    	fecharTela();
//    	user.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuUsuarios.fxml"));
			Scene scene = new Scene(root);
			App.getStage().setTitle("Haitatsu System");
			App.getStage().setScene(scene);
			App.getStage().show();
			//setStage(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
//    void fecharTela() {
//    	ExcUsuarios.getStage().close();
//    }
    
    void limparTela() {
    	nomeUsuario.clear();
    	cpfUsuario.clear();
    	loginUsuario.clear();
    }

}
