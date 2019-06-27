package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
//import javafx.stage.Stage;

public class AppController {
	
//	private String nome = "admin";
//	private String senha = "Teste123";

    @FXML
    private TextField userHaitatsu;

    @FXML
    private TextField pwdUserHaitatsu;

    @FXML
    private Button btnEntrar;
    
    @FXML
    private TextField outputEntrar;

    @FXML
    private Text close;

    @FXML
    void entrarHaitatsu(ActionEvent event) {
    	String nomeUser = userHaitatsu.getText();
    	String senhaUser = pwdUserHaitatsu.getText();
    	
    	if(validarLogin(nomeUser, senhaUser)) {
//    		Main main = new Main();
//			closeTela();
//			try {
//				main.start(new Stage());
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
			
			//Parent root;
			try {
				Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuMain.fxml"));
				Scene scene = new Scene(root);
				App.getStage().setTitle("Haitatsu System");
				App.getStage().setScene(scene);
				App.getStage().show();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro: Login Inválido");
			alert.setContentText("Usuário e/ou senha inválidos");
			alert.show();
    	}
    	userHaitatsu.clear();
		pwdUserHaitatsu.clear();
    }
    
//    void entrar() {
//    	try {
//			String nomeUser = userHaitatsu.getText();
//			String senhaUser = pwdUserHaitatsu.getText();
//			//Verifica se o existe o usuário no banco. Se sim, verifica a senha
//			if(nomeUser.equals(nome) && senhaUser.equals(senha)) {
//				Main main = new Main();
//				closeTela();
//				try {
//					main.start(new Stage());
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//			} else {
//				Alert alert = new Alert(AlertType.ERROR);
//				alert.setTitle("Erro: Login Inválido");
//				alert.setContentText("Usuário e/ou senha inválidos");
//				alert.show();
//			}
//			userHaitatsu.clear();
//			pwdUserHaitatsu.clear();
//		} catch (Exception e) {
//			//Exceção
//			System.out.println(e.getMessage());
//		}
//    }
    
    boolean validarLogin(String login, String senha) {
    	ConexaoSQL cnx = new ConexaoSQL();
    	
    	if(cnx.realizarLogin(login, senha)) {
    		return true;
    	}
    	return false;
    }
    
    @FXML
    void closeHaitatsu(MouseEvent event) {
    	System.exit(0);
    }
    
//    void closeTela() {
//    	App.getStage().close();
//    }

}
