/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.tallerpolimorfismo.modelo;


import java.util.Date;

/**
 *
 * @author Sebastian
 */
public class ViajeIndividual extends Viaje {
// Constructor

    public ViajeIndividual(String origen, String destino, int costo, Date fechaSAlida, Date fachaLlegada) {
        super(origen, destino, costo, fechaSAlida, fachaLlegada);
    }

    @Override
    public String descripcion() {
        return "Disfruta tu viaje individual";
    }
//No se sobreescribe cualquierMetodo2()
}
