/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author 57322
 */
public class TruckParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        //Valores
        long valorFijo = 15000;//Día
        double horas = 0;
        double minutos = 0;
        int dias = 0;
        double decuento = 0.0;

        minutos = Math.abs(output.getMinute() - input.getMinute());//Se obtiene el valor absoluto de la diferencia de la diferencia de los minutos d esalida y entrada
        dias = output.getDayOfYear() - input.getDayOfYear();//En caso de se haya estado más de un día
        horas = output.getHour() - input.getHour() + (minutos / 60); //Calcula las horas + los días en horas + los minutos en horas

        System.out.println("");
        // if (ganoDescuento()) {
        //  return 0;
        // }

        //1+1+1  = 3 dias
        //1 h 15 mins -> 9 - 8 = 1.25
        if (horas <= 12 && dias == 0) { //Si estuvo menos d euna hora, salga
            return 10000;
        } else if (horas <= 24 && horas > 12 && dias == 0) {
            return 15000;
        }

        System.out.println("Dias" + dias);
        System.out.println("Horas" + horas);
        long result = (valorFijo * dias) + Math.round((horas * 15000) / 24); //Si estuvo más de una hora
        System.out.println("Result Antes" + result);
        float r = (float) result / 100;
        r = (float) Math.round((double) r);
        r = (r) * 100;
        result = (new Double(r)).longValue();
        System.out.println("Result Después" + result);
        return result;
    }

    private boolean ganoDescuento() {
        Scanner entrada = new Scanner(System.in);
        int intentos = 3; //Tiene 3 intentos para acertar
        int numRandom = (int) (Math.random() * 10);
        System.out.println("ADIVINA EL NÚMERO Y GANA UN DESCUENTO");
        while (intentos != 0) {
            System.out.println("Te quedan:" + intentos + " " + "Intentos");
            System.out.println("¿Cuál es el número oculto?");
            int response = entrada.nextInt();

            if (response == numRandom) {
                System.out.println("GANASTE!");
                return true;
            }
            intentos--;
        }
        System.out.println("Ups! En esta ocasión NO ganaste");
        return false;

    }

}
