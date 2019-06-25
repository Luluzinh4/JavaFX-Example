package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ExcPedidosController {

    @FXML
    private TextField codPedido;

    @FXML
    private TextField clientePedido;

    @FXML
    private TextField produtoPedido;

    @FXML
    private TextField qtdPedido;

    @FXML
    private TextField vlTotalPedido;

    @FXML
    private TextField fpPedido;

    @FXML
    private TextField ultStatus;

    @FXML
    private Button btnExcCancelar;

    @FXML
    private Button btnExcPedido;

    @FXML
    private Button btnExcPesquisar;
    
    @FXML
    private TextField resultConfirm;

    @FXML
    private ComboBox<String> motivoExcPedido;
    
    @FXML
    public void initialize() {
    	ObservableList<String> itensMotivo = FXCollections.observableArrayList();
		itensMotivo.addAll("Falta de Estoque", "Nova Solicitação", "Falta de Pagamento", "Cancelado pelo Cliente");
		motivoExcPedido.setItems(itensMotivo);
    }

    @FXML
    void excluirPedido(ActionEvent event) {
    	String codigo = codPedido.getText();
    	//Integer valor = Integer.parseInt(codigo);
    	
    	if(codigo.equals("123")) {
    		resultConfirm.setText("Pedido Cancelado");
	    	limparTela();
    	} else {
    		resultConfirm.setText("Comando Inválido");
    	}
    }

    @FXML
    void pesquisarPedido(ActionEvent event) {
    	String codigo = codPedido.getText();
    	//Integer valor = Integer.parseInt(codigo);
    	
    	if(codigo.equals("123")) {
    		clientePedido.setText("Luiza Perez");
    		produtoPedido.setText("Corrente de Prata");
    		qtdPedido.setText("25");
    		vlTotalPedido.setText("R$ 560,00");
    		fpPedido.setText("Transferência");
    		ultStatus.setText("Aguardando Aprovação");
    	} else {
    		limparTela();
    		codPedido.clear();
    		resultConfirm.setText("Código Inválido!");
    	}
    }
    
    @FXML
    void limparCampo(MouseEvent event) {
    	String resultado = resultConfirm.getText();
    	
    	if(!resultado.isEmpty()) {
    		resultConfirm.clear();
    	}
    }

    @FXML
    void voltarPedidos(ActionEvent event) {
    	Pedidos ped = new Pedidos();
    	fecharTela();
    	ped.start(new Stage());
    }
    
    void fecharTela() {
    	ExcPedidos.getStage().close();
    }
    
    void limparTela() {
    	codPedido.clear();
    	clientePedido.clear();
    	produtoPedido.clear();
    	qtdPedido.clear();
    	vlTotalPedido.clear();
    	fpPedido.clear();
    	ultStatus.clear();
    	//motivoExcPedido.setId("0");
    }

}
