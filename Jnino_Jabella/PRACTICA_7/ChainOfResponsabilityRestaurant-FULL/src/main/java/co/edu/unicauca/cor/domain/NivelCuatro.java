/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cor.domain;

import co.edu.unicauca.cor.infra.Utilidades;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Juan F. Abella - Julian Niño
 */
public class NivelCuatro extends Manejador_Reclamos{
    
    public NivelCuatro(String email) {
        super(email);
    }
    
    @Override
    public boolean attend(Reclamo claim) {
        
        boolean SeAtendio = false;
        if (claim.getAtrTipo().equals(TipoEnum.UNCLASSIFIED)) {
            Logger logger = LoggerFactory.getLogger(Utilidades.class);
            logger.info("El reclamo será atendido en el nivel 4 por : " + getAtrEmail());
            Utilidades.EnviarEmail(getAtrEmail(), claim.getAtrTitulo(), claim.getAtrDescripcion());
            claim.setAtrAttended(true);
            SeAtendio = true;

        } else {
            System.out.println("NO SE PUEDE ATENDER. EL RECLAMO NO TIENE CLASIFICACION");
           SeAtendio = false;
        }
        return SeAtendio;
    }
    
}
