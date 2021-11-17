package com.unicauca.parkinglot.infra;

import java.time.Duration;
import java.time.LocalDate;

import com.unicauca.parkinglot.domain.TypeEnum;

public class Utilities {

    
    /** 
     * @param input
     * @param output
     * @return Duration
     */
    public static Duration calculateDuration(LocalDate input, LocalDate output) {
        return (input.compareTo(output) == -1) ? (Duration.between(input, output)) : null;
    }

    
    /** 
     * @param type
     * @return String
     */
    public static String enumToString(TypeEnum type){
        switch (type) {
            case CAR:
                return "CAR";
            case MOTO:
                return "MOTO";
            case TRUCK:
                return "TRUCK";
            default:
                return null;
        }
    }
    
    
    /** 
     * @param type
     * @return TypeEnum
     */
    public static TypeEnum stringToEnum(String type){
        switch (type) {
            case "CAR":
                return TypeEnum.CAR;
            case "MOTO":
                return TypeEnum.MOTO;
            case "TRUCK":
                return TypeEnum.TRUCK;
            default:
                return null;
        }
    }

}
