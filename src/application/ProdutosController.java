package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProdutosController {

    @FXML
    private Button btnCadProd;

    @FXML
    private Button btnUpdProd;

    @FXML
    private Button btnVerProd;

    @FXML
    private Button btnExcProd;

    @FXML
    private Button btnVoltarProd;

    @FXML
    void initCadProduto(ActionEvent event) {
    	CadProdutos cadProd = new CadProdutos();
    	fecharTela();
    	cadProd.start(new Stage());
    }

    @FXML
    void initExcProduto(ActionEvent event) {
    	ExcProdutos excProd = new ExcProdutos();
    	fecharTela();
    	excProd.start(new Stage());
    }

    @FXML
    void initUpdProduto(ActionEvent event) {
    	UpdProdutos updProd = new UpdProdutos();
    	fecharTela();
    	updProd.start(new Stage());
    }

    @FXML
    void visuProduto(ActionEvent event) {
    	VerProdutos verProd = new VerProdutos();
    	fecharTela();
    	verProd.start(new Stage());
    }

    @FXML
    void voltarHaitatsu(ActionEvent event) {
    	Main main = new Main();
    	fecharTela();
    	main.start(new Stage());
    }
    
    void fecharTela() {
      	Produtos.getStage().close();
    }

}