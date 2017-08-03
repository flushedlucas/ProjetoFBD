/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofbd.Infra;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lucas
 */
public class Conexao {
    
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://localhost:3306/publicacoes?useTimezone=true&serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.jdbc.Driver"; 
    
//    Conectar ao banco
    public static Connection abrir() throws Exception{
//        Registra o Driver
        Class.forName(DRIVER);

//        Captura a Conexão
        Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);

//        Retorna a Conexão Aberta
        return  connection;
    }
    
}
