/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptotest;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import java.util.Base64;

/**
 *
 * @author Misael
 */
public class encriptar {

    private static final String ALGORITIMO = "AES";
    private static final String CHAVE = "SISTEMADEPROVASONLINEMAROTO";

    //A Chave precisa ter em média uns 16bytes ou mais(se for maior vai ser truncado)
    //Conta cada caractere é um byte(Em média)
    //é possivel fazer um MD5 da senha pra pegar uma key de 16bytes
    //só que da mais trabalho
    public static String encriptarTexto(String valor) {
        String encriptado = null;
        try {
            final Cipher c = Cipher.getInstance(ALGORITIMO);
            c.init(Cipher.ENCRYPT_MODE, gerarChave(CHAVE));
            final byte[] valorEnc = c.doFinal(valor.getBytes());

            encriptado = Base64.getEncoder().encodeToString(valorEnc);
            //Parte que faz a mágica acontecer
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao encriptar \n" + ex);
            ex.printStackTrace();
        }

        return encriptado;
    }

    public static String decriptarTexto(String encriptado) {
        String decriptado = null;
        try {
            final Cipher c = Cipher.getInstance(ALGORITIMO);
            c.init(Cipher.DECRYPT_MODE, gerarChave(CHAVE));
            final byte[] bytesEnc = Base64.getDecoder().decode(encriptado);
            final byte[] decBytes = c.doFinal(bytesEnc);
            decriptado = new String(decBytes);
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            JOptionPane.showMessageDialog(null, "falha ao desencriptar \n" + ex);
        }
        return decriptado;
    }

    private static Key gerarChave(String chaveString) throws IOException {

        byte[] keyVal = Base64.getDecoder().decode(chaveString);
        byte newKey[] = new byte[16];
        //Vai checar se a String passada como chave possui 16Bytes

        if (keyVal.length < 16) {
            JOptionPane.showMessageDialog(null, "A chave é muito curta :" + keyVal.length + "Bytes");
            return null;
            //não há muito o que fazer se for menor que 16
        } else if (keyVal.length > 16) {
            //Vai truncar a chave caso seja maior que 16bytes
            for (int i = 0; i < newKey.length; i++) {
                newKey[i] = keyVal[i];
            }
            final Key key = new SecretKeySpec(newKey, ALGORITIMO);
            return key;
            //e claro retornar a versão truncada dela

        } else {
            //Só vai cair aqui se for igual a 16Bytes

            final Key key = new SecretKeySpec(keyVal, ALGORITIMO);
            return key;
        }

    }

}