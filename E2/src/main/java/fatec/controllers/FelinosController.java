package fatec.controllers;

import java.io.IOException;
import java.sql.SQLException;

import fatec.classes.Felino;
import fatec.data.dao.FelinoDAO;
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

public class FelinosController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtPeso;

    @FXML
    private CheckBox chkDormir;

    @FXML
    private Button btnCriar;

    @FXML
    private Button btnSom;

    @FXML
    private Button btnArvore;

    @FXML
    private Button btnCacar;
    
    @FXML
    private Button btnVoltar;
    
    @FXML
    private TableView<Felino> viewFelino;

    private Felino felinoSelecionado;

    @FXML
    private TableColumn<Felino, Integer> idColumn;

    @FXML
    private TableColumn<Felino, String> nomeColumn;

    @FXML
    private TableColumn<Felino, Integer> idadeColumn;
    
    @FXML
    private TableColumn<Felino, Double> pesoColumn;

    @FXML
    private TableColumn<Felino, Boolean> dormirColumn;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        idadeColumn.setCellValueFactory(new PropertyValueFactory<>("idade"));
        pesoColumn.setCellValueFactory(new PropertyValueFactory<>("peso"));
        dormirColumn.setCellValueFactory(new PropertyValueFactory<>("gostaDeDormir"));

        dormirColumn.setCellFactory(column -> new TableCell<Felino, Boolean>() {
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

        boolean gostaDeDormir = chkDormir.isSelected();

        Felino felino = new Felino(nome, idade, peso, gostaDeDormir);
        try {
            FelinoDAO.create(felino);
            preencherTableView();
            LimparCampos();
            mbox.ShowMessageBox("Sucesso", "Felino criado!");
        } catch (Exception e) {
            mbox.ShowError("Ocorreu um erro ao criar o felino");
        }
    }

    @FXML
    public void SomOnAction() {
        if (Verificar()) {
            String title = felinoSelecionado.FazerSom();
            String gifPath = getClass().getResource("/gifs/felino-som.gif").toExternalForm();
            String soundPath = getClass().getResource("/sounds/felino-som.mp3").toExternalForm();

            mbox.ReproduzirSom(soundPath);
            mbox.ShowGifMessageBox(title, gifPath);
        }
    }

    @FXML
    public void ArvoreOnAction() {
        if (Verificar()) {
            String title = felinoSelecionado.EscalarArvore();
            String gifPath = getClass().getResource("/gifs/felino-arvore.gif").toExternalForm();
            mbox.ShowGifMessageBox(title, gifPath);
        }
    }

    @FXML
    public void CacarOnAction() {
        if (Verificar()) {
            String title = felinoSelecionado.CacaPresas();
            String gifPath = getClass().getResource("/gifs/felino-cacar.gif").toExternalForm();
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

        boolean gostaDeDormir = chkDormir.isSelected();

        Felino felino = new Felino(felinoSelecionado.getId(), nome, idade, peso, gostaDeDormir);
        try {
            FelinoDAO.update(felino);
            preencherTableView();
            LimparCampos();
            mbox.ShowMessageBox("Sucesso", "Felino editado!");
        } catch (Exception e) {
            mbox.ShowError("Ocorreu um erro ao editar o felino selecionado");
        }
    }

    @FXML
    public void ExcluirOnAction() throws SQLException {
        try {
            FelinoDAO.delete(felinoSelecionado.getId());
            preencherTableView();
            LimparCampos();
            mbox.ShowMessageBox("Sucesso", "Felino excluído!");
        } catch (Exception e) {
            mbox.ShowError("Ocorreu um erro ao excluir o felino selecionado");
        }
    }

    private boolean Verificar() {
        if (felinoSelecionado == null) {
            mbox.ShowMessageBox("Erro", "Por favor, selecione um felino primeiro.");
            return false;
        }
        return true;
    }

    private void preencherTableView() {
        try {
            viewFelino.setItems(FXCollections.observableArrayList(FelinoDAO.getAll()));
        } catch (SQLException e) {
            System.out.println("Erro ao preencher a TableView com Felinos: " + e.getMessage());
        }
    }

    @FXML
    public void clickTableView() {
        felinoSelecionado = viewFelino.getSelectionModel().getSelectedItem();
        txtNome.setText(felinoSelecionado.getNome());
        txtIdade.setText(String.valueOf(felinoSelecionado.getIdade()));
        txtPeso.setText(String.valueOf(felinoSelecionado.getPeso()));
        chkDormir.setSelected(felinoSelecionado.isGostaDeDormir());
    }

    @FXML
    private void LimparCampos() {
        txtNome.setText("");
        txtIdade.setText("");
        txtPeso.setText("");
        chkDormir.setSelected(false);
    }
}
