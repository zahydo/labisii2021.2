/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.infra;

/**
 * class Lottery
 * Sorteo para benefio en pago de parqueadero de los camiones
 * @author YAQUE
 */
public class Lottery {
    /**
     * Metodo para beneficio de pago parqueadero
     * Genera un numero aleatorio y lo compara con el numero que recibe 
     * @param n numero para participar
     * @return 0 si gana el beneficio, numero entero de lo contrario
     */
    static public int getLottery(int n){
        int aux = (int)(Math.random()*100+1);            
        if(aux==n){
            return 0;
        }
        return aux;
    }
    
}
