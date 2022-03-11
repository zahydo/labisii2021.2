package co.mycompany.restaurant.client.presentation;

import co.mycompany.restaurant.commons.domain.Plato;

/**
 * @author Fabián David Marín - Hector Fernando Dorado
 * 
 */
public class Main {
    
    /**
     * instancia del controlador
     */
    private static RestaurantFacade Facade = RestaurantFacade.getInstance();
    public static void main(String[] args) throws Exception {
        
        /**
         * objetos de tipo Plato 
         */
        Plato plato1 = new Plato("3","Arroz Chino","18000","30 g de res");
        Plato plato2 = new Plato("4","Bisteck de Carne","13000","200 g de res");
        
        /**
         * se muestran los nombres de los platos agregados desde el controlador
         */
        System.out.println("El plato agregado es: "+ Facade.agregarPlato(plato1));
        System.out.println("El plato agregado es: "+ Facade.agregarPlato(plato2));
    }    
}
