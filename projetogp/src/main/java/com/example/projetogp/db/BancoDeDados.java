package com.example.projetogp.db;

import com.example.projetogp.controllers.HomeController;

import java.sql.*;

public interface BancoDeDados {
    public static Connection Conexao(){
        try {
            Connection connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1232");
            if (connexion != null){
                System.out.println("Conaxão Realizada");
                return connexion;
            }

        }
        catch (SQLException e){
            throw new RuntimeException(e.getMessage());

        }
        return null;
    }
    public static boolean cosultarLogin(Connection connection, String email, String senha){
        String sql = "select id, email, senha from administrador where email = ? and senha = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                if (result.getString("email").equals(email)) {
                    return true;
                }
            }
        }
        catch (SQLException e){
            System.out.println("erro");
            e.printStackTrace();
        }



        return false;
    }
    public static int consultarId(Connection connection, String email){
        try {
            String sql = "select id from administrador where email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet =  preparedStatement.executeQuery();
            int id = 0;
            while (resultSet.next()){
                id = resultSet.getInt("id");
            }
            return id;
        }
        catch (SQLException e){
            e.printStackTrace();
        }


        return 0;
    }

    public static ResultSet ConsultarRepresentantesTodos(Connection connection, int adminId) throws SQLException {
        String sql = "select * from representantes where admin_id = ?" ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, adminId);
        ResultSet result = preparedStatement.executeQuery();
        return result;
    }


}
