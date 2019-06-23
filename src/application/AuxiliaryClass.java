package application;

public class AuxiliaryClass {
	
	private static int qtdClientes;

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

}
