package co.unicauca.microkernel.common.entities;

/**
 * Envio
 * @author Libardo, Julio
 */
public class Delivery {

    private Product product;
    private double distance;
    /**
     * Código del país donde será entregado el producto.
     * */
    private String countryCode;
    
    /**
     * Tipo moneda en cada pais
     */
    private String TipoMoneda;
    
    /*
    * Identificar Moneda
    */
    private String Moneda;
    public Delivery(Product product, double distance, String countryCode) {
        this.product = product;
        this.distance = distance;
        this.countryCode = countryCode;
        this.TipoMoneda = (countryCode.equals("cs")) ? "wones surcoreanos":(countryCode.equals("co")||countryCode.equals("mx")) ?"Pesos" :
                (countryCode.equals("pe"))?"soles":(countryCode.equals("ch")? "Yuanes":"");
        this.Moneda = (countryCode.equals("cs")) ? "Sur Coreana":(countryCode.equals("co"))? "Colombiana" :
                (countryCode.equals("pe"))?"Peruana":(countryCode.equals("mx"))? "Mexicana":
                (countryCode.equals("ch")? "China":"");
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    public String getTipoMoneda(){
        return TipoMoneda;
    }
    public String getMoneda(){
        return Moneda;
    }
}
