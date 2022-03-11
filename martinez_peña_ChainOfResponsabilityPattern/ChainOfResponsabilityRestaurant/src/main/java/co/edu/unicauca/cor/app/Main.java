package co.edu.unicauca.cor.app;

import co.edu.unicauca.cor.domain.ClaimManager;
import co.edu.unicauca.cor.domain.Claim;
import co.edu.unicauca.cor.domain.TypeEnum;

/**
 *
 * @author Libardo, Julio
 */
public class Main {

    public static void main(String[] args) {
        //Instancia del Claim Manager
        ClaimManager manager = new ClaimManager();
        //Se crean los repectivos enlaces e información inicial
        manager.createAthentionFlow();

        //Nivel 1 atiende un Clain Nivel 1 (Lo puede atender)
        Claim claim = new Claim(1, "Tiempo de entrega", "¿Cual es el promedio de entrega de mi domicilio?", TypeEnum.BASIC);
        manager.getLevelOne().attend(claim);
        //Nivel 2 atiende un Clain Nivel 3, entonces no lo puede atender, lo pasa al siguiente(Nivel 3)
        claim = new Claim(2, "Cobro exajerado del domicilio", "El mensajero me cobró mucho por el domicilio", TypeEnum.HIGH);
        manager.getLevelOne().attend(claim);

        //Nivel 3 atiende un Clain Nivel 3, entonces la logra atender
        claim = new Claim(3, "Calidad del producto", "La comida del restaurante popayan casero estaba fria", TypeEnum.HIGH);
        manager.getLevelOne().attend(claim);
        //Nivel 4 atiende una solicitud Nivel 5, la pasa al siguiente
        claim = new Claim(4, "Producto equivocado", "Me enviaron el pedido que no era", TypeEnum.INMEDIATY);
        manager.getLevelOne().attend(claim);
        //Nivel 5 atiende una solicitud no clasificada. No la puede atender
        claim = new Claim(5, "No llegó la comida", "No llegó el pedido", TypeEnum.UNCLASSIFIED);
        manager.getLevelOne().attend(claim);
    }

}
