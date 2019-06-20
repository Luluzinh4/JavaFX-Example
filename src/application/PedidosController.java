package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PedidosController {

    @FXML
    private Button btnCadPed;

    @FXML
    private Button btnUpdPed;

    @FXML
    private Button btnVerPed;

    @FXML
    private Button btnExcPed;

    @FXML
    private Button btnVoltarPed;

    @FXML
    void initCadPedido(ActionEvent event) {

    }

    @FXML
    void initExcPedido(ActionEvent event) {

    }

    @FXML
    void initUpdPedido(ActionEvent event) {

    }

    @FXML
    void visuPedido(ActionEvent event) {

    }

    @FXML
    void voltarHaitatsu(ActionEvent event) {
    	Main main = new Main();
    	fecharTela();
    	main.start(new Stage());
    }
    
    void fecharTela() {
      	Pedidos.getStage().close();
    }

}