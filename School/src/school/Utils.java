/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.text.Normalizer;

/**
 *
 * @author Misael
 */
public class Utils {

    public static String getSalvableTextType(String title) {

        String newText = Normalizer.normalize(title, Normalizer.Form.NFD).replace("[^\\p{ASCII}]", "");
        char[] text = newText.toCharArray();
        String newerText = "";
        for (char character : text) {

            if (!Character.isWhitespace(character)) {
                newerText += character;
            } else {

                newerText += "_";
            }
        }

        return newerText;
    }
}
