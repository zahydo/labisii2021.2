/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.cor.domain;

import co.edu.unicauca.cor.infra.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ASUS
 */
public class LevelFour extends ClaimHandler {
    
     public LevelFour(String email) {
        super(email);
    }

    @Override
    public String attend(Claim claim) {
        if (claim.getType().equals(TypeEnum.GERENCY)) {
            Logger logger = LoggerFactory.getLogger(Utilities.class);
            logger.info("El reclamo será atendido en el nivel 4 por " + getEmail());
            Utilities.sendMail(getEmail(), claim.getTitle(), claim.getDescription());
            claim.setAttended(true);
            return "El reclamo será atendido en el nivel 4 por " + getEmail();

        } else {
            System.out.println("No se puede atender. El reclamo está sin clasificar");
            return "No se puede atender. El reclamo está sin clasificar";
        }
    }

}
