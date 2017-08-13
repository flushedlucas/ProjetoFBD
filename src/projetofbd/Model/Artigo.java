/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofbd.Model;

import java.sql.Date;

/**
 *
 * @author lucas
 */
public class Artigo {
    
    // Dados de Artigo
    private int Cod_Artigo;
    private String Titulo;
    private int Pag_Inicial;
    private int Pag_final; 
    private Date Ano;
    
    // Dados de Artigo_Periodico
    private int Volume;
    private int Numero;
    private int Cod_Revista;
    
    // Dados de Artigo_Congresso
    private String Nome_Congresso;
    private String Cidade_congresso;
    private Date Data_congresso;
    
    //Código do artigo referenciado
    private int Cod_Artigo_Referenciado;

    public int getCod_Artigo() {
        return Cod_Artigo;
    }

    public void setCod_Artigo(int Cod_Artigo) {
        this.Cod_Artigo = Cod_Artigo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public int getPag_Inicial() {
        return Pag_Inicial;
    }

    public void setPag_Inicial(int Pag_Inicial) {
        this.Pag_Inicial = Pag_Inicial;
    }

    public int getPag_final() {
        return Pag_final;
    }

    public void setPag_final(int Pag_final) {
        this.Pag_final = Pag_final;
    }

    public Date getAno() {
        return Ano;
    }

    public void setAno(Date Ano) {
        this.Ano = Ano;
    }

    public int getVolume() {
        return Volume;
    }

    public void setVolume(int Volume) {
        this.Volume = Volume;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public int getCod_Revista() {
        return Cod_Revista;
    }

    public void setCod_Revista(int Cod_Revista) {
        this.Cod_Revista = Cod_Revista;
    }

    public String getNome_Congresso() {
        return Nome_Congresso;
    }

    public void setNome_Congresso(String Nome_Congresso) {
        this.Nome_Congresso = Nome_Congresso;
    }

    public String getCidade_congresso() {
        return Cidade_congresso;
    }

    public void setCidade_congresso(String Cidade_congresso) {
        this.Cidade_congresso = Cidade_congresso;
    }

    public Date getData_congresso() {
        return Data_congresso;
    }

    public void setData_congresso(Date Data_congresso) {
        this.Data_congresso = Data_congresso;
    }

    public int getCod_Artigo_Referenciado() {
        return Cod_Artigo_Referenciado;
    }

    public void setCod_Artigo_Referenciado(int Cod_Artigo_Referenciado) {
        this.Cod_Artigo_Referenciado = Cod_Artigo_Referenciado;
    }
    
}
