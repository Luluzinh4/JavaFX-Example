package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ClientesController {

    @FXML
    private Button btnCadCli;

    @FXML
    private Button btnUpdCli;

    @FXML
    private Button btnVerCli;

    @FXML
    private Button btnExcCli;

    @FXML
    private Button btnVoltarCli;

    @FXML
    void initCadCliente(ActionEvent event) {
    	CadClientes cadCli = new CadClientes();
    	fecharTela();
    	cadCli.start(new Stage());
    }

    @FXML
    void initExcCliente(ActionEvent event) {

    }

    @FXML
    void initUpdCliente(ActionEvent event) {

    }

    @FXML
    void visuCliente(ActionEvent event) {

    }

    @FXML
    void voltarHaitatsu(ActionEvent event) {
    	Main main = new Main();
    	fecharTela();
    	main.start(new Stage());
    }
    
    void fecharTela() {
      	Clientes.getStage().close();
    }
}
