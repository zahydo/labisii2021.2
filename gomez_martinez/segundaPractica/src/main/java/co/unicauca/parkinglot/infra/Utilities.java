package co.unicauca.parkinglot.infra;

/**
 * @author angiecgomez
 * @author mafemartinez
 */
public class Utilities {
    
    /**
     * Round a number 
     * @param value
     * @return value
     */
    public static long round(long value){
        
        if (value%100 != 0) {
            
            long temp = value%1000 - value%100;
            temp += 100;
            value -= value%1000;
            value += temp;
        }
        return value;
    }
}
