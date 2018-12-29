/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Informática 3
 */
public class Disciplina {
    private String disciplina;
    private int id ;
    
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
 public String toString() {
        return getDisciplina(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
