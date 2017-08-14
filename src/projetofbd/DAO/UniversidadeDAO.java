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
import projetofbd.Model.Universidade;

/**
 *
 * @author lucas
 */
public class UniversidadeDAO {

    ResultSet resultSet = null;

    public int create(Universidade universidade) {
        String sql = "INSERT INTO universidade (nome, sigla, uf) VALUES (?, ?, ?)";
        int add = 0;
        PreparedStatement statement = null;
        try {
            statement = Conexao.abrir().prepareStatement(sql);
            statement.setString(1, universidade.getNome_Univer());
            statement.setString(2, universidade.getSigla());
            statement.setString(3, universidade.getUF());
            add = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return add;
    }

    public ArrayList<Universidade> read() {
        String sql = "SELECT * FROM univer";

        ArrayList<Universidade> universidadeArrayList = new ArrayList<Universidade>();
        try {
            Statement statement = Conexao.abrir().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Universidade universidade = new Universidade();
                universidade.setCod_Univer(resultSet.getInt("univer"));
                universidade.setNome_Univer(resultSet.getString("nome"));
                universidade.setSigla(resultSet.getString("sigla"));
                universidade.setUF(resultSet.getString("uf"));

                universidadeArrayList.add(universidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return universidadeArrayList;

    }

    public ResultSet read(Universidade universidade) {
        String sql = "select cod_univer Número, nome Nome, sigla Sigla, uf UF from univer where nome like ?";
        PreparedStatement statement;

        try {
//            System.out.println(revista.getNome_Revista());
            statement = Conexao.abrir().prepareCall(sql);
            //passando o conteudo  da caixa de texto para o ?
            //atenção ao % - continuação da string sql
            statement.setString(1, "%" + universidade.getNome_Univer() + "%");
//            System.out.println(statement);
            resultSet = statement.executeQuery();
//            System.out.println(resultSet);

            return resultSet;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return resultSet;
    }

    public int update(Universidade universidade) {
        String sql = "UPDATE universidade SET cod_univer=?, nome=?, sigla=?, uf=? WHERE cod_univer=?";
        int edt = 0;
        try {
            PreparedStatement statement = Conexao.abrir().prepareStatement(sql);

            statement.setInt(1, universidade.getCod_Univer());
            statement.setString(2, universidade.getNome_Univer());
            statement.setString(3, universidade.getSigla());
            statement.setString(4, universidade.getUF());
            statement.setInt(5, universidade.getCod_Univer());

            edt = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return edt;
    }

    public int delete(Universidade universidade) {
        String sql = "DELETE FROM universidade WHERE cod_univer=?";
        int remove = 0;
        try {
            PreparedStatement statement = Conexao.abrir().prepareStatement(sql);
            statement.setInt(1, universidade.getCod_Univer());

            remove = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remove;
    }
}
