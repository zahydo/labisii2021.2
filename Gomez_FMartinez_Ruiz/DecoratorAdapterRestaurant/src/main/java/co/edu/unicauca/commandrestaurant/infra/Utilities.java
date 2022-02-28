package co.edu.unicauca.commandrestaurant.infra;

/**
 *
 * @author libardo
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;

/**
 * Utilidades varias utilizadas por otras clases
 *
 * @author Libardo, Daniel
 */
public class Utilities {

    
    public static String encrypt(String data) {
        byte[] reponse = data.getBytes();
        for (int i = 0; i < reponse.length; i++) {
            reponse[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(reponse);
    }

    public static String decrypt(String data) {
        byte[] reponse = Base64.getDecoder().decode(data);
        for (int i = 0; i < reponse.length; i++) {
            reponse[i] -= (byte) 1;
        }
        return new String(reponse);
    }
    
    
    /**
     * Cargar una propiedadd de config.properties
     *
     * @param key llave de la propiedad
     * @return valor de la propiedad
     */
    public static String loadProperty(String key) {
        Properties prop = new Properties();
        InputStream is;

        try {
            is = new FileInputStream("./config.properties");
            prop.load(is);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo");
        }

        return prop.getProperty(key);
    }

    /**
     * Verifica si un String contiene sólo digitos
     *
     * @param str Cadena a verificvar
     * @return true si contiene sólo digitos, false en caso contrario
     */
    public static boolean isNumeric(String str) {

        boolean resultado;

        try {
            Long.parseLong(str);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    /**
     * Pone en mayúsculas la primera letra de una frase
     *
     * @param text texto ser capitalizado
     * @return texto capitalizado
     */
    public static String capitalize(String text) {
        if (!text.isEmpty()) {
            StringBuffer sbt = new StringBuffer();
            String[] partialText = text.split(" ");
            for (int i = 0; i < partialText.length; i++) {
                if (!partialText[i].equals("")) {

                    if (partialText[i].contains("-")) { // composite words
                        sbt.append(capitalizeWithLine(partialText[i]));
                    } else {
                        sbt.append(capitalizeWord(partialText[i]));
                        sbt.append(" ");
                    }
                }
            }
            return sbt.toString().trim(); // only for entire phrase
        }
        return text;
    }

    /**
     * Método privado utilizado por capitalize(String text)
     *
     * @param word
     * @return
     */
    private static String capitalizeWord(String word) {
        if (!word.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            sb.append(String.valueOf(word.charAt(0)).toUpperCase());

            if (word.length() >= 2) {
                sb.append(word.substring(1).toLowerCase());
            }

            return sb.toString();
        }
        return word;
    }

    /**
     * Método privado utilizado por capitalize(String text)
     *
     * @param word
     * @return
     */
    private static String capitalizeWithLine(String wordWithLine) {
        StringBuffer res = new StringBuffer();
        String[] partialTextWithLine = wordWithLine.split("-");
        for (int r = 0; r < partialTextWithLine.length; r++) {
            res.append(capitalizeWord(partialTextWithLine[r]));
            if (r + 1 < partialTextWithLine.length) // not append to end
            {
                res.append("-");
            }
        }
        return res.toString();
    }
    

}
