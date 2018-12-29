/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Misael
 */
public class Questao {

    private int idQuestao;
    private String enunciado;
    private int dificuldade;
    private String dificuldadeString;
    private int numero;

    public String getDificuldadeString() {
        return dificuldadeString;
    }

    public void setDificuldadeString(String dificuldadeString) {
        this.dificuldadeString = dificuldadeString;
    }
    private int idAssunto;

    public int getIdAssunto() {
        return idAssunto;
    }

    public void setIdAssunto(int idAssunto) {
        this.idAssunto = idAssunto;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    @Override
    public String toString() {
        return getEnunciado();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
