
package co.unicauca.restaurant.server.access;

/**
 *
 * @author Anderson Diaz
 */
public class RepositoryFactory {
    private static RepositoryFactory instance;

    private RepositoryFactory() {
    }


    public static RepositoryFactory getInstance() {

        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;

    }


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
