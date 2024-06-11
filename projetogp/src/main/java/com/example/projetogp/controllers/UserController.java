package com.example.projetogp.controllers;

import com.example.projetogp.db.BancoDeDados;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.sql.*;

public class UserController implements Serializable, BancoDeDados {

    @FXML
    TextField textfiledEmail;

    @FXML
    TextField textfieldPassword;

    @FXML
    TextField textFieldNome;

    @FXML
    TextField textFieldDatan;

    @FXML
    TextField textFieldCidaden;

    @FXML
    TextField textFieldNacionalidade;

    @FXML
    TextField textFieldRG;

    @FXML
    TextField textFieldCPF;

    @FXML
    TextField textFieldTENumero;

    @FXML
    TextField textFieldTEMunicipio;

    @FXML
    TextField textFieldTEDataEmissao;

    @FXML
    TextField textFieldEnderecoCEP;

    @FXML
    TextField textFieldEnderecoRua;

    @FXML
    TextField textFieldEnderecoBairro;

    @FXML
    TextField textFieldEnderecoCidade;

    @FXML
    TextField textFieldEnderecoEstado;

    @FXML
    TextField textFieldNE;

    @FXML
    TextField textFieldPP;

    @FXML
    TextField textFieldNP;

    @FXML
    TextField textFieldCargo;





    @FXML
    public void onSaveAction(){
        Connection connection = BancoDeDados.Conexao();
        String sql = "INSERT INTO administrador (nome, data_de_nascimento, email, senha, municipio_de_nascimento, pais, rg, cpf, te_numero, te_municipio, te_data_de_emissao," +
                "nivel_escolar, cep, rua, bairro, cidade, estado, partido_politico, numero_politico, cargo)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";



        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println("checkpoint");
            preparedStatement.setString(1, textFieldNome.getText());
            Date dataNascimento = Date.valueOf(textFieldDatan.getText());
            preparedStatement.setDate(2, dataNascimento);
            preparedStatement.setString(3, textfiledEmail.getText());
            preparedStatement.setString(4, textfieldPassword.getText());
            preparedStatement.setString(5, textFieldCidaden.getText());
            preparedStatement.setString(6, textFieldNacionalidade.getText());
            preparedStatement.setString(7, textFieldRG.getText());
            preparedStatement.setString(8, textFieldCPF.getText());
            int teNumero = Integer.parseInt(textFieldTENumero.getText());
            preparedStatement.setInt(9, teNumero);
            preparedStatement.setString(10, textFieldTEMunicipio.getText());
            Date dataDeEmissao = Date.valueOf(textFieldTEDataEmissao.getText());
            preparedStatement.setDate(11, dataDeEmissao);
            preparedStatement.setString(12, textFieldNE.getText());
            preparedStatement.setString(13, textFieldEnderecoCEP.getText());
            preparedStatement.setString(14, textFieldEnderecoRua.getText());
            preparedStatement.setString(15, textFieldEnderecoBairro.getText());
            preparedStatement.setString(16, textFieldEnderecoCidade.getText());
            preparedStatement.setString(17, textFieldEnderecoEstado.getText());
            preparedStatement.setString(18, textFieldPP.getText());
            int nP = Integer.parseInt(textFieldNP.getText());
            preparedStatement.setInt(19, nP);
            preparedStatement.setString(20, textFieldCargo.getText());
            preparedStatement.executeQuery();
            System.out.println("Cadastrado com sucesso");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
