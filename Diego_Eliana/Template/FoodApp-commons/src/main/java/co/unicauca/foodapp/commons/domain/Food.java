package co.unicauca.foodapp.commons.domain;

/**
 * Representa una comida del restaurante de cualquier tipo: Entrada, principio,
 * carne, postre, etc
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public class Food {

    /**
     * Atributo del id de la comida
     */
    private int id;
    
    /**
     * Atributo del nombre de la comida
     */
    private String name;

    /**
     * Atributo con el tipo de la comida
     */
    private FoodTypeEnum type;

    /**
     * Constructor parametrizado
     * @param id de la comida
     * @param name de la comida
     * @param type de la comida
     */
    public Food(int id, String name, FoodTypeEnum type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    /**
     * Constructor por defecto
     */
    public Food() {}

    /**
     * Getter de id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter de id
     * @param id nuevo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del nombre
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter del nombre
     * @param name nuevo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter del tipo
     * @return tipo
     */
    public FoodTypeEnum getType() {
        return type;
    }

    /**
     * Setter del tipo
     * @param type nuevo
     */
    public void setType(FoodTypeEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", name=" + name + ", type=" + type + '}';
    }
}
