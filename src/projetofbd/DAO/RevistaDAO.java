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
import projetofbd.Model.Revista;

/**
 *
 * @author lucas
 */
public class RevistaDAO {

    ResultSet resultSet = null;

    public int create(Revista revista) {
        String sql = "INSERT INTO revista_cientifica (cod_revista, nome, editora, issn) VALUES (?, ?, ?, ?)";
        int add = 0;
        try {
            PreparedStatement statement = Conexao.abrir().prepareStatement(sql);
            statement.setInt(1, revista.getCod_Revista());
            statement.setString(2, revista.getNome_Revista());
            statement.setString(3, revista.getEditora());
            statement.setString(4, revista.getISSN());

            add = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return add;
    }

    public ArrayList<Revista> read() {
        String sql = "SELECT * FROM revista_cientifica";

        ArrayList<Revista> revistaArrayList = new ArrayList<Revista>();
        try {
            Statement statement = Conexao.abrir().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Revista revista = new Revista();
                revista.setCod_Revista(resultSet.getInt("cod_revista"));
                revista.setNome_Revista(resultSet.getString("nome"));
                revista.setEditora(resultSet.getString("editora"));
                revista.setISSN(resultSet.getString("issn"));

                revistaArrayList.add(revista);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return revistaArrayList;

    }

    public ResultSet read(Revista revista) {
        String sql = "select cod_revista Número, nome Nome, editora Editora, issn ISSN from revista_cientifica where nome like ?";
        PreparedStatement statement;

        try {
//            System.out.println(revista.getNome_Revista());
            statement = Conexao.abrir().prepareCall(sql);
            //passando o conteudo  da caixa de texto para o ?
            //atenção ao % - continuação da string sql
            statement.setString(1, "%" + revista.getNome_Revista() + "%");
//            System.out.println(statement);
            resultSet = statement.executeQuery();
//            System.out.println(resultSet);

            return resultSet;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return resultSet;
    }
    
    public int  read(String revista) {
        String sql = "select nome from revista_cientifica where nome like ?";
        PreparedStatement statement;
        int existe = 0;
        String nome = null;
        int cont = 0;
        try {
//            System.out.println(pesquisador.getNome_Pesq());
            statement = Conexao.abrir().prepareCall(sql);
            //passando o conteudo  da caixa de texto para o ?
            //atenção ao % - continuação da string sql
            statement.setString(1, "%" + revista+ "%");
//            System.out.println(statement);
            resultSet = statement.executeQuery();
//            System.out.println(resultSet);
            while (resultSet.next()) {
                nome= String.valueOf(resultSet.getString("nome"));
                cont =  nome.length();
            }                 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return cont;
    }

    public int update(Revista revista) {
        String sql = "UPDATE revista_cientifica SET cod_revista=?, nome=?, editora=?, issn=? WHERE cod_revista=?";
        int edt = 0;
        try {
            PreparedStatement statement = Conexao.abrir().prepareStatement(sql);

            statement.setInt(1, revista.getCod_Revista());
            statement.setString(2, revista.getNome_Revista());
            statement.setString(3, revista.getEditora());
            statement.setString(4, revista.getISSN());
            statement.setInt(5, revista.getCod_Revista());

            edt = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return edt;
    }

    public int delete(Revista revista) {
        String sql = "DELETE FROM revista_cientifica WHERE cod_revista=?";
        int remove = 0;
        try {
            PreparedStatement statement = Conexao.abrir().prepareStatement(sql);
            statement.setInt(1, revista.getCod_Revista());

            remove = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remove;
    }

}
