package co.unicauca.foodapp.commons.infra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import com.google.common.reflect.TypeToken;

/**
 * Utilidades varias utilizadas por otras clases
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public class Utilities {

    /**
     * Cargar una propiedadd de config.properties
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
     * @param str Cadena a verificvar
     * @return true si contiene sólo digitos, false en caso contrario
     */
    public static boolean isNumeric(String str) {
        boolean resultado;
        try {
            Integer.parseInt(str);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
    /**
     * Construye una lista de jsons con la información de los objetos en la lista que llega por parametro
     * @param results lista con objetos a convertir en json
     * @return String con los valores en json
     */
    @SuppressWarnings("rawtypes")
    public static String listToJson(List results) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Object>>() {
        }.getType();
        gson = new GsonBuilder().create();
        String json = gson.toJson(results, type);
        return json;
    }
}
