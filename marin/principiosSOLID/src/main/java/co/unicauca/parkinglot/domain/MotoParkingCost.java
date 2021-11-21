package co.unicauca.parkinglot.domain;

/**
 * @authores Fabián David Marín(fabianxd0496@unicauca.edu.co) 
 *           Hector Fernando Dorado(hfdorado@unicauca.edu.co)
 *           Juan Sebastian Sánchez Pizo(spjuan@unicauca.edu.co)
 */
public class MotoParkingCost extends IParkingCost {
/**
 * 
 * Se calcula la tarifa de las Motos
 * 
     * @param minutos
     * @return 
 */
    @Override
    public int calculateCost(int minutos) 
    {
        tarifa = 2000;
        if (minutos < 60) {
            return 1000;
        }
        else{
            tarifa += (minutos - 60) * 25/1.5;
            tarifa = redondear(tarifa);
        }
        
        return tarifa;
    }
}
