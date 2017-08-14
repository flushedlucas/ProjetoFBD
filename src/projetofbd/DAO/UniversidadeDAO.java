/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofbd.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import projetofbd.Infra.Conexao;
import projetofbd.Model.Universidade;

/**
 *
 * @author lucas
 */
public class UniversidadeDAO {
    ResultSet resultSet = null;
    
    public void create(Universidade universidade){
    String sql = "INSERT INTO universidade (nome, sigla, uf) VALUES (?, ?, ?)";

        PreparedStatement statement = null;
        try {
            statement = Conexao.abrir().prepareStatement(sql);
            statement.setString(1, universidade.getNome_Univer());
            statement.setString(2, universidade.getSigla());
            statement.setString(3, universidade.getUF());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
