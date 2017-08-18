/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofbd.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        artigo.setCod_Artigo(read(artigo.getTitulo()));
        insereAutoria(artigo);
        insereReferencia(artigo);
        return add;
    }

    public void insereAutoria(Artigo artigo) {
        String autoria = "insert into autoria (cod_artigo, cod_pesq, posicao_autor) values"
                + "(?, ?, ?)";

        PreparedStatement statementAutoria;

        if (0 == artigo.getCoAutor()) {
            try {
                statementAutoria = Conexao.abrir().prepareStatement(autoria);
                statementAutoria.setInt(1, artigo.getCod_Artigo());
                statementAutoria.setInt(2, artigo.getAutor());
                statementAutoria.setInt(3, 1);
                statementAutoria.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                statementAutoria = Conexao.abrir().prepareStatement(autoria);
                statementAutoria.setInt(1, artigo.getCod_Artigo());
                statementAutoria.setInt(2, artigo.getAutor());
                statementAutoria.setInt(3, 1);
                statementAutoria.executeUpdate();

                statementAutoria = Conexao.abrir().prepareStatement(autoria);
                statementAutoria.setInt(1, artigo.getCod_Artigo());
                statementAutoria.setInt(2, artigo.getCoAutor());
                statementAutoria.setInt(3, 2);
                statementAutoria.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void insereReferencia(Artigo artigo) {
        if (artigo.getCod_Artigo_Referenciado() != 0) {
            try {
                String referencia = "insert into referencia (cod_artigo, cod_artigo_referenciado)"
                        + " values (?, ?)";

                PreparedStatement statementReferencia;
                statementReferencia = Conexao.abrir().prepareStatement(referencia);
                statementReferencia.setInt(1, artigo.getCod_Artigo());
                statementReferencia.setInt(2, artigo.getCod_Artigo_Referenciado());
                statementReferencia.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void insereAutoriaEditar(Artigo artigo) {
        String autoria = "update autoria set cod_artigo=?, cod_pesq=?, posicao_autor=? where cod_artigo=? and posicao_autor=?";

        PreparedStatement statementAutoria;

        if (0 == artigo.getCoAutor()) {
            try {
                statementAutoria = Conexao.abrir().prepareStatement(autoria);
                statementAutoria.setInt(1, artigo.getCod_Artigo());
                statementAutoria.setInt(2, artigo.getAutor());
                statementAutoria.setInt(3, 1);
                statementAutoria.setInt(4, artigo.getCod_Artigo());
                statementAutoria.setInt(5, 1);
                statementAutoria.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                statementAutoria = Conexao.abrir().prepareStatement(autoria);
                statementAutoria.setInt(1, artigo.getCod_Artigo());
                statementAutoria.setInt(2, artigo.getAutor());
                statementAutoria.setInt(3, 1);
                statementAutoria.setInt(4, artigo.getCod_Artigo());
                statementAutoria.setInt(5, 1);
                statementAutoria.executeUpdate();

                statementAutoria = Conexao.abrir().prepareStatement(autoria);
                statementAutoria.setInt(1, artigo.getCod_Artigo());
                statementAutoria.setInt(2, artigo.getCoAutor());
                statementAutoria.setInt(3, 2);
                statementAutoria.setInt(4, artigo.getCod_Artigo());
                statementAutoria.setInt(5, 2);
                statementAutoria.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    public void insereReferenciaEditar(Artigo artigo) {
        if (artigo.getCod_Artigo_Referenciado() != 0) {
            try {
                String referencia = "update referencia set cod_artigo=?, cod_artigo_referenciado=? where cod_artigo=?";

                PreparedStatement statementReferencia;
                statementReferencia = Conexao.abrir().prepareStatement(referencia);
                statementReferencia.setInt(1, artigo.getCod_Artigo());
                statementReferencia.setInt(2, artigo.getCod_Artigo_Referenciado());
                statementReferencia.setInt(3, artigo.getCod_Artigo());
                statementReferencia.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

    public String buscaAutor(int artigo) throws SQLException {
        String nome = null;
        String sql = "select nome_pesq from pesquisador p, autoria a"
                + " where p.cod_pesq = a.cod_pesq and a.cod_artigo = " + artigo
                + " and a.posicao_autor = 1";

        PreparedStatement statement = Conexao.abrir().prepareCall(sql);
//        statement.setInt(1, artigo);
        ResultSet resultSet;

        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            nome = resultSet.getString("nome_pesq");
        }

        return nome;
    }

    public String buscaCoAutor(int artigo) throws SQLException {
        String nome = null;
        String sql = "select nome_pesq from pesquisador p, autoria a, artigo art"
                + " where p.cod_pesq = a.cod_pesq and a.cod_artigo = " + artigo
                + " and a.posicao_autor = 2";

        PreparedStatement statement = Conexao.abrir().prepareCall(sql);
        ResultSet resultSet;
        resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            nome = resultSet.getString("nome_pesq");
        }

        return nome;
    }

    public String buscaReferencia(int codArtigo) throws SQLException {
        String nome = null;
        int cod =0;
        String sql = "select cod_artigo_referenciado from referencia where "
                + "cod_artigo = " + String.valueOf(codArtigo);

        PreparedStatement statement = Conexao.abrir().prepareCall(sql);
        ResultSet resultSet;
        
        resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            cod = resultSet.getInt("cod_artigo_referenciado");
        }

        nome = retornaTitulo(cod);
        return nome;
    }

    public ResultSet read(Artigo artigo) {
        String sql = "select * from artigo where titulo like ?";
        PreparedStatement statement;
        try {
            statement = Conexao.abrir().prepareCall(sql);
            //passando o conteudo  da caixa de texto para o ?
            //atenção ao % - continuação da string sql
            statement.setString(1, "%" + artigo.getTitulo() + "%");
            resultSet = statement.executeQuery();

            return resultSet;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return resultSet;
    }

    public int read(String nomeArtigo) {
        String sql = "select cod_artigo from artigo where titulo like ?";
        PreparedStatement statement;
        ResultSet retorno;
        int nome = 0;
        try {
            statement = Conexao.abrir().prepareCall(sql);
            statement.setString(1, nomeArtigo);
            retorno = statement.executeQuery();
            while (retorno.next()) {
                nome = retorno.getInt("cod_artigo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nome;
    }
    
    public String retornaTitulo(int codArtigo) {
        String sql = "select titulo from artigo where cod_artigo = ?";
        PreparedStatement statement;
        ResultSet retorno;
        String nome = null;
        try {
            statement = Conexao.abrir().prepareCall(sql);
            statement.setInt(1, codArtigo);
            retorno = statement.executeQuery();
            while (retorno.next()) {
                nome = retorno.getString("titulo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nome;
    }

    public int update(Artigo artigo) {

        int up = 0;
        PreparedStatement statement = null;

        if (artigo.getTipo().equals("P")) {
            String sql = "UPDATE artigo SET cod_artigo=?, titulo=?, "
                    + "pag_inicial=?, pag_final=?, ano=?, volume=?, numero=?, "
                    + "cod_revista=?, nome_congresso=null, cidade_congresso=null,"
                    + " data_congresso=null WHERE cod_artigo=?";

            try {
                statement = Conexao.abrir().prepareStatement(sql);

                statement.setInt(1, artigo.getCod_Artigo());
                statement.setString(2, artigo.getTitulo());
                statement.setInt(3, artigo.getPag_Inicial());
                statement.setInt(4, artigo.getPag_final());
                statement.setDate(5, artigo.getAno());
                statement.setInt(6, artigo.getVolume());
                statement.setInt(7, artigo.getNumero());
                statement.setInt(8, artigo.getCod_Revista());
                statement.setInt(9, artigo.getCod_Artigo());

                up = statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String sql = "UPDATE artigo SET cod_artigo=?, titulo=?, "
                    + "pag_inicial=?, pag_final=?, ano=?, volume=null, numero=null, "
                    + "cod_revista=null, nome_congresso=?, cidade_congresso=?,"
                    + " data_congresso=? WHERE cod_artigo=?";
            try {
                statement = Conexao.abrir().prepareStatement(sql);

                statement.setInt(1, artigo.getCod_Artigo());
                statement.setString(2, artigo.getTitulo());
                statement.setInt(3, artigo.getPag_Inicial());
                statement.setInt(4, artigo.getPag_final());
                statement.setDate(5, artigo.getAno());
                statement.setString(6, artigo.getNome_Congresso());
                statement.setString(7, artigo.getCidade_congresso());
                statement.setDate(8, artigo.getData_congresso());
                statement.setInt(9, artigo.getCod_Artigo());

                up = statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        insereAutoriaEditar(artigo);
        insereReferenciaEditar(artigo);
        return up;
    }

    public int delete(Artigo artigo) {
        String sql = "DELETE FROM artigo WHERE cod_artigo=? limit 1";

        PreparedStatement statement = null;
        int del = 0;
        try {
            statement = Conexao.abrir().prepareStatement(sql);
            statement.setInt(1, artigo.getCod_Artigo());
            del = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return del;
    }
}
