package co.unicauca.infra;

import java.util.Random;

public class Utilities {

    /**
     * takes two pseudo-random generated number (between 1-1000), compares each other and if 
     * they match it returns a bool indicating wether 
     * the discount is applied or not
     * 
     * @return boolean
     */
    public static boolean lottery(){
        Random ran1 = new Random();
        Random ran2 = new Random();

        if(1 + ran1.nextInt(999) == 1 + ran2.nextInt(999)){
            return true;
        }

        return false;
    }
}
