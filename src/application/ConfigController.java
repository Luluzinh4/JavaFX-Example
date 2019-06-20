package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ConfigController {

    @FXML
    private Button btnCadUser;

    @FXML
    private Button btnVoltarConfig;

    @FXML
    private Button btnLogout;

    @FXML
    void initCadUsuario(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {
    	Login login = new Login();
    	closeTela();
    	login.start(new Stage());
    }

    @FXML
    void voltarHaitatsu(ActionEvent event) {
    	Main main = new Main();
    	closeTela();
    	main.start(new Stage());
    }
    
    void closeTela() {
    	Config.getStage().close();
    }

}
