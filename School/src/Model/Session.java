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
public class Session {

    private static Session instancia = null;
    private Usuario usuario;

    private Session() {
        //não pode ser instanciado poroutra classe
    }

    public static Session getInstance() {
        if (instancia == null) {
            instancia = new Session();

        }
        return instancia;
    }

    public static void resetInstance() {
        instancia=null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
