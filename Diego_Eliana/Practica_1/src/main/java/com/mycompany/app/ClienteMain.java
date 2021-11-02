package com.mycompany.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteMain {
	
	/**
	* Arreglo polim�rfico de viajes
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Viaje> viajes = new ArrayList();
   
    public static void main(String[] args) {
       leerViajes();
	   mostrarViajes();  
    }
    
    public static void leerViajes() {
        try {
            Viaje viaje1 = new ViajeFamiliar("Popay�n", "Bogot�", 1250000, new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2019"), 5);
            viajes.add(viaje1);
            Viaje viaje2 = new ViajeIncentivo("Popay�n", "Medellin", 2100000, new SimpleDateFormat("dd/MM/yyyy").parse("03/06/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2019"), "Emtel");
            viajes.add(viaje2);
            Viaje viaje3 = new ViajeIndividual("Popay�n", "San Andres", 4250000,
                    new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
            viajes.add(viaje3);
            Viaje viaje4 = new ViajeTodoIncluido("Popay�n", "Cartagena", 7350000,
                    new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
            viajes.add(viaje4);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void mostrarViajes(){
        if ( !viajes.isEmpty()) {
            for(int i = 0; i < viajes.size() ; i++){
                mostrarViaje(viajes.get(i)); 
            }
        }else{
            System.out.println("No existe registro de viajes");
        }
    }
    
    private static void mostrarViaje(Viaje v_viaje){
        System.out.println("Origen: " + v_viaje.getOrigen());
        System.out.println("Destino: " + v_viaje.getDestino());
        System.out.println("Fecha salida: " + v_viaje.getFechaSalida());
        System.out.println("Fecha llegada: " + v_viaje.getFechaLlegada());
        System.out.println("Costo: " + v_viaje.getCosto());
        System.out.println("Descripci�n: " + v_viaje.descripcion());
        System.out.println("Cualquier m�todo: " + v_viaje.cualquierMetodo());
        System.out.println("Cualquier m�todo2: " + v_viaje.cualquierMetodo2());
        System.out.println("");
    }    
}