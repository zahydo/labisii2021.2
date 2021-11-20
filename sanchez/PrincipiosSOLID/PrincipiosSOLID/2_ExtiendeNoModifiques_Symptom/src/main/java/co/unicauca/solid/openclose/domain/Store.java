package co.unicauca.solid.openclose.domain;

/**
 * Representa una tienda. Puede ver virtual o dentro de un negocio Esta clase
 * hace envío de unos productos
 *
 * @author Libardo, Julio
 */
public class Store {

    /**
     * Calcular costo de entrega dependiendo del pais
     * Tiene sólo esa responsabilidad   
     *
     * @param order orden sobre la cual se calcula el costo de entrega
     * @return costo de entrega
     */
    public double calculateDeliveryCost(Order order) {

        if (order == null) {
            return -1;
        }

        double result = 0;

        switch (order.getCountry()) {
            case COLOMBIA:
                result = order.getTotal() * 0.01;
                if (order.getWeight() <= 2) {
                    result += 9900;
                } else {
                    result += order.getWeight() * 5000;
                }

                break;
            case MEXICO:
                result = 98;
                break;
        }
        
        // ¿Qué pasa si en el futuro el negocio se expande y se debe
        // enviar ordenes a más paises? por ejemplo, se abre una 
        // sucursal en Perú. Ahi se rompe el principio, esta clase
        // no está cerrada a modificaciones

        return result;
    }
}
