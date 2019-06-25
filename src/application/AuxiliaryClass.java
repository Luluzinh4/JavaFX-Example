package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AuxiliaryClass {
	
	static ConexaoSQL cnx = new ConexaoSQL();
	
	private static int qtdClientes;
	public static ArrayList<String> ClienteList = cnx.carregarCliProd(1);
	public static ArrayList<String> ProdutoList = cnx.carregarCliProd(2);

	public static String transformar(String string) {
		
		String resultado = "";
		
		resultado = resultado + "\"";
		resultado = resultado + string;
		resultado = resultado + "\"";
		
		return resultado;
	}

	public static int getQtdClientes() {
		return qtdClientes;
	}

	public static void setQtdClientes(int qtdClientes) {
		AuxiliaryClass.qtdClientes = qtdClientes;
	}
	
	public static void carregarComboBox() {
		ObservableList<String> itensCli = FXCollections.observableArrayList();
		itensCli.addAll("Aguardando Pagamento", "Pagamento aprovado", "Aguardando Estoque", "Produto Em Estoque", "Envio do Produto", "Pedido Entregue", "Cancelado");
		
		ObservableList<String> itensProd = FXCollections.observableArrayList();
		itensProd.addAll(ProdutoList);
	}

}
