package co.edu.unicauca.cor.domain;

import co.edu.unicauca.cor.infra.Utilidades;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Nivel de atención 1 de recamos
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class NivelUno extends Manejador_Reclamos {

    public NivelUno(String email) {
        super(email);
    }

    @Override
    public boolean attend(Reclamo prmReclamo) {
        if (prmReclamo.getAtrTipo().equals(TipoEnum.BASIC)) {
            Logger logger = LoggerFactory.getLogger(Utilidades.class);
            logger.info("El reclamo será atendido en el nivel 1 por " + getAtrEmail());
            Utilidades.EnviarEmail(getAtrEmail(), prmReclamo.getAtrTitulo(), prmReclamo.getAtrDescripcion());

            prmReclamo.setAtrAttended(true);
            return true;

        } else {
            return getAtrSiguienteManipulador().attend(prmReclamo);
        }
    }

}
