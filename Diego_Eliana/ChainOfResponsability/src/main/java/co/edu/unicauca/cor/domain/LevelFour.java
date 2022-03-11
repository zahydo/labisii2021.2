package co.edu.unicauca.cor.domain;

import co.edu.unicauca.cor.infra.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelFour extends ClaimHandler {
    
     public LevelFour(String email) {
        super(email);
    }

    @Override
    public String attend(Claim claim) {
        if (claim.getType().equals(TypeEnum.PRIORITY)) {
            Logger logger = LoggerFactory.getLogger(Utilities.class);
            logger.info("El reclamo será atendido en el nivel 4 por " + getEmail());
            Utilities.sendMail(getEmail(), claim.getTitle(), claim.getDescription());
            claim.setAttended(true);
            return "El reclamo será atendido en el nivel 4 por " + getEmail();
        }
        System.out.println("No se puede atender. El reclamo está sin clasificar");
        return "No se puede atender. El reclamo está sin clasificar";
    }

}
