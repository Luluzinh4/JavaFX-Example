package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
//import javafx.stage.Stage;

public class VerPedidosController {

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
    private Button btnVerCancelar;

    @FXML
    private Button btnVerPesquisar;

    @FXML
    private TextField resultConfirm;

    @FXML
    void limparCampo(MouseEvent event) {
    	String resultado = resultConfirm.getText();
    	
    	if(!resultado.isEmpty()) {
    		resultConfirm.clear();
    	}
    }

    @FXML
    void pesquisarPedido(ActionEvent event) {	
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
    
//    void fecharTela() {
//    	VerPedidos.getStage().close();
//    }

    void limparTela() {
    	//codPedido.clear();
    	clientePedido.clear();
    	produtoPedido.clear();
    	qtdPedido.clear();
    	vlTotalPedido.clear();
    	fpPedido.clear();
    	ultStatusPedido.clear();
    }
    
}
