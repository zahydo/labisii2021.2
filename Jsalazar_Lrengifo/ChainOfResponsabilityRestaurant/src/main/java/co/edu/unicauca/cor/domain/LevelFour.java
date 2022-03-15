package co.edu.unicauca.cor.domain;

import co.edu.unicauca.cor.infra.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelFour extends ClaimHandler {

  public LevelFour(String email) {
    super(email);
  }

  @Override
  public boolean attend(Claim claim) {
    if (claim.getType().equals(TypeEnum.INCOMPLETE)) {
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
