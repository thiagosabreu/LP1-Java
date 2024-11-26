package fatec.controllers;

import java.io.IOException;
import java.sql.SQLException;

import fatec.classes.Aquatico;
import fatec.data.dao.AquaticoDAO;
import fatec.utils.mbox;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AquaticosController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtPeso;

    @FXML
    private CheckBox chkSalgada;

    @FXML
    private Button btnCriar;

    @FXML
    private Button btnSom;

    @FXML
    private Button btnNadar;

    @FXML
    private Button btnMergulhar;
    @FXML
    private Button btnVoltar;
    @FXML
    private TableView<Aquatico> viewAquatico;

    private Aquatico aquaticoSelecionado;

    @FXML
    private TableColumn<Aquatico, Integer> idColumn;

    @FXML
    private TableColumn<Aquatico, String> nomeColumn;

    @FXML
    private TableColumn<Aquatico, Integer> idadeColumn;
    @FXML
    private TableColumn<Aquatico, Double> pesoColumn;

    @FXML
    private TableColumn<Aquatico, Boolean> aguaSalgadaColumn;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        idadeColumn.setCellValueFactory(new PropertyValueFactory<>("idade"));
        pesoColumn.setCellValueFactory(new PropertyValueFactory<>("peso"));
        aguaSalgadaColumn.setCellValueFactory(new PropertyValueFactory<>("viveEmAguasSalgadas"));

        aguaSalgadaColumn.setCellFactory(column -> new TableCell<Aquatico, Boolean>() {
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item ? "Sim" : "Não");
                }
            }
        });

        preencherTableView();
    }

    @FXML
    public void CriarOnAction() {
        String nome = txtNome.getText();
        if (nome.isEmpty()) {
            mbox.ShowMessageBox("Erro", "Nome não pode ser vazio!");
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(txtIdade.getText());
        } catch (NumberFormatException e) {
            mbox.ShowMessageBox("Erro", "Idade inválida!");
            return;
        }

        double peso;
        try {
            peso = Double.parseDouble(txtPeso.getText());
        } catch (NumberFormatException e) {
            mbox.ShowMessageBox("Erro", "Peso inválido!");
            return;
        }

        boolean aguaSalgada = chkSalgada.isSelected();

        Aquatico aquatico = new Aquatico(nome, idade, peso, aguaSalgada);
        try {
            AquaticoDAO.create(aquatico);
            preencherTableView();
            LimparCampos();
            mbox.ShowMessageBox("Sucesso", "Animal aquático criado!");
        } catch (Exception e) {
            mbox.ShowError("Ocorreu um erro ao criar animal aquático");
        }
    }

    @FXML
    public void SomOnAction() {
        if (Verificar()) {
            String title = aquaticoSelecionado.FazerSom();
            String gifPath = getClass().getResource("/gifs/aquatico-som.gif").toExternalForm();
            String soundPath = getClass().getResource("/sounds/golfinho-som.mp3").toExternalForm();

            mbox.ReproduzirSom(soundPath);
            mbox.ShowGifMessageBox(title, gifPath);
        }
    }

    @FXML
    public void NadarOnAction() {
        if (Verificar()) {
            String title = aquaticoSelecionado.Nadar();
            String gifPath = getClass().getResource("/gifs/aquatico-nadar.gif").toExternalForm();
            mbox.ShowGifMessageBox(title, gifPath);
        }
    }

    @FXML
    public void MergulharOnAction() {
        if (Verificar()) {
            String title = aquaticoSelecionado.Mergulhar();
            String gifPath = getClass().getResource("/gifs/aquatico-mergulhar.gif").toExternalForm();
            mbox.ShowGifMessageBox(title, gifPath);
        }
    }

    @FXML
    public void VoltarOnAction() {
        try {
            Stage stage = (Stage) btnVoltar.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/views/inicial-view.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void EditarOnAction() throws SQLException {
        String nome = txtNome.getText();
        if (nome.isEmpty()) {
            mbox.ShowMessageBox("Erro", "Nome não pode ser vazio!");
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(txtIdade.getText());
        } catch (NumberFormatException e) {
            mbox.ShowMessageBox("Erro", "Idade inválida!");
            return;
        }

        double peso;
        try {
            peso = Double.parseDouble(txtPeso.getText());
        } catch (NumberFormatException e) {
            mbox.ShowMessageBox("Erro", "Peso inválido!");
            return;
        }

        boolean aguaSalgada = chkSalgada.isSelected();

        Aquatico aquatico = new Aquatico(aquaticoSelecionado.getId(), nome, idade, peso, aguaSalgada);
        try {
            AquaticoDAO.update(aquatico);
            preencherTableView();
            LimparCampos();
            mbox.ShowMessageBox("Sucesso", "Animal aquático editado!");
        } catch (Exception e) {
            mbox.ShowError("Ocorreu um erro ao editar o animal selecionado");
        }

    }

    @FXML
    public void ExcluirOnAction() throws SQLException {
        try {
            AquaticoDAO.delete(aquaticoSelecionado.getId());
            preencherTableView();
            LimparCampos();
            mbox.ShowMessageBox("Sucesso", "Animal aquático excluido!");
        } catch (Exception e) {
            mbox.ShowError("Ocorreu um erro ao excluir o animal selecionado");
        }
    }

    private boolean Verificar() {
        if (aquaticoSelecionado == null) {
            mbox.ShowMessageBox("Erro", "Por favor, selecione um animal primeiro.");
            return false;
        }
        return true;
    }

    private void preencherTableView() {
        try {
            viewAquatico.setItems(FXCollections.observableArrayList(AquaticoDAO.getAll()));

        } catch (SQLException e) {
            System.out.println("Erro ao preencher a TableView com Aquáticos: " + e.getMessage());
        }
    }

    @FXML
    public void clickTableView() {
        aquaticoSelecionado = viewAquatico.getSelectionModel().getSelectedItem();
        txtNome.setText(aquaticoSelecionado.getNome());
        txtIdade.setText(String.valueOf(aquaticoSelecionado.getIdade()));
        txtPeso.setText(String.valueOf(aquaticoSelecionado.getPeso()));
        chkSalgada.setSelected(aquaticoSelecionado.isViveEmAguasSalgadas());
    }

    @FXML
    private void LimparCampos() {
        txtNome.setText("");
        txtIdade.setText("");
        txtPeso.setText("");
        chkSalgada.setSelected(false);
    }
}
