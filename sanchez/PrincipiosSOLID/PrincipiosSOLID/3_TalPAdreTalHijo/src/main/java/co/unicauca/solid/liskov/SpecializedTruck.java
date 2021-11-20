package co.unicauca.solid.liskov;

/**
 *
 * @author Libardo, Julio
 */
public class SpecializedTruck extends Truck {

    public SpecializedTruck(String plateNumber, double odometer) {
        super(plateNumber, odometer);
    }
    @Override
    public void addTrip(Trip newTrip) {
        super.addTrip(newTrip);

        //Update odometer.
        for(Trip trip: trips){
            odometer += trip.getDistance();
        }

    }
}
