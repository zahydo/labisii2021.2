package co.unicauca.commandRestaurant.infra;

/**
 *
 * @author libardo
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Properties;

/**
 * Utilidades varias utilizadas por otras clases
 *
 * @author Libardo, Daniel
 */
public class Utilities {

    /**
     * palabra para encrypt los datos
     */
    private static String ENCRYPT_KEY = "clave-compartida-no-reveloar-nunca";

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
            StringBuilder sbt = new StringBuilder();
            String[] partialText = text.split(" ");
            for (String partialText1 : partialText) {
                if (!partialText1.equals("")) {
                    if (partialText1.contains("-")) {
                        //composite words
                        sbt.append(capitalizeWithLine(partialText1));
                    } else {
                        sbt.append(capitalizeWord(partialText1));
                        sbt.append(" ");
                    }
                }
            }
            return sbt.toString().trim(); //only for entire phrase
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
            StringBuilder sb = new StringBuilder();
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
        StringBuilder res = new StringBuilder();
        String[] partialTextWithLine = wordWithLine.split("-");
        for (int r = 0; r < partialTextWithLine.length; r++) {
            res.append(capitalizeWord(partialTextWithLine[r]));
            if (r + 1 < partialTextWithLine.length) //not append to end
            {
                res.append("-");
            }
        }
        return res.toString();
    }

    /**
     * Metodo que encripta un cadena que llega por parametro
     *
     * @param word palabra a encriptar
     * @return palabra encriptada
     * @throws java.io.UnsupportedEncodingException
     */
    public static String encrypt(String word) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(word.getBytes("utf-8"));
    }

    /**
     * Metodo que desencripta una palabra que llega por parametro
     *
     * @param word palabra encriptada
     * @return palabra desencriptada
     * @throws java.io.UnsupportedEncodingException
     */
    public static String decrypt(String word) throws UnsupportedEncodingException {
        byte[] decode = Base64.getDecoder().decode(word.getBytes());
        return new String(decode, "utf-8");
    }

}
