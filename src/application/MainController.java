package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainController {

	@FXML
    private Button btnClientes;

    @FXML
    private Button btnPedidos;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnConfig;

    @FXML
    private Text close;

    @FXML
    void userConfig(ActionEvent event) {
    	Config config = new Config();
    	closeTela();
    	config.start(new Stage());
    }

    @FXML
    void verClientes(ActionEvent event) {
    	Clientes cli = new Clientes();
    	closeTela();
    	try {
			cli.start(new Stage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

    @FXML
    void verPedidos(ActionEvent event) {
    	Pedidos ped = new Pedidos();
    	closeTela();
    	try {
			ped.start(new Stage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

    @FXML
    void verProdutos(ActionEvent event) {
    	Produtos prod = new Produtos();
    	closeTela();
    	try {
			prod.start(new Stage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
    
    void closeTela() {
    	Main.getStage().close();
    }
        
}
