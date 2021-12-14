
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;

/**
 * @authores Fabián David Marín(fabianxd0496@unicauca.edu.co) 
 *           Hector Fernando Dorado(hfdorado@unicauca.edu.co)
 *           Juan Sebastian Sánchez Pizo(spjuan@unicauca.edu.co)
 */

public interface IVehicleRepository {
    boolean save(Vehicle newProduct);

    List<Vehicle> list();
}
