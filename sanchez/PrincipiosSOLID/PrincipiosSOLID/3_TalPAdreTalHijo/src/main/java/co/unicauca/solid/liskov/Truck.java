package co.unicauca.solid.liskov;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Camión
 *
 * @author Libardo, Julio
 */
public class Truck {

    /**
     * Placa
     */
    protected String plateNumber;

    /**
     * Almacena la distancia recorrida por el vehiculo
     */
    protected double odometer;
    /**
     * Lista de viajes que el vehículo ha realizado
     */
    protected List<Trip> trips;

    public Truck(String plateNumber, double odometer) {
        this.plateNumber = plateNumber;
        this.odometer = odometer;
        this.trips = new ArrayList<Trip>();
    }

    /**
     * Permite agregar un nuevo viaje a la colección trips, sin que afecte el
     * odómetro. Por diseño, no queremos que un viaje afecte el odómetro, habrá
     * otro componente que se encargue de esa responsabilidad.
     *
     * @param newTrip
     */
    public void addTrip(Trip newTrip) {
        trips.add(newTrip);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

}
