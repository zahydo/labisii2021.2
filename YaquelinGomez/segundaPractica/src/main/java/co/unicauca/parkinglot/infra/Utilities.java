/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.infra;

/**
 * class Utilities
 * Utilidades del programa: Redondeo del valor a pagar 
 * @author YAQUE
 */
public class Utilities {
    /**
     * Metodo que redondea el valor a pagar a la centena mas cercana por encima 
     * @param cost Valor a pagar sin redondeo 
     * @return Valor a pagar redondeado
     */
    static public long redondeo(double cost){
               
        if(cost%100==0){
            return (long)cost;
        }
        long aux = (long)(cost/100)+1;
        return aux*100;      
    }
}
