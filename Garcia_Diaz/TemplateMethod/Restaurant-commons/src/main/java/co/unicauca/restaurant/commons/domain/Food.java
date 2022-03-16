
package co.unicauca.restaurant.commons.domain;

/**
 *
 * @author Anderson Diaz
 */
public class Food {
    private int idFood;
    private String nameFood;
    private FoodTypeEnum type;

    public Food() {
    }

    
    
    public Food(int idFood, String nameFood, FoodTypeEnum type) {
        this.idFood = idFood;
        this.nameFood = nameFood;
        this.type = type;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public FoodTypeEnum getType() {
        return type;
    }

    public void setType(FoodTypeEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Food{" + "idFood=" + idFood + ", nameFood=" + nameFood + ", type=" + type + '}';
    }

    
    
}
