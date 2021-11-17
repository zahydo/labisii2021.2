package co.unicauca.parkinglot.domain;

public class Vehicle {

    private String plate;
    private TypeEnum type;

    public Vehicle() {
        plate = null;  
        type  = null;  
    }

    public Vehicle(String plate, TypeEnum tipo) {
        this.plate = plate;
        this.type = tipo;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }
    
    @Override
    public String toString(){
        return "Tipo: " + type.toString() + " Placa: " + plate;  
    }

}
