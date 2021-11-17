package com.unicauca.parkinglot.infra;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.unicauca.parkinglot.domain.TypeEnum;

public class Utilities {

    public static Map<String, Long> calculateDuration(LocalDate input, LocalDate output) {
        Duration duration = (input.compareTo(output) == -1) ? (Duration.between(input, output)) : null;
        if (duration != null) {
            Map<String, Long> map = new HashMap<String, Long>();
            map.put("hours", duration.toHours());
            map.put("minutes", (duration.toMinutes() % 60));
            return map;
        }
        return null;
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
