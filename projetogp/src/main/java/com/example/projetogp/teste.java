package com.example.projetogp;

import com.example.projetogp.db.BancoDeDados;

import java.sql.Connection;

public class teste implements BancoDeDados {
    public static void teste(){
        Connection connection = BancoDeDados.Conexao();
    }
}
