package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;

// import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;

public interface Food {
    /**
     * Declarar los métodos de food que pueden ser decorados,
     * CapitalFood: setName (capitaliza el nombre)
     * CryptFood: setName (encripta el nombre), getName (desencripta el nombre)
     */
    public String getName();
    public void setName(String name);
    public int getId();
    public void setId(int id);
    public FoodTypeEnum getType();
    public void setType(FoodTypeEnum type);
}