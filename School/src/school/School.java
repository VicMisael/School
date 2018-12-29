/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import DAO.DAOtest;
import DAO.ProvaDAO;
import Model.Prova;
import Principal.*;
import com.itextpdf.text.DocumentException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author adria
 */
public class School {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
      new ControlaPDF().abrirManual();

    }

}
