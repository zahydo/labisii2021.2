
package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.CarParkingCost;
import co.unicauca.parkinglot.domain.MotoParkingCost;
import co.unicauca.parkinglot.domain.TruckParkingCost;
import co.unicauca.parkinglot.domain.TypeEnum;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @authores Fabián David Marín(fabianxd0496@unicauca.edu.co) 
 *           Hector Fernando Dorado(hfdorado@unicauca.edu.co)
 *           Juan Sebastian Sánchez Pizo(spjuan@unicauca.edu.co)
 */
public class Service {

    private IVehicleRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de IVehicleRepository
     */
    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * Metodo para guardar un vehiculo
     */
    public boolean saveVehicle(Vehicle newIngreso) {

        //Validate product
        if (newIngreso == null || newIngreso.getType().toString().isEmpty()) {
            return false;
        }

        repository.save(newIngreso);
        return true;

    }

    /**
     * Metodo que crea la lista de vehiculos
     */
    public List<Vehicle> listVehicles() {
        List<Vehicle> Ingresos = new ArrayList<>();
        Ingresos = repository.list();

        return Ingresos;
    }

    /**
     *
     * Metodo para redondear el valor de la tarifa
     */
    protected int redondear(int valor) {
        int residuo = valor % 100;
        if (residuo != 0) {
            valor += 100 - residuo;
        }
        return valor;
    }
    int tarifa = 0;

    /**
     *
     * Metodo que Calcula la tarifa de cada vehiculo dependiendo del tipo que
     * sea se llama a la clase que realiza la operacion.(Para no incumplir los
     * proncipios solid)
     */
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        int minutes = CalcularMinutos(input, output);

        if (veh.getType().equals(TypeEnum.MOTO)) {
            MotoParkingCost Moto = new MotoParkingCost();
            tarifa = Moto.calculateCost(minutes);
            return tarifa;
        }

        if (veh.getType().equals(TypeEnum.TRUCK)) {
            TruckParkingCost Truck = new TruckParkingCost();
            tarifa = Truck.calculateCost(minutes);
            return tarifa;
        }

        if (veh.getType().equals(TypeEnum.CAR)) {
            CarParkingCost Car = new CarParkingCost();
            tarifa = Car.calculateCost(minutes);
            return tarifa;
        }

        return tarifa;
    }

    /**
     * Metodo que calcula los minutos que tienen de diferencia dos fechas
     */
    public int CalcularMinutos(LocalDateTime input, LocalDateTime output) {
        int resultado = 0;
        long days = ChronoUnit.MINUTES.between(input, output);
        resultado = (int) days;
        return resultado;
    }
}
