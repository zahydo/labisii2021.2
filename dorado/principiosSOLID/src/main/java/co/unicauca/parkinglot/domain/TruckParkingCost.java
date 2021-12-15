
package co.unicauca.parkinglot.domain;

/**
 * @authores Fabián David Marín(fabianxd0496@unicauca.edu.co) 
 *           Hector Fernando Dorado(hfdorado@unicauca.edu.co)
 *           Juan Sebastian Sánchez Pizo(spjuan@unicauca.edu.co)
 */
public class TruckParkingCost extends IParkingCost {

    /**
     *
     * @param minutes
     * @return
     *
     * Se calcula la tarifa de los Camiones
     */
    public int calculateCost(int minutes) {
        tarifa = 15000;
        if (minutes <= 720) {
            tarifa = 10000;
        } else if (minutes > 1440) {
            int dias = minutes / 1440;
            minutes = minutes - (dias * 1440);
            int horas = minutes / 60;
            minutes = minutes - (horas * 60);
            dias = dias * 15000;
            horas = horas * 625;
            tarifa = (dias + horas);
            tarifa = redondear(tarifa);
        }
        if (Sortear()) {
            tarifa = 0;
        }
        return tarifa;
    }

    /**
     *
     * Sorteo requerido por el taller
     */
    private boolean Sortear() {
        int numeroAleatorio = (int) (Math.random() * (10000 - 1)) + 1;
        return tarifa % numeroAleatorio == 0;
    }
}
