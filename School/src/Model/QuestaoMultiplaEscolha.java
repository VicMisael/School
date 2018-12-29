/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Info3
 */
public final class QuestaoMultiplaEscolha extends Questao {
    private String itens[];

    private char gabarito;

    public char getGabarito() {
        return gabarito;
    }

    public void setGabarito(char gabarito) {
        this.gabarito = gabarito;
    }
    public String[] getItens() {
        return itens;
    }

    public void setItens(String[] itens) {
        this.itens = itens;
    }

}
