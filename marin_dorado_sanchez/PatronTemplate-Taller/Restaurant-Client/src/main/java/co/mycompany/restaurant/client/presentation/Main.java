package co.mycompany.restaurant.client.presentation;

import co.mycompany.restaurant.commons.domain.Plato;

/**
 * @author Fabián David Marín - Hector Fernando Dorado - Juan Sebastian Sanchez
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
        Plato plato3 = new Plato("5","carne asada","2000","200 g de res");
        Plato plato4 = new Plato("6","carne de cerdo asada","10000","200 g de cerdo");
        
        
        /**
         * se muestran los nombres de los platos agregados desde el controlador
         */
        System.out.println("El plato agregado es: "+ Facade.agregarPlato(plato1));
        System.out.println("El plato agregado es: "+ Facade.agregarPlato(plato2));
        System.out.println("El plato agregado es: "+ Facade.agregarPlato(plato3));
        System.out.println("El plato agregado es: "+ Facade.agregarPlato(plato4));
    }    
}
