package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ComboBox<String> clientePedido;

    @FXML
    private ComboBox<String> produtoPedido;

    @FXML
    private TextField qtdPedido;

    @FXML
    private TextField vlTotalPedido;

    @FXML
    private ComboBox<String> FPPedido;

    @FXML
    private ComboBox<String> statusPedido;

    @FXML
    private Button btnCadCancelar;

    @FXML
    private Button btnCadPedido;

    @FXML
    private Button btnCadCalcular;
    
    @FXML
    private TextField resultConfirm;

    @FXML
    private TextField resultCalcular;

    @FXML
    public void initialize() {
    	ConexaoSQL cnx = new ConexaoSQL();
    	ArrayList<String> ClienteList = cnx.carregarCliProd(1);
    	ObservableList<String> itensCli = FXCollections.observableArrayList();
		itensCli.addAll(ClienteList);
		clientePedido.setItems(itensCli);
		
		ArrayList<String> ProdutoList = cnx.carregarCliProd(2);
		ObservableList<String> itensProd = FXCollections.observableArrayList();
		itensProd.addAll(ProdutoList);
		produtoPedido.setItems(itensProd);
		
		ObservableList<String> itensFP = FXCollections.observableArrayList();
		itensFP.addAll("Dinheiro", "Transferência");
		FPPedido.setItems(itensFP);
		
		ObservableList<String> itensStatus = FXCollections.observableArrayList();
		itensStatus.addAll("Aguardando Pagamento", "Pagamento aprovado", "Aguardando Estoque", "Produto Em Estoque", "Envio do Produto", "Pedido Entregue");
		statusPedido.setItems(itensStatus);
    }
    
    @FXML
    void calcularVlPedido(ActionEvent event) {
    	resultConfirm.clear();
    	resultCalcular.clear();
    	//Necessidade de criação de consulta para pegar o valor do produto e multiplicar com a qtd
    	String produto = produtoPedido.getSelectionModel().getSelectedItem();
    	//System.out.println(produto);
    	String qtdProd = qtdPedido.getText();
    	if(!(produto == null) && !qtdProd.isEmpty()) {
    		ConexaoSQL cnx = new ConexaoSQL();
    		    		
    		Float valorProd = cnx.consultarValorProduto(produto);
    		int qtdSelect = Integer.parseInt(qtdProd);
    		Float total = valorProd * qtdSelect;
    		
    		vlTotalPedido.setText(total.toString());
    		
    		criarCodPedido();
    	} else {
    		//Criar campo para pedir a inserção dos dados
    		//resultCalcular.setText("Insira produto e quantidade");
    		if(produto == null) {
    			resultCalcular.setText("Insira um produto");
    		} else {
    			resultCalcular.setText("Insira a quantidade");
    		}
    	}
    }

	@FXML
    void criarNovoPedido(ActionEvent event) {
//		limparTela();
//		resultConfirm.setText("Pedido Concluído");
		
		ConexaoSQL cnx = new ConexaoSQL();
		
		String cliente = clientePedido.getSelectionModel().getSelectedItem();
		String codigoCliente = cnx.transformar(1, cliente);
		
		String produto = produtoPedido.getSelectionModel().getSelectedItem();
		String codigoProduto = cnx.transformar(2, produto);
		
		if(validarDados()) {
			ArrayList<Object> dados = new ArrayList<>();
			dados.add(Integer.parseInt(codPedido.getText()));
			dados.add(Integer.parseInt(codigoCliente));
			dados.add(Integer.parseInt(codigoProduto));
			dados.add(Integer.parseInt(qtdPedido.getText()));
			dados.add(Float.parseFloat(vlTotalPedido.getText()));
			dados.add(FPPedido.getSelectionModel().getSelectedItem());
			dados.add(statusPedido.getSelectionModel().getSelectedItem());
			
			if(cnx.criar(3, dados)) {
				resultConfirm.setText("Pedido Criado");
			} else {
				resultConfirm.setText("Pedido não Criado");
			}
			limparTela();
		} else {
			resultConfirm.setText("Insira todos os dados");
		}
		//limparTela();
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
//    		Random rand = new Random();
//			Integer valor = rand.nextInt();
//			codPedido.setText(valor.toString());
    		
    		ConexaoSQL cnx = new ConexaoSQL();
    		Integer cod = cnx.countQtd(3) + 1;
    		codPedido.setText(cod.toString());
    	}
	}
    
    boolean validarDados() {
    	String codigo = codPedido.getText();
    	String cliente = clientePedido.getSelectionModel().getSelectedItem();
    	String formaPag = FPPedido.getSelectionModel().getSelectedItem();
    	String status = statusPedido.getSelectionModel().getSelectedItem();
    	
    	if(codigo.isEmpty() || cliente == null || formaPag == null || status == null) {
    		return false;
    	}    	
    	return true;
    }

    void fecharTela() {
    	CadPedidos.getStage().close();
    }
    
    void limparTela() {
    	codPedido.clear();
    	clientePedido.getSelectionModel().clearSelection();
    	produtoPedido.getSelectionModel().clearSelection();
    	qtdPedido.clear();
    	vlTotalPedido.clear();
    	FPPedido.getSelectionModel().clearSelection();
    	statusPedido.getSelectionModel().clearSelection();
    }

}
