/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import Principal.Login;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Misael
 */
public class PrepareIcon {

    private Image im = null;
    private static PrepareIcon prepareicon;

    private PrepareIcon() {

    }

    public Image getImage() {
        try {
            im = ImageIO.read(getClass().getResource("icon.png"));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return im;
    }
   

    public static PrepareIcon getInstance() {
        if (prepareicon == null) {
            prepareicon = new PrepareIcon();
        }
        return prepareicon;

    }
}
