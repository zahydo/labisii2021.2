package com.unicauca.parkinglot.infra;

import java.time.Duration;
import java.time.LocalDate;

import com.unicauca.parkinglot.domain.TypeEnum;

public class Utilities {

    public static Duration calculateDuration(LocalDate input, LocalDate output) {
        return (input.compareTo(output) == -1) ? (Duration.between(input, output)) : null;
    }

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
