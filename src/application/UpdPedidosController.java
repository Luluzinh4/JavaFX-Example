package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
//import javafx.stage.Stage;

public class UpdPedidosController {

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
    private TextField ultStatusPedido;

    @FXML
    private Button btnExcCancelar;

    @FXML
    private Button btnUpdPedido;

    @FXML
    private Button btnUpdPesquisar;

    @FXML
    private ComboBox<String> statusPedido;

    @FXML
    private TextField resultConfirm;
    
    @FXML
    public void initialize() {
    	ObservableList<String> itensStatus = FXCollections.observableArrayList();
		itensStatus.addAll("Aguardando Pagamento", "Pagamento aprovado", "Aguardando Estoque", "Produto Em Estoque", "Envio do Produto", "Pedido Entregue");
		statusPedido.setItems(itensStatus);
    }

    @FXML
    void atualizarPedido(ActionEvent event) {
//    	String codigo = codPedido.getText();
//    	//Integer valor = Integer.parseInt(codigo);
//    	
//    	if(codigo.equals("123")) {
//    		resultConfirm.setText("Pedido Atualizado");
//	    	limparTela();
//    	} else {
//    		resultConfirm.setText("Comando Inválido");
//    	}
    	
    	String codigo = codPedido.getText();
    	
    	if(validarUpdate()) {
    		ConexaoSQL cnx = new ConexaoSQL();
	    	ArrayList<Object> dadosUpd = new ArrayList<>();
	    	
	    	dadosUpd.add(statusPedido.getSelectionModel().getSelectedItem());
	    	
	    	if(cnx.atualizar(3, codigo, dadosUpd)) {
	    		resultConfirm.setText("Pedido atualizado");
	    		limparTela();
	    		codPedido.clear();
	    	}
    	} else {
    		resultConfirm.setText("Insira um novo status");
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
//    		ultStatusPedido.setText("Aguardando Aprovação");
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
				ultStatusPedido.setText(resultado.get(5));
			} else {
				resultConfirm.setText("Código Inválido");
				codPedido.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void voltarPedidos(ActionEvent event) {
//    	Pedidos ped = new Pedidos();
//    	fecharTela();
//    	ped.start(new Stage());
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HaitatsuPedidos.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			App.getStage().setTitle("Haitatsu System");
			App.getStage().setScene(scene);
			App.getStage().show();
			//setStage(primaryStage);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    boolean validarUpdate() {
    	String statusUpd = statusPedido.getSelectionModel().getSelectedItem();
    	
    	if(!statusUpd.isEmpty()) {
    		return true;
    	}
    	return false;
    }
    
//    void fecharTela() {
//    	UpdPedidos.getStage().close();
//    }
    
    void limparTela() {
    	//codPedido.clear();
    	clientePedido.clear();
    	produtoPedido.clear();
    	qtdPedido.clear();
    	vlTotalPedido.clear();
    	fpPedido.clear();
    	ultStatusPedido.clear();
    	//motivoExcPedido.setId("0");
    }

}
