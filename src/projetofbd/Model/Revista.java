/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofbd.Model;

/**
 *
 * @author lucas
 */
public class Revista {
    
    private int Cod_Revista;
    private String Nome_Revista;
    private String Editora;
    private String ISSN;

    public int getCod_Revista() {
        return Cod_Revista;
    }

    public void setCod_Revista(int cod_Revista) {
        Cod_Revista = cod_Revista;
    }

    public String getNome_Revista() {
        return Nome_Revista;
    }

    public void setNome_Revista(String nome_Revista) {
        Nome_Revista = nome_Revista;
    }

    public String getEditora() {
        return Editora;
    }

    public void setEditora(String editora) {
        Editora = editora;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }
    
}
