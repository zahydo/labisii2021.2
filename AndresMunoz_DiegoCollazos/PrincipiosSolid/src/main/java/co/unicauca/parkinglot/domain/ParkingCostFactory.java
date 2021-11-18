package co.unicauca.parkinglot.domain;
/**
* +--------------------------------------------------------------------------------------+
* | DESCRIPCION: ParkingCostFactory - Gestiona los tipos de cobros de parqueo frente 
* | a un tipo de automovil. 
* | ESTUDIANTE: Andrés david Muñoz Cerón - Diego Collazos Perafan 
* | FECHA: 17/11/2021
* +--------------------------------------------------------------------------------------+
*/

/*Librerias de tipo ENUM, y MAP*/
import java.util.EnumMap;
import java.util.Map;

/*Class*/
public class ParkingCostFactory {
    /*Diccionario de datos */
    private Map<TypeEnum, IParkingCost> Dictionary; 
    /*Instancia de clase*/
    private static ParkingCostFactory instance; 
    
    /*constructor de la fábrica*/
    private ParkingCostFactory(){
        Dictionary = new EnumMap<>(TypeEnum.class); 
        Dictionary.put(TypeEnum.CAR, new CarParkingCost()); 
        Dictionary.put(TypeEnum.MOTO, new MotoParkingCost()); 
        Dictionary.put(TypeEnum.TRUCK, new TruckParkingCost()); 
    }
    
    /*Getter*/
    public static ParkingCostFactory getInstance(){
        if(instance == null){
            instance = new ParkingCostFactory(); 
        }
        return instance;  
    }
    
    /*Getter de instancia - IParkingCost*/
    public IParkingCost getParkingCost(TypeEnum veh){
        IParkingCost result = null; 
        if(Dictionary.containsKey(veh)){
            result = Dictionary.get(veh); 
        }
        return result;  
    }

}
