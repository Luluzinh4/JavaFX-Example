package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConexaoSQL {

	Connection connection = null;
	String sql;
	PreparedStatement stmt = null;
	ResultSet resultado = null;

//	private Connection conectar(Connection cnx) {
//		try {
//			cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
//			System.out.println("Conexão realizada com sucesso");
//			return cnx;
//		} catch (SQLException e) {
//			System.err.println(e.getMessage());
//		}
//		return null;
//	}
//
//	private Connection desconectar(Connection cnx) {
//		if (cnx != null) {
//			try {
//				cnx.close();
//				System.out.println("Conexão finalizada com sucesso");
//				return cnx;
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//			}
//		} else {
//			System.out.println("Não há conexão");
//		}
//		return null;
//	}

	public boolean criar(int num, ArrayList<Object> array) {
		//connection = conectar(connection);
		boolean result = false;

		switch (num) {
		case 1:
			sql = "INSERT INTO Cliente VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try(Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)) {
				//stmt = cnx.prepareStatement(sql);
				stmt.setInt(1, (int) array.get(0));
				stmt.setString(2, (String) array.get(1));
				stmt.setString(3, (String) array.get(2));
				stmt.setString(4, (String) array.get(3));
				stmt.setString(5, (String) array.get(4));
				stmt.setString(6, (String) array.get(5));
				stmt.setString(7, (String) array.get(6));
				stmt.setString(8, (String) array.get(7));
				stmt.setString(9, (String) array.get(8));
				stmt.setString(10, (String) array.get(9));
				stmt.setString(11, (String) array.get(10));
				stmt.setString(12, (String) array.get(11));
				stmt.setString(13, (String) array.get(12));
				stmt.setString(14, (String) array.get(13));
				stmt.setString(15, (String) array.get(14));

				int rows = stmt.executeUpdate();
				cnx.close();
				System.out.println("Inserção realizada com sucesso. " + rows + " linha(s) afetada(s).");
				result = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//result = true;
			break;
		case 2:
			sql = "INSERT INTO Produto VALUES (?,?,?,?,?)";
			
			try(Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)) {
				//stmt = cnx.prepareStatement(sql);
				stmt.setInt(1, (int) array.get(0));
				stmt.setString(2, (String) array.get(1));
				stmt.setString(3, (String) array.get(2));
				stmt.setFloat(4, (float) array.get(3));
				stmt.setInt(5, (int) array.get(4));

				int rows = stmt.executeUpdate();
				cnx.close();
				System.out.println("Inserção realizada com sucesso. " + rows + " linha(s) afetada(s).");
				result = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//result = true;
			break;
		case 3:
			result = true;
			break;
		case 4:
			sql = "INSERT INTO Usuario VALUES (?,?,?,?,?)";
			
			try(Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)) {
				//stmt = cnx.prepareStatement(sql);
				stmt.setInt(1, (int) array.get(0));
				stmt.setString(2, (String) array.get(1));
				stmt.setString(3, (String) array.get(2));
				stmt.setString(4, (String) array.get(3));
				stmt.setString(5, (String) array.get(4));

				int rows = stmt.executeUpdate();
				cnx.close();
				System.out.println("Inserção realizada com sucesso. " + rows + " linha(s) afetada(s).");
				result = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//result = true;
			break;
		default:
			result = false;
			break;
		}

		//connection = desconectar(connection);
		return result;
	}

	public ArrayList<String> selecionar(int num, String cod) {
		//connection = conectar(connection);
		ArrayList<String> resultDados = new ArrayList<>();

		switch (num) {
		case 1:
			sql = "SELECT * FROM Cliente WHERE cod_cliente = ?";
			try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)){
				//stmt = connection.prepareStatement(sql);
				stmt.setString(1, cod);
				resultado = stmt.executeQuery();
				while(resultado.next()) {
					resultDados.add(resultado.getString("nome"));
					resultDados.add(resultado.getString("cpf"));
					resultDados.add(resultado.getString("rg"));
					resultDados.add(resultado.getString("cnpj"));
					resultDados.add(resultado.getString("banco"));
					resultDados.add(resultado.getString("agencia"));
					resultDados.add(resultado.getString("conta"));
					resultDados.add(resultado.getString("logradouro"));
					resultDados.add(resultado.getString("complemento"));
					resultDados.add(resultado.getString("bairro"));
					resultDados.add(resultado.getString("cidade"));
					resultDados.add(resultado.getString("cep"));
					resultDados.add(resultado.getString("telefone"));
					resultDados.add(resultado.getString("email"));
				}
				System.out.println("Consulta realizada com sucesso");
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			sql = "SELECT * FROM Produto WHERE cod_produto = ?";
			try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)){
				//stmt = connection.prepareStatement(sql);
				stmt.setString(1, cod);
				resultado = stmt.executeQuery();
				while(resultado.next()) {
					resultDados.add(resultado.getString("nome_produto"));
					resultDados.add(resultado.getString("descricao"));
					//Float valorUnit = resultado.getFloat("preco");
					//String valorUnit = (String) resultado.getFloat("preco");
					resultDados.add(Float.toString(resultado.getFloat("preco")));
					//resultDados.add((String) resultado.getFloat("preco"));
					resultDados.add(Integer.toString(resultado.getInt("qtd_produto")));
				}
				System.out.println("Consulta realizada com sucesso");
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			sql = "SELECT * FROM Pedido WHERE cod_pedido = ?";
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, cod);
				resultado = stmt.executeQuery();
				System.out.println("Consulta realizada com sucesso");
				//cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			sql = "SELECT * FROM Usuario WHERE cod_usuario = ?";
			try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)) {
				//stmt = connection.prepareStatement(sql);
				stmt.setString(1, cod);
				resultado = stmt.executeQuery();
				while(resultado.next()) {
					resultDados.add(resultado.getString("nome"));
					resultDados.add(resultado.getString("cpf"));
					resultDados.add(resultado.getString("login"));
					resultDados.add(resultado.getString("senha"));
				}
				System.out.println("Consulta realizada com sucesso");
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Consulta não realizada. Código Inválido");
			break;
		}

		//connection = desconectar(connection);
		return resultDados;
	}

	public boolean atualizar(int num, String cod, ArrayList<Object> array) {
		//connection = conectar(connection);
		boolean result = false;

		switch (num) {
		case 1:
			sql = "UPDATE Cliente SET nome = ?, cpf = ?, rg = ?, cnpj = ?, banco = ?, agencia = ?, conta = ?, logradouro = ?, complemento = ?, bairro = ?, cidade = ?, cep = ?, telefone = ?, email = ? WHERE cod_cliente = ?";
 			
			try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)){
				stmt.setString(1, (String) array.get(0));
				stmt.setString(2, (String) array.get(1));
				stmt.setString(3, (String) array.get(2));
				stmt.setString(4, (String) array.get(3));
				stmt.setString(5, (String) array.get(4));
				stmt.setString(6, (String) array.get(5));
				stmt.setString(7, (String) array.get(6));
				stmt.setString(8, (String) array.get(7));
				stmt.setString(9, (String) array.get(8));
				stmt.setString(10, (String) array.get(9));
				stmt.setString(11, (String) array.get(10));
				stmt.setString(12, (String) array.get(11));
				stmt.setString(13, (String) array.get(12));
				stmt.setString(14, (String) array.get(13));
				stmt.setInt(15, Integer.parseInt(cod));
				
				int rows = stmt.executeUpdate();
				cnx.close();
				System.out.println("Atualização realizada com sucesso. " + rows + " linha(s) afetada(s).");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			result = true;
			break;
		case 2:
			sql = "UPDATE Produto SET nome_produto = ?, descricao = ?, preco = ?, qtd_produto = ? WHERE cod_produto = ?";
			
			try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)){
				stmt.setString(1, (String) array.get(0));
				stmt.setString(2, (String) array.get(1));
				stmt.setFloat(3, Float.parseFloat((String) array.get(2)));
				stmt.setInt(4, Integer.parseInt((String) array.get(3)));
				stmt.setInt(5, Integer.parseInt(cod));
				
				int rows = stmt.executeUpdate();
				cnx.close();
				System.out.println("Atualização realizada com sucesso. " + rows + " linha(s) afetada(s).");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			result = true;
			break;
		case 3:
			result = true;
			break;
		case 4:
			sql = "UPDATE Usuario SET nome = ?, cpf = ?, login = ?, senha = ? WHERE cod_usuario = ?";
			
			try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)){
				stmt.setString(1, (String) array.get(0));
				stmt.setString(2, (String) array.get(1));
				stmt.setString(3, (String) array.get(2));
				stmt.setString(4, (String) array.get(3));
				stmt.setInt(5, Integer.parseInt(cod));
				
				int rows = stmt.executeUpdate();
				cnx.close();
				System.out.println("Atualização realizada com sucesso. " + rows + " linha(s) afetada(s).");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			result = true;
			break;
		default:
			result = false;
			break;
		}

		//connection = desconectar(connection);
		return result;
	}

	public boolean deletar(int num, String cod) {
		//connection = conectar(connection);
		boolean result = false;

		switch (num) {
		case 1:
			sql = "DELETE FROM Cliente WHERE cod_cliente = ?";
			try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)) {
				stmt.setString(1, cod);
				int rows = stmt.executeUpdate();
				cnx.close();
				System.out.println("Consulta realizada com sucesso. " + rows + " linha(s) afetada(s).");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			result = true;
			break;
		case 2:
			sql = "DELETE FROM Produto WHERE cod_produto = ?";
			try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)) {
				//stmt = connection.prepareStatement(sql);
				stmt.setString(1, cod);
				int rows = stmt.executeUpdate();
				cnx.close();
				System.out.println("Consulta realizada com sucesso. " + rows + " linha(s) afetada(s).");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			result = true;
			break;
		case 3:
			sql = "DELETE FROM Pedido WHERE cod_pedido = ?";
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, cod);
				int rows = stmt.executeUpdate();
				//cnx.close();
				System.out.println("Consulta realizada com sucesso. " + rows + " linha(s) afetada(s).");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			result = true;
			break;
		case 4:
			sql = "DELETE FROM Usuario WHERE cod_usuario = ?";
			try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)) {
				//stmt = connection.prepareStatement(sql);
				stmt.setString(1, cod);
				int rows = stmt.executeUpdate();
				cnx.close();
				System.out.println("Consulta realizada com sucesso. " + rows + " linhas afetada(s).");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			result = true;
			break;
		default:
			System.out.println("Consulta não realizada. Código Inválido");
			result = false;
			break;
		}

		//connection = desconectar(connection);
		return result;
	}
	
	public int countQtd(int num) {
		int resultado = 0;
		
		switch(num) {
		case 1:
			sql = "SELECT * FROM Cliente WHERE ? = (SELECT MAX(?) FROM Cliente)";
			
			try(Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)) {
				stmt.setString(1, "cod_cliente");
				stmt.setString(2, "cod_cliente");
				ResultSet result = stmt.executeQuery();
				while(result.next()) {
					resultado = result.getInt("cod_cliente");
				}
				cnx.close();
				//int rows = stmt.executeUpdate();
				//System.out.println("Consulta realizada com sucesso. " + rows + "linha(s) afetada(s).");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			sql = "SELECT * FROM Produto WHERE ? = (SELECT MAX(?) FROM Produto)";
			
			try(Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)) {
				stmt.setString(1, "cod_produto");
				stmt.setString(2, "cod_produto");
				ResultSet result = stmt.executeQuery();
				while(result.next()) {
					resultado = result.getInt(1);
				}
				cnx.close();
				//int rows = stmt.executeUpdate();
				//System.out.println("Consulta realizada com sucesso. " + rows + "linha(s) afetada(s).");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			sql = "SELECT * FROM Pedido WHERE ? = (SELECT MAX(?) FROM Pedido)";
			
			try(Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)) {
				stmt.setString(1, "cod_pedido");
				stmt.setString(2, "cod_pedido");
				ResultSet result = stmt.executeQuery();
				while(result.next()) {
					resultado = result.getInt(1);
				}
				cnx.close();
				//int rows = stmt.executeUpdate();
				//System.out.println("Consulta realizada com sucesso. " + rows + "linha(s) afetada(s).");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			sql = "SELECT * FROM Usuario WHERE ? = (SELECT MAX(?) FROM Usuario)";
			
			try(Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)) {
				stmt.setString(1, "cod_usuario");
				stmt.setString(2, "cod_usuario");
				ResultSet result = stmt.executeQuery();
				while(result.next()) {
					resultado = result.getInt(1);
				}
				cnx.close();
				//int rows = stmt.executeUpdate();
				//System.out.println("Consulta realizada com sucesso. " + rows + "linha(s) afetada(s).");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		
		return resultado;
	}
	
	//Método para login
	public boolean realizarLogin(String user, String senhaUser){
		boolean login = false;
		ArrayList<String> resultado = new ArrayList<>();
		
		sql = "SELECT login, senha FROM Usuario WHERE login = ? AND senha = ?";
		try(Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
				PreparedStatement stmt = cnx.prepareStatement(sql)) {
			stmt.setString(1, user);
			stmt.setString(2, senhaUser);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				resultado.add(result.getString("login"));
				resultado.add(result.getString("senha"));
			}
			
			if(!resultado.isEmpty()) {
				login = true;
			}
			
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return login;
	}
	
	public ArrayList<String> carregarCliProd(int num){
		ArrayList<String> resultado = new ArrayList<>();
		Integer codigo;
		
		//sql = "SELECT nome FROM Cliente WHERE cod_cliente < ?";
		
		if(num == 1) {
			codigo = countQtd(1) + 1;
			sql = "SELECT nome FROM Cliente WHERE cod_cliente < ?";
			
			try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)){
				stmt.setString(1, codigo.toString());
				ResultSet result = stmt.executeQuery();
				
				while(result.next()) {
					resultado.add(result.getString("nome"));
				}
				
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			codigo = countQtd(2) + 1;
			sql = "SELECT nome_produto FROM Produto WHERE cod_produto < ?";
			
			try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)){
				stmt.setString(1, codigo.toString());
				ResultSet result = stmt.executeQuery();
				
				while(result.next()) {
					resultado.add(result.getString("nome_produto"));
				}
				
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}
	
	public String transformar(int num, String nome) {
		String resultado = null;
		
		if(num == 1) {
			sql = "SELECT cod_cliente FROM Cliente WHERE nome = ?";
			
			try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)){
				stmt.setString(1, nome);
				ResultSet result = stmt.executeQuery();
				
				while(result.next()) {
					//resultado.add(result.getInt("cod_cliente"));
					Integer codigo = result.getInt("cod_cliente");
					resultado = codigo.toString();
				}
				
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			sql = "SELECT cod_produto FROM Produto WHERE nome_produto = ?";
			
			try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
					PreparedStatement stmt = cnx.prepareStatement(sql)){
				stmt.setString(1, nome);
				ResultSet result = stmt.executeQuery();
				
				while(result.next()) {
					//resultado.add(result.getString("nome_produto"));
					Integer codigo = result.getInt("cod_produto");
					resultado = codigo.toString();
				}
				
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}
	
	public Float consultarValorProduto(String nome) {
		Float resultado = null;
		
		sql = "SELECT preco FROM Produto WHERE nome_produto = ?";
		try (Connection cnx = DriverManager.getConnection("jdbc:sqlite:bancoTeste.db");
				PreparedStatement stmt = cnx.prepareStatement(sql)){
			stmt.setString(1, nome);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				//Float codigo = result.getFloat("preco");
				resultado = result.getFloat("preco");
			}
			
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

}
