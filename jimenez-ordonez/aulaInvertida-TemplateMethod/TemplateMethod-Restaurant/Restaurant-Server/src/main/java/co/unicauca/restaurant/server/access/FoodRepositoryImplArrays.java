package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Food;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public final class FoodRepositoryImplArrays implements IFoodRepository {
    
/**
     * Array List de clientes
     */
    private static List<Food> foods;

    public FoodRepositoryImplArrays() {
        if (foods == null){
            foods = new ArrayList();
        }
        
        if (foods.size() == 0){
            inicializar();
        }
    }

    public void inicializar() {
        foods.add(new Food("1", "Sancocho", "Sobrevalorado pero rico"));
        foods.add(new Food("2", "Ajiaco", "Delicioso y mejor que el sancocho"));
        foods.add(new Food("3", "Changua", "Posiblemente lo compre un rolo"));
        foods.add(new Food("4", "Chulquin", "Es lo mas delicioso"));
        foods.add(new Food("5", "Tripazo", "No es muy deliciosa"));
        foods.add(new Food("6", "Sopa", "Sopa clasica de pastas"));
    }

    /**
     * Busca u Customer en el arreglo
     *
     * @param id cedula del customer
     * @return objeto Customer
     */
    @Override
    public Food findFood(String id) {
        for (Food food : foods) {
            if (food.getId().equals(id)) {
                return food;
            }
        }
        return null;
    }

    @Override
    public String createFood(Food food) {
        foods.add(food);
        return food.getId();
    }

}
