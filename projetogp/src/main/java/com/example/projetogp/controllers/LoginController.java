package com.example.projetogp.controllers;

import com.example.projetogp.MainApplication;
import com.example.projetogp.db.BancoDeDados;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController implements BancoDeDados {

    @FXML
    public void onRegisterAction() {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Sinup-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 500, 400);
            Stage stage = new Stage();
            stage.setTitle("Cadastrar usuario");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    TextField emailLogin;

    @FXML
    TextField senhaLogin;

    @FXML
    Label errorLabel;

    @FXML
    ImageView loginImage;


    @FXML
    public void onLoginAction() {

        Connection connection = BancoDeDados.Conexao();
        boolean loginValidacao = BancoDeDados.cosultarLogin(connection, emailLogin.getText(), senhaLogin.getText());

        if (loginValidacao){
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Home-view.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
                Stage stage = new Stage();
                stage.setScene(scene);
                HomeController homeController = fxmlLoader.getController();
                int id = BancoDeDados.consultarId(connection, emailLogin.getText());
                homeController.setIdUser(id);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            }
        else {
            errorLabel.setText("Email ou Senha incorreto");
        }
    }

}