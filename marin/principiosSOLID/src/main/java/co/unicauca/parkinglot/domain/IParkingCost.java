
package co.unicauca.parkinglot.domain;

/**
 * @authores Fabián David Marín(fabianxd0496@unicauca.edu.co) 
 *           Hector Fernando Dorado(hfdorado@unicauca.edu.co)
 *           Juan Sebastian Sánchez Pizo(spjuan@unicauca.edu.co)
 */
public abstract class IParkingCost {

    protected int tarifa;

    protected int redondear(int valor) {
        int residuo = valor % 100;
        if (residuo != 0) {
            valor += 100 - residuo;
        }
        return valor;
    }

    abstract public int calculateCost(int minutos);
}
