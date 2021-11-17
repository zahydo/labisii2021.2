/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.infra;

/**
 * Permite jugar la loteria 
 * @author Jose_R
 */
public class Lottery {
    /**
     * Metodo que permite jugar la loteria
     * @param n numero del participante
     * @return true si el participante gana, false en el contrario
     */
    static public boolean getLottery(int n) {
        System.out.println("Numero jugado: " + n);
        int aux = (int) (Math.random() * 1000 + 1);
        System.out.println("Numero del sorteo: " + aux);
        if (aux == n) {
            System.out.println("Ganaste el servicio es gratis");
            return true;
        }
        System.out.println("Vuelve a intentarlo");
        return false;
    }

}
