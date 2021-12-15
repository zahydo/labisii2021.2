package co.unicauca.parkinglot.domain;

public class Vehicle {
    private String Plate; 
    private TypeEnum type; 

    public Vehicle() {}

    public Vehicle(String Plate, TypeEnum type) {
        this.Plate = Plate;
        this.type = type;
    }

    public String getPlate() {
        return Plate;
    }

    public void setPlate(String Plate) {
        this.Plate = Plate;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }
    
   @Override
   public String toString(){
      return this.Plate;  
   }
    
}
