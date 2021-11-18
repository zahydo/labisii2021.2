/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import co.unicauca.parkinglot.infra.Utilities;
import java.time.LocalDateTime;

/**
 *
 * @author Kevin Daryany Morales
 */
public class TruckParkingCost implements IParkingCost{

    @Override
        /**
     * Calcula los costos de la tarifa
     * @param Vehicle
     * @param entrada_hora
     * @param salida_hora
     * @return result
     */
    
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        int vDife[] = Utilities.gerDiferencia(input, output);
        int horas = vDife[0]*24+vDife[1];
        int minutos = vDife[2];
        long result;

        if ((horas<=11 && minutos<=59) || (horas==12 && minutos==0)) {
            return 10000;
        }else if((horas<=23 && minutos<=59) || (horas==24 && minutos==0)){
            return 15000;
        }else{
            float aux = ((float)(15000*vDife[1]))/24;
            result = vDife[0]*15000 + (long)aux;
        }
        return Utilities.redondeo(result);
    }
    
}
