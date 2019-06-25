package application;

import java.util.ArrayList;

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
//    	String codigo = codPedido.getText();
//    	//Integer valor = Integer.parseInt(codigo);
//    	
//    	if(codigo.equals("123")) {
//    		resultConfirm.setText("Pedido Cancelado");
//	    	limparTela();
//    	} else {
//    		resultConfirm.setText("Comando Inválido");
//    	}
    	
    	String codigo = codPedido.getText();
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	if(cnx.deletar(3, codigo)) {
    		resultConfirm.setText("Pedido Cancelado");
    		limparTela();
    		codPedido.clear();
    	} else {
    		resultConfirm.setText("Pedido Inexistente");
    	}
    }

    @FXML
    void pesquisarPedido(ActionEvent event) {
//    	String codigo = codPedido.getText();
//    	//Integer valor = Integer.parseInt(codigo);
//    	
//    	if(codigo.equals("123")) {
//    		clientePedido.setText("Luiza Perez");
//    		produtoPedido.setText("Corrente de Prata");
//    		qtdPedido.setText("25");
//    		vlTotalPedido.setText("R$ 560,00");
//    		fpPedido.setText("Transferência");
//    		ultStatus.setText("Aguardando Aprovação");
//    	} else {
//    		limparTela();
//    		codPedido.clear();
//    		resultConfirm.setText("Código Inválido!");
//    	}
    	
    	limparTela();
    	resultConfirm.clear();
    	String codigo = codPedido.getText();
    	
    	ConexaoSQL cnx = new ConexaoSQL();
    	
    	try {
    		//System.out.println(codigo);
			ArrayList<String> resultado = cnx.selecionar(3, codigo);
			
			if(!resultado.isEmpty()) {
				String cliente = cnx.reTransformar(1, resultado.get(0));
				String produto = cnx.reTransformar(2, resultado.get(1));
				
				clientePedido.setText(cliente);
				produtoPedido.setText(produto);
				qtdPedido.setText(resultado.get(2));
				vlTotalPedido.setText(resultado.get(3));
				fpPedido.setText(resultado.get(4));
				ultStatus.setText(resultado.get(5));
			} else {
				resultConfirm.setText("Código Inválido");
				codPedido.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
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
    	//codPedido.clear();
    	clientePedido.clear();
    	produtoPedido.clear();
    	qtdPedido.clear();
    	vlTotalPedido.clear();
    	fpPedido.clear();
    	ultStatus.clear();
    	//motivoExcPedido.setId("0");
    }

}
