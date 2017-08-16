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

    public int create(Artigo artigo) {
        int add = 0;
        PreparedStatement statement = null;

        if (artigo.getTipo().equals("P")) {
            String sql = "INSERT INTO artigo (titulo, pag_inicial, pag_final, ano, "
                    + "volume, numero, cod_revista, nome_congresso, cidade_congresso, data_congresso) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, null, null, null)";

            try {
                statement = Conexao.abrir().prepareStatement(sql);
                statement.setString(1, artigo.getTitulo());
                statement.setInt(2, artigo.getPag_Inicial());
                statement.setInt(3, artigo.getPag_final());
                statement.setDate(4, artigo.getAno());
                statement.setInt(5, artigo.getVolume());
                statement.setInt(6, artigo.getNumero());
                statement.setInt(7, artigo.getCod_Revista());
                add = statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String sql = "INSERT INTO artigo (titulo, pag_inicial, pag_final, ano, "
                    + "volume, numero, cod_revista, nome_congresso, cidade_congresso, data_congresso) "
                    + "VALUES (?, ?, ?, ?, null, null, null, ?, ?, ?)";

            try {
                statement = Conexao.abrir().prepareStatement(sql);
                statement.setString(1, artigo.getTitulo());
                statement.setInt(2, artigo.getPag_Inicial());
                statement.setInt(3, artigo.getPag_final());
                statement.setDate(4, artigo.getAno());
                statement.setString(5, artigo.getNome_Congresso());
                statement.setString(6, artigo.getCidade_congresso());
                statement.setDate(7, artigo.getData_congresso());
                add = statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return add;
    }

    public ArrayList<Artigo> read() {
        String sql = "SELECT * FROM artigo";

        ArrayList<Artigo> revistaArrayList = new ArrayList<Artigo>();
        try {
            Statement statement = Conexao.abrir().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
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
            statement.setString(1, "%" + artigo.getTitulo() + "%");
//            System.out.println(statement);
            resultSet = statement.executeQuery();
//            System.out.println(resultSet);

            return resultSet;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return resultSet;
    }

    public int update(Artigo artigo) {

        int up = 0;
        PreparedStatement statement = null;

        if (artigo.getTipo().equals("C")) {
            String sql = "UPDATE artigo SET cod_artigo=?, tipo=?, titulo=?, "
                    + "pag_inicial=?, pag_final=?, ano=?, nome_congresso=?, cidade_congresso=?,"
                    + "data_congresso=? WHERE cod_artigo=?";

            try {
                statement = Conexao.abrir().prepareStatement(sql);

                statement.setInt(1, artigo.getCod_Artigo());
                statement.setString(2, artigo.getTipo());
                statement.setString(3, artigo.getTitulo());
                statement.setInt(4, artigo.getPag_Inicial());
                statement.setInt(5, artigo.getPag_final());
                statement.setDate(6, artigo.getAno());
                statement.setInt(7, artigo.getVolume());
                statement.setInt(8, artigo.getNumero());
                statement.setInt(9, artigo.getCod_Revista());
                statement.setInt(10, artigo.getCod_Artigo());

                up = statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String sql = "UPDATE artigo SET cod_artigo=?, tipo= ?, titulo=?, "
                    + "pag_inicial=?, pag_final=?, ano=?, volume=?, numero=?, "
                    + "cod_revista=? WHERE cod_artigo=?";
            try {
                statement = Conexao.abrir().prepareStatement(sql);

                statement.setInt(1, artigo.getCod_Artigo());
                statement.setString(2, artigo.getTipo());
                statement.setString(3, artigo.getTitulo());
                statement.setInt(4, artigo.getPag_Inicial());
                statement.setInt(5, artigo.getPag_final());
                statement.setDate(6, artigo.getAno());
                statement.setString(7, artigo.getNome_Congresso());
                statement.setString(8, artigo.getCidade_congresso());
                statement.setDate(9, artigo.getData_congresso());
                statement.setInt(10, artigo.getCod_Artigo());

                up = statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return up;
    }

    public int delete(Artigo artigo) {
        String sql = "DELETE FROM artigo WHERE titulo=? limit 1";

        PreparedStatement statement = null;
        int del = 0;
        try {
            statement = Conexao.abrir().prepareStatement(sql);
            statement.setString(1, artigo.getTitulo());
            del = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return del;
    }
}
