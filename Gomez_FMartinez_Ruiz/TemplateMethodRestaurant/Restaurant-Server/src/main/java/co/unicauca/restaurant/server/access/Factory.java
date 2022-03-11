package co.unicauca.restaurant.server.access;

/**
 *
 * @author XssIsor
 */
public class Factory {
    
    /**
     * Instancia de la clase utlizada para el Singleton
     */
    private static Factory instance;

    private Factory() {
    }

    /**
     * Constructor Singleton
     * @return La misma instancia de Factory para toda la app.
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Crea una instancia del Repositorio en cuestión. En este caso sólo retorna un tipo específico.
     *
     * @param type String. Determina el tipo a retornar.
     * @return Una clase que hereda de IFoodRepository.
     */
    public IFoodRepository getRepository(String type) {

        IFoodRepository repository = null;

        switch (type) {
            case "default":
                repository = new FoodImplArrayRepository();
                break;
        }

        return repository;
    }
}
