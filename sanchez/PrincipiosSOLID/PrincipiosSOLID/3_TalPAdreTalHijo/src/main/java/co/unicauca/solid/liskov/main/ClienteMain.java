package co.unicauca.solid.liskov.main;

import co.unicauca.solid.liskov.Trip;
import co.unicauca.solid.liskov.Truck;
import co.unicauca.solid.liskov.SpecializedTruck;

/**
 *
 * @author Libardo, Julio
 */
public class ClienteMain {

    public static void main(String args[]) {
        final double InitialDistance = 10000;
        Truck truck = new SpecializedTruck("QET680", InitialDistance);
        truck.addTrip(new Trip(0,0,0,0,60.0));
        if (truck.getOdometer() == InitialDistance) {
            System.out.println("Odometer is correct.");
        } else {
            System.out.println("Odometer has been modified. LSK violation");

        }

    }
}
