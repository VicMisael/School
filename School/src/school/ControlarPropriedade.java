/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Misael
 */
public class ControlarPropriedade {

    private ControlarPropriedade() throws IOException {
        //File a = new File("config.propertires");
        criarPropriedade();
    }

    public static void criarPropriedade() throws FileNotFoundException, IOException {
        Properties prop = new Properties();
        FileOutputStream fos = new FileOutputStream("config.properties");
        prop.put("tema", "Nimbus");
        prop.store(fos, "sem Comentários..");
    }

    public static String lerPropriedade() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = null;

        try {
            // open existing file from the project's root folder
            fis = new FileInputStream("config.properties");
            prop.load(fis);
        } catch (FileNotFoundException ex) {
            criarPropriedade();
            return "Nimbus";
        }
        return prop.getProperty("tema");
        // load properties
        // read property

    }
   public static void escreverPropriedade(String tema) throws FileNotFoundException, IOException {
        Properties prop = new Properties();
        FileOutputStream fos = new FileOutputStream("config.properties");
        prop.put("tema", tema);
        prop.store(fos, "sem Comentários..");
    }

}
