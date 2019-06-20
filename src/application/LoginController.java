package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
	
	private String nome = "admin";
	private String senha = "Teste123";

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
    	try {
			String nomeUser = userHaitatsu.getText();
			String senhaUser = pwdUserHaitatsu.getText();
			//Verifica se o existe o usuário no banco. Se sim, verifica a senha
			if(nomeUser.equals(nome) && senhaUser.equals(senha)) {
				Main main = new Main();
				closeTela();
				try {
					main.start(new Stage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro: Login Inválido");
				alert.setContentText("Usuário e/ou senha inválidos");
				alert.show();
			}
			userHaitatsu.clear();
			pwdUserHaitatsu.clear();
		} catch (Exception e) {
			//Exceção
			System.out.println(e.getMessage());
		}
    }
    
    @FXML
    void closeHaitatsu(MouseEvent event) {
    	System.exit(0);
    }
    
    void closeTela() {
    	Login.getStage().close();
    }

}
