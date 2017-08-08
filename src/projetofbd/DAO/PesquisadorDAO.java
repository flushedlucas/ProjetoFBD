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
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import projetofbd.Infra.Conexao;
import projetofbd.Model.Pesquisador;

/**
 *
 * @author lucas
 */
public class PesquisadorDAO {
    ResultSet resultSet = null;
    public void crate(Pesquisador pesquisador) {
        String sql = "INSERT INTO pesquisador (nome_pesq) VALUES (?)";

        PreparedStatement statement = null;
        try {
            statement = Conexao.abrir().prepareStatement(sql);
            statement.setString(1, pesquisador.getNome_Pesq());
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
    
    
    public ResultSet consultar(Pesquisador pesquisador) {
    String sql = "select cod_pesq Número, nome_pesq Nome from pesquisador where nome_pesq like ?";
        PreparedStatement statement;
        try {
            System.out.println(pesquisador.getNome_Pesq());
            statement = Conexao.abrir().prepareCall(sql);
            //passando o conteudo  da caixa de texto para o ?
            //atenção ao % - continuação da string sql
            statement.setString(1,pesquisador.getNome_Pesq()+ "%");
//            System.out.println(statement);
            resultSet = statement.executeQuery();
//            System.out.println(resultSet);
            
            return resultSet;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
       }return resultSet;
    }
    
    public int update(Pesquisador pesquisador){
        String sql = "UPDATE pesquisador SET cod_pesq=?, nome_pesq=? WHERE nome_pesq=?";
        
        int adicionado = 0;
        PreparedStatement statement = null;
        try {
            statement = Conexao.abrir().prepareStatement(sql);
            statement.setInt(1, pesquisador.getCod_Pesq());
            statement.setString(2, pesquisador.getNome_Pesq());
//          statement.setString(3, atualizar);
            adicionado = statement.executeUpdate();
            return adicionado;         
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adicionado;
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
