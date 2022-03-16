package co.edu.unicauca.cor.app;

import co.edu.unicauca.cor.domain.Reclamos_Manager;
import co.edu.unicauca.cor.domain.Reclamo;
import co.edu.unicauca.cor.domain.TipoEnum;

/**
 *
 * @author Libardo, Julio
 */
public class Main {


    public static void main(String[] args) {
        Reclamos_Manager manager = new Reclamos_Manager();
        manager.createAthentionFlow();

        Reclamo claim = new Reclamo(1, "Tiempo de entrega", "¿Cual es el promedio de entrega de mi domicilio?", TipoEnum.BASIC);
        manager.getAtrNivelUno().attend(claim);

        claim = new Reclamo(2, "Cobro exajerado del domicilio", "El mensajero me cobró mucho por el domicilio", TipoEnum.DELIVERY);
        manager.getAtrNivelUno().attend(claim);

        claim = new Reclamo(3, "Calidad del producto", "La comida del restaurante popayan casero estaba fria", TipoEnum.HIGH);
        manager.getAtrNivelUno().attend(claim);

        claim = new Reclamo(4, "Producto equivocado", "Me enviaron el pedido que no era", TipoEnum.UNCLASSIFIED);
        manager.getAtrNivelUno().attend(claim);
    }

}
