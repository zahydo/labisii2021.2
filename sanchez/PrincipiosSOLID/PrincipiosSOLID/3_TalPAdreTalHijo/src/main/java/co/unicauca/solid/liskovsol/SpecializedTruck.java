package co.unicauca.solid.liskovsol;

/**
 *
 * @author Libardo, Julio
 */
public class SpecializedTruck extends Truck {
    private double totalDistance;

    public SpecializedTruck(String plateNumber, double odometer) {
        super(plateNumber, odometer);
        totalDistance = 0;
    }
    @Override
    public void addTrip(Trip newTrip) {
        super.addTrip(newTrip);
        //Update the distance else the odometer
        for(Trip trip: trips){
            totalDistance += trip.getDistance();
        }

    }

    /**
     * @return the totalDistance
     */
    public double getTotalDistance() {
        return totalDistance;
    }

    /**
     * @param totalDistance the totalDistance to set
     */
    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }
}
