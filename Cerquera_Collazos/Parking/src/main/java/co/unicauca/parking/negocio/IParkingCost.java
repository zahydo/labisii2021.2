/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.parking.negocio;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Yenny Eliana Cerquera
 */
public interface IParkingCost {
    
    //
    //Atributos
    //
    Vehicle vehiculo = new Vehicle();
    Date horaEntrada = new Date();
    Date horaSalida = new Date();
    
    public long calculatecost(Vehicle veh, LocalDateTime horaEntrada, LocalDateTime horaSalida); 
    public int calcularHoras(LocalDateTime horaEntrada, LocalDateTime horaSalida);
    public long redondeo(long numero);
}
