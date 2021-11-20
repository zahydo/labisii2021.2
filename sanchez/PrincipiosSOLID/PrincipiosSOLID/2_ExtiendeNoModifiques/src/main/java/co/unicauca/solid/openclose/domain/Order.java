
package co.unicauca.solid.openclose.domain;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class Order {
    private CountryEnum country;
    private double weight;
    private double total;

    public Order(CountryEnum country, double weight, double total) {
        this.country = country;
        this.weight = weight;
        this.total = total;
    }

    
    public CountryEnum getCountry() {
        return country;
    }

    public void setCountry(CountryEnum country) {
        this.country = country;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
