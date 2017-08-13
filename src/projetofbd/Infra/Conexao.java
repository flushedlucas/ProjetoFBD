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
    private static final String SENHA = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/publicacoes?useTimezone=true&serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.jdbc.Driver"; 
    private static Connection connection= null;
//    Conectar ao banco
    public static Connection abrir(){
//        Registra o Driver
        try{
        Class.forName(DRIVER);
//        Captura a Conexão
        connection = DriverManager.getConnection(URL, USUARIO, SENHA);
//        Retorna a Conexão Aberta
        return  connection;
        } catch(Exception e){
           System.out.println("O ERRO É:"+ e ); 
           return null; 
        }
    }
    
}
