/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cor.domain;

import co.edu.unicauca.cor.infra.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Nivel de atención 4 de recamos
 *
 * @author Jose Galindez Yaquelin Gomez
 */
public class LevelFour extends ClaimHandler {

    public LevelFour(String email) {
        super(email);
    }

    @Override
    public boolean attend(Claim claim) {
        if (claim.getType().equals(TypeEnum.MAX)) {
            Logger logger = LoggerFactory.getLogger(Utilities.class);
            logger.info("El reclamo será atendido en el nivel 4 por " + getEmail());
            Utilities.sendMail(getEmail(), claim.getTitle(), claim.getDescription());
            claim.setAttended(true);
            return true;

        } else {
            System.out.println("No se puede atender. El reclamo está sin clasificar");
            return false;
        }
    }

}
