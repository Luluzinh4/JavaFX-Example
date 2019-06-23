package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UsuariosController {

    @FXML
    private Button btnCadUsers;

    @FXML
    private Button btnVoltarUsers;

    @FXML
    private Button btnExcUsers;
    
    @FXML
    private Button btnUpdUsers;

    @FXML
    void initCadUser(ActionEvent event) {
    	CadUsuarios cadUser = new CadUsuarios();
    	fechaTela();
    	cadUser.start(new Stage());
    }

    @FXML
    void initexcUsers(ActionEvent event) {
    	ExcUsuarios excUser = new ExcUsuarios();
    	fechaTela();
    	excUser.start(new Stage());
    }
    
    @FXML
    void initUpdUsers(ActionEvent event) {
    	UpdUsuarios updUser = new UpdUsuarios();
    	fechaTela();
    	updUser.start(new Stage());
    }

    @FXML
    void voltarConfig(ActionEvent event) {
    	Config conf = new Config();
    	fechaTela();
    	conf.start(new Stage());
    }
    
    void fechaTela() {
    	Usuarios.getStage().close();
    }

}
