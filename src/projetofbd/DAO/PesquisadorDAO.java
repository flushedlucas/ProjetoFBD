/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofbd.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import projetofbd.Infra.Conexao;
import projetofbd.Model.Pesquisador;

/**
 *
 * @author lucas
 */
public class PesquisadorDAO {
    
    public void crate(Pesquisador pesquisador) {
        String sql = "INSERT INTO pesquisador (cod_pesq, nome_pesq) VALUES (?, ?)";

        PreparedStatement statement = null;
        try {
            statement = Conexao.abrir().prepareStatement(sql);
            statement.setInt(1, pesquisador.getCod_Pesq());
            statement.setString(2, pesquisador.getNome_Pesq());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read(){
        String sql = "SELECT * FROM pesquisador";

        try {
            Statement statement = Conexao.abrir().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Pesquisador> pesquisadorArrayList = new ArrayList<Pesquisador>();

            while (resultSet.next()){
                Pesquisador pesquisador = new Pesquisador();
                pesquisador.setCod_Pesq(resultSet.getInt("cod_pesq"));
                pesquisador.setNome_Pesq(resultSet.getString("nome_pesq"));
                pesquisadorArrayList.add(pesquisador);
            }
        } catch (Exception e) {

        }

    }

    public void update(Pesquisador pesquisador, String atualizar){
        String sql = "UPDATE pesquisador SET cod_pesq=?, nome_pesq=? WHERE nome_pesq=?";

        PreparedStatement statement = null;
        try {
            statement = Conexao.abrir().prepareStatement(sql);
            statement.setInt(1, pesquisador.getCod_Pesq());
            statement.setString(2, pesquisador.getNome_Pesq());
            statement.setString(3, atualizar);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(Pesquisador pesquisador){
        String sql = "DELETE FROM pesquisador WHERE nome_pesq=?";

        PreparedStatement statement = null;

        try {
            statement = Conexao.abrir().prepareStatement(sql);
            statement.setString(1, pesquisador.getNome_Pesq());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
