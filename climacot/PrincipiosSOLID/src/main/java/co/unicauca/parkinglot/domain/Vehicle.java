package co.unicauca.parkinglot.domain;

public class Vehicle {

    /**
     * Atributos
     */
    private String plate;
    private TypeEnum type;

    /**
     * Constructor con parametros
     *
     * @param plate
     * @param type
     */
    public Vehicle(String plate, TypeEnum type) {
        this.plate = plate;
        this.type = type;
    }

    /**
     * Constructor por defecto
     */
    public Vehicle() {
    }

    /**
     * get de la placa para un vehiculo en especifico
     *
     * @return string placa
     */
    public String getPlate() {
        return plate;
    }

    /**
     * set de la placa para un vehiculo en especifico
     *
     * @param plate
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * get del tipo de vehiculo
     *
     * @return TypeEnum Type
     */
    public TypeEnum getType() {
        return type;
    }

    /**
     * set de Tipo de vehiculo
     *
     * @param type
     */
    public void setType(TypeEnum type) {
        this.type = type;
    }

    /**
     * Impresion de atributos en formato string
     *
     * @return plate, type
     */
    @Override
    public String toString() {
        return "Vehicle{" + "plate=" + plate + ", type=" + type + '}';
    }
}
