package co.unicauca.foodapp.server.access;

/**
 * Fabrica que se encarga de instanciar un repositorio concreto
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public class RepositoryFactory {

    /**
     * Instancia Singleton del repositorio
     */
    private static RepositoryFactory instance;

    /**
     * Constructor privado por defecto
     */
    private RepositoryFactory() {}

    /**
     * Consigue la instancia Singleton de la clase
     * @return instancia Singleton
     */
    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IFoodRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IFoodRepository
     */
    public IFoodRepository getRepository(String type) {
        IFoodRepository result = null;
        switch (type) {
            case "default":
                result = new FoodImplArrayRepository();
                break;
        }
        return result;
    }
}
