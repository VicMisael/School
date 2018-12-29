/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.ArrayList;

/**
 *
 * @author adrian
 */
public class ProfessorDisciplina {
    ArrayList< Integer> disciplinas ;
    private String nome ;
    private String disciplina ;
    private int idProfDic ; 
    public ArrayList<Integer> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Integer> disciplinas) {
        this.disciplinas = disciplinas;
    }  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getIdProfDic() {
        return idProfDic;
    }

    public void setIdProfDic(int idProfDic) {
        this.idProfDic = idProfDic;
    }

     
    
}
