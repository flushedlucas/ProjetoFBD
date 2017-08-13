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
import projetofbd.Infra.Conexao;
import projetofbd.Model.Artigo;

/**
 *
 * @author lucas
 */
public class ArtigoDAO {
    ResultSet resultSet = null;
    public void create(Artigo artigo) {
        String sql = "INSERT INTO artigo (titulo, pag_inicial, pag_final, ano, "
                + "volume, numero, cod_revista, nome_congresso, cidade_congresso, "
                + "data_congresso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = null;
        try {
            statement = Conexao.abrir().prepareStatement(sql);
            statement.setString(1, artigo.getTitulo());
            statement.setInt(2, artigo.getPag_Inicial());
            statement.setInt(3, artigo.getPag_final());
            statement.setDate(4, artigo.getAno());
            statement.setInt(5, artigo.getVolume());
            statement.setInt(6, artigo.getNumero());
            statement.setInt(7, artigo.getCod_Revista());
            statement.setString(8, artigo.getNome_Congresso());
            statement.setString(9, artigo.getCidade_congresso());
            statement.setDate(10, artigo.getData_congresso());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Artigo> read(){
        String sql = "SELECT * FROM artigo";

        ArrayList<Artigo> revistaArrayList = new ArrayList<Artigo>();
        try {
            Statement statement = Conexao.abrir().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()){
                Artigo artigo = new Artigo();
                artigo.setCod_Artigo(resultSet.getInt("cod_artigo"));
                artigo.setTitulo(resultSet.getString("titulo"));
                artigo.setPag_Inicial(resultSet.getInt("pag_inicial"));
                artigo.setPag_final(resultSet.getInt("pag_final"));
                artigo.setAno(resultSet.getDate("ano"));
                artigo.setVolume(resultSet.getInt("volume"));
                artigo.setNumero(resultSet.getInt("numero"));
                artigo.setCod_Revista(resultSet.getInt("cod_revista"));
                artigo.setNome_Congresso(resultSet.getString("nome_congresso"));
                artigo.setCidade_congresso(resultSet.getString("cidade_congresso"));
                artigo.setData_congresso(resultSet.getDate("data_congresso"));

                revistaArrayList.add(artigo);
            }
        } catch (Exception e) {

        }
           return revistaArrayList;
    }
    
    
    public ResultSet read(Artigo artigo) {
    String sql = "select * from artigo where titulo like ?";
        PreparedStatement statement;
        try {
            statement = Conexao.abrir().prepareCall(sql);
            //passando o conteudo  da caixa de texto para o ?
            //atenção ao % - continuação da string sql
            statement.setString(1,"%" + artigo.getTitulo() + "%");
//            System.out.println(statement);
            resultSet = statement.executeQuery();
//            System.out.println(resultSet);
            
            return resultSet;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
       }return resultSet;
    }
    
    public int update(Artigo artigo){
        String sql = "UPDATE pesquisador SET cod_arigo=?, titulo=?, pag_inicial=?"
                + ", pag_final=?, ano=?, volume=?, numero=?, cod_revista=?, nome_congresso=?"
                + ", cidade_congresso=?, data_congresso=? WHERE cod_artigo=?";
        
        int adicionado = 0;
        PreparedStatement statement = null;
        try {
            statement = Conexao.abrir().prepareStatement(sql);
            statement.setString(1, artigo.getTitulo());
            statement.setInt(2, artigo.getPag_Inicial());
            statement.setInt(3, artigo.getPag_final());
            statement.setDate(4, artigo.getAno());
            statement.setInt(5, artigo.getVolume());
            statement.setInt(6, artigo.getNumero());
            statement.setInt(7, artigo.getCod_Revista());
            statement.setString(8, artigo.getNome_Congresso());
            statement.setString(9, artigo.getCidade_congresso());
            statement.setDate(10, artigo.getData_congresso());
            statement.executeUpdate();
            return adicionado;         
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adicionado;
    }

    public void delete(Artigo artigo){
        String sql = "DELETE FROM artigo WHERE titulo=?";

        PreparedStatement statement = null;

        try {
            statement = Conexao.abrir().prepareStatement(sql);
            statement.setString(1, artigo.getTitulo());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
