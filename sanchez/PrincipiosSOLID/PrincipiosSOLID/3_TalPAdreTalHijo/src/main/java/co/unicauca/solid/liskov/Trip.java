package co.unicauca.solid.liskov;

/**
 * Viaje. Es una entidad plana
 *
 * @author Libardo, Julio
 */
public class Trip {

    private int originLatitude;
    private int originLongitude;
    private int destinationLatitude;
    private int destinationLongitude;
    private double distance;

    public Trip(int originLatitude, int originLongitude, int destinationLatitude, int destinationLongitude, double distance) {
        this.originLatitude = originLatitude;
        this.originLongitude = originLongitude;
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
        this.distance = distance;
    }

    public int getOriginLatitude() {
        return originLatitude;
    }

    public void setOriginLatitude(int originLatitude) {
        this.originLatitude = originLatitude;
    }

    public int getOriginLongitude() {
        return originLongitude;
    }

    public void setOriginLongitude(int originLongitude) {
        this.originLongitude = originLongitude;
    }

    public int getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(int destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public int getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(int destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

}
