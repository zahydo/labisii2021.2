package co.unicauca.parkinglot.domain;

import co.unicauca.parkinglot.domain.TypeEnum;

/**
 * @author angiecgomez
 * @author mafemartinez
 */
public class Vehicle {
    
    /**
     * Attributes
     */
    
    private String plate;
    private TypeEnum type;
    
    /**
     * Constructor with parameters
     * @param plate
     * @param type 
     */

    public Vehicle(String plate, TypeEnum type) {
        this.plate = plate;
        this.type = type;
    }

    /**
     * Constructor
     */
    public Vehicle() {
        
    }
    
   
    /**
     * Getters and setters
     */
    
    /**
     * Gets the license plate of the vehicle
     * @return plate
     */
    
    public String getPlate() {
        return plate;
    }

     /**
     * Modify the license plate of the vehicle
     * @param plate 
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }
    
    /**
     * Gets the vehicle's type
     * @return 
     */
    public TypeEnum getType() {
        return type;
    }
    
    /**
     * Modify the vehicle's type
     * @param type 
     */
    public void setType(TypeEnum type) {
        this.type = type;
    }


    /**
     * Print vehicle information in a string
     * @param plate
     * @param type
     * @return string with vehicle information
     */
    
    public String toString(){
        return type + " with license plate ["+ plate + "]";
    }
}
