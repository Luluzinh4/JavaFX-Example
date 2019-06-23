package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadPedidosController {

    @FXML
    private TextField codPedido;

    @FXML
    private ComboBox<?> clientePedido;

    @FXML
    private ComboBox<?> produtoPedido;

    @FXML
    private TextField qtdPedido;

    @FXML
    private TextField vlTotalPedido;

    @FXML
    private ComboBox<?> FPPedido;

    @FXML
    private ComboBox<?> statusPedido;

    @FXML
    private Button btnCadCancelar;

    @FXML
    private Button btnCadPedido;

    @FXML
    private Button btnCadCalcular;

    @FXML
    void calcularVlPedido(ActionEvent event) {
    	//Necessidade de criação de consulta para pegar o valor do produto e multiplicar com a qtd
    	criarCodPedido();
    }

	@FXML
    void criarNovoPedido(ActionEvent event) {

    }

    @FXML
    void voltarPedidos(ActionEvent event) {
    	Pedidos ped = new Pedidos();
    	fecharTela();
    	ped.start(new Stage());
    }

    void criarCodPedido() {
    	String codigo = codPedido.getText();
    	if(codigo.isEmpty()) {
    		Random rand = new Random();
			Integer valor = rand.nextInt();
			codPedido.setText(valor.toString());
    	}
	}

    void fecharTela() {
    	CadPedidos.getStage().close();
    }

}
