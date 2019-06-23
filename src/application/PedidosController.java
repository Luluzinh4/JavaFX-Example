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
    	CadPedidos cadPed = new CadPedidos();
    	fecharTela();
    	cadPed.start(new Stage());
    }

    @FXML
    void initExcPedido(ActionEvent event) {
    	ExcPedidos excPed = new ExcPedidos();
    	fecharTela();
    	excPed.start(new Stage());
    }

    @FXML
    void initUpdPedido(ActionEvent event) {
    	UpdPedidos updPed = new UpdPedidos();
    	fecharTela();
    	updPed.start(new Stage());
    }

    @FXML
    void visuPedido(ActionEvent event) {
    	VerPedidos verPed = new VerPedidos();
    	fecharTela();
    	verPed.start(new Stage());
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