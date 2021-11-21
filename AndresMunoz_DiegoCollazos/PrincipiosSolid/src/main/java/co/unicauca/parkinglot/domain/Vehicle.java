package co.unicauca.parkinglot.domain;
/**
* +--------------------------------------------------------------------------------------+
* | DESCRIPCION: Vehicle - permite el manejo de la información base de un vehículo. 
* | ESTUDIANTE: Andrés david Muñoz Cerón - Diego Collazos Perafan 
* | FECHA: 17/11/2021
* +--------------------------------------------------------------------------------------+
*/

/*Class*/
public class Vehicle {
    
    /*Variables type -> tipo de auto, plate -> placas del auto*/
    private String plate;
    private TypeEnum type;
    
    /*Constructor*/
    public Vehicle() {
        plate = null;  
        type  = null;  
    }

    /*Constructor*/
    public Vehicle(String plate, TypeEnum tipo) {
        this.plate = plate;
        this.type = tipo;
    }
    
    /*Getters/Setters*/
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
