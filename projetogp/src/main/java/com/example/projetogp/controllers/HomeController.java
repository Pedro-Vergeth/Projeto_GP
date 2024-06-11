package com.example.projetogp.controllers;

import com.example.projetogp.MainApplication;
import com.example.projetogp.TabelaRepresenantes;
import com.example.projetogp.db.BancoDeDados;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class HomeController implements BancoDeDados{
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @FXML
    public void telaSolicitacao(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Solicitacoes-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    Label listaRepresentantes;



    int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @FXML
    public void telaRepresentante(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Representantes-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            atualizarTabelaRepresentantes();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void atualizarTabelaRepresentantes() throws SQLException {
        Connection connection = BancoDeDados.Conexao();
        String quebralinha = System.lineSeparator();
        String lista = String.valueOf(new StringBuilder("Nome Completo | CPF | Email | Area De Atuação | Data de Inicio" + quebralinha));
        ResultSet result = BancoDeDados.ConsultarRepresentantesTodos(connection, 1);
        while (result.next()){
            String dataI = String.valueOf(result.getDate("data_inicio"));
            String completa = result.getString("nome") + " | " + result.getString("cpf") + " | " + result.getString("email") + " | " + result.getString("aa_bairro") + " | " + dataI + " | " + quebralinha;
            lista = String.valueOf(new StringBuilder(lista + completa));
        }
        listaRepresentantes.setText(lista);

    }

    @FXML
    public void telaRelatorio(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Relatorio-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
