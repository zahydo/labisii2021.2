package co.edu.unicauca.cor.domain;

import co.edu.unicauca.cor.infra.Utilidades;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Nivel de atención 3 de recamos
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class NivelDos extends Manejador_Reclamos {

    public NivelDos(String email) {
        super(email);
    }

    @Override
    public boolean attend(Reclamo claim) {
        if (claim.getAtrTipo().equals(TipoEnum.DELIVERY)){
            Logger logger = LoggerFactory.getLogger(Utilidades.class);
            logger.info("El reclamo será atendido en el nivel 2 por " + getAtrEmail());             
            Utilidades.EnviarEmail(getAtrEmail(), claim.getAtrTitulo(),  claim.getAtrDescripcion());
            claim.setAtrAttended(true);
            return true;
            
        } else {
            return getAtrSiguienteManipulador().attend(claim);
        }
    }

}
