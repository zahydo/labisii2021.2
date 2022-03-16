package co.edu.unicauca.cor.infra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Utilidades {

    public static void EnviarEmail(String email, String to, String body) {
        //Lógica del envio del email
        //...
        
        Logger logger= LoggerFactory.getLogger(Utilidades.class); 
        
        logger.info("Email enviado a " + email);
    }


}
