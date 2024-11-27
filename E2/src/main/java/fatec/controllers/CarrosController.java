package fatec.controllers;

import java.io.IOException;
import java.sql.SQLException;

import fatec.classes.Carro;
import fatec.data.dao.CarroDAO;
import fatec.utils.mbox;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CarrosController {

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtAno;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtPortas;

    @FXML
    private Button btnCriar;

    @FXML
    private Button btnAcelerar;

    @FXML
    private Button btnFrear;

    @FXML
    private Button btnPorta;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnExcluir;

    @FXML
    private TableView<Carro> viewCarro;

    private Carro carroSelecionado;

    @FXML
    private TableColumn<Carro, Integer> idColumn;

    @FXML
    private TableColumn<Carro, String> marcaColumn;

    @FXML
    private TableColumn<Carro, String> modeloColumn;

    @FXML
    private TableColumn<Carro, Integer> anoColumn;

    @FXML
    private TableColumn<Carro, Double> pesoColumn;

    @FXML
    private TableColumn<Carro, Integer> portasColumn;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        marcaColumn.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modeloColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        anoColumn.setCellValueFactory(new PropertyValueFactory<>("ano"));
        pesoColumn.setCellValueFactory(new PropertyValueFactory<>("peso"));
        portasColumn.setCellValueFactory(new PropertyValueFactory<>("portas"));

        preencherTableView();
    }

    @FXML
    public void CriarOnAction() {
        String marca = txtMarca.getText();
        if (marca.isEmpty()) {
            mbox.ShowMessageBox("Erro", "Marca não pode ser vazia!");
            return;
        }

        String modelo = txtModelo.getText();
        if (modelo.isEmpty()) {
            mbox.ShowMessageBox("Erro", "Modelo não pode ser vazio!");
            return;
        }

        int ano;
        try {
            ano = Integer.parseInt(txtAno.getText());
        } catch (NumberFormatException e) {
            mbox.ShowMessageBox("Erro", "Ano inválido!");
            return;
        }

        double peso;
        try {
            peso = Double.parseDouble(txtPeso.getText());
        } catch (NumberFormatException e) {
            mbox.ShowMessageBox("Erro", "Peso inválido!");
            return;
        }

        int portas;
        try {
            portas = Integer.parseInt(txtPortas.getText());
        } catch (NumberFormatException e) {
            mbox.ShowMessageBox("Erro", "Número de portas inválido!");
            return;
        }

        carroSelecionado = new Carro(marca, modelo, ano, peso, portas);
        try {
            CarroDAO.create(carroSelecionado);
            mbox.ShowMessageBox("Sucesso", "Carro criado!");
            preencherTableView();
            LimparCampos();
        } catch (SQLException e) {
            mbox.ShowError("Erro ao criar o carro");
        }
    }

    @FXML
    public void AcelerarOnAction() {
        if (Verificar()) {
            String title = carroSelecionado.Acelerar();
            String gifPath = getClass().getResource("/gifs/carro-acelerar.gif").toExternalForm();
            mbox.ShowGifMessageBox(title, gifPath);
        }
    }

    @FXML
    public void FrearOnAction() {
        if (Verificar()) {
            String title = carroSelecionado.Frear();
            String gifPath = getClass().getResource("/gifs/carro-frear.gif").toExternalForm();
            mbox.ShowGifMessageBox(title, gifPath);
        }
    }

    @FXML
    public void PortaOnAction() {
        if (Verificar()) {
            String title = carroSelecionado.AbrirPorta();
            String gifPath = getClass().getResource("/gifs/carro-porta.gif").toExternalForm();
            mbox.ShowGifMessageBox(title, gifPath);
        }
    }

    @FXML
    public void VoltarOnAction() throws IOException {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/views/inicial-view.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void EditarOnAction() throws SQLException {
        if (Verificar()) {
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            int ano = Integer.parseInt(txtAno.getText());
            double peso = Double.parseDouble(txtPeso.getText());
            int portas = Integer.parseInt(txtPortas.getText());

            Carro carro = new Carro(carroSelecionado.getId(), marca, modelo, ano, peso, portas);
            CarroDAO.update(carro);
            mbox.ShowMessageBox("Sucesso", "Carro editado!");
            preencherTableView();
            LimparCampos();
        }
    }

    @FXML
    public void ExcluirOnAction() throws SQLException {
        if (Verificar()) {
            CarroDAO.delete(carroSelecionado.getId());
            mbox.ShowMessageBox("Sucesso", "Carro excluído!");
            preencherTableView();
            LimparCampos();
        }
    }

    private boolean Verificar() {
        if (carroSelecionado == null) {
            mbox.ShowMessageBox("Erro", "Por favor, selecione um carro primeiro.");
            return false;
        }
        return true;
    }

    private void preencherTableView() {
        try {
            viewCarro.setItems(FXCollections.observableArrayList(CarroDAO.getAll()));
        } catch (SQLException e) {
            System.out.println("Erro ao preencher a TableView com Carros: " + e.getMessage());
        }
    }

    @FXML
    public void clickTableView() {
        carroSelecionado = viewCarro.getSelectionModel().getSelectedItem();
        if (carroSelecionado != null) {
            txtMarca.setText(carroSelecionado.getMarca());
            txtModelo.setText(carroSelecionado.getModelo());
            txtAno.setText(String.valueOf(carroSelecionado.getAno()));
            txtPeso.setText(String.valueOf(carroSelecionado.getPeso()));
            txtPortas.setText(String.valueOf(carroSelecionado.getQuantidadePortas()));
        }
    }

    @FXML
    private void LimparCampos() {
        txtMarca.setText("");
        txtModelo.setText("");
        txtAno.setText("");
        txtPeso.setText("");
        txtPortas.setText("");
    }
}
