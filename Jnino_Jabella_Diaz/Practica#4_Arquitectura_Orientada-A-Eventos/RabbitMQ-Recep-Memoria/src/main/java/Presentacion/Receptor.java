/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
//import co.unicauca.rabbitmq.example.controlador;
import rabbitmq.Receptor.ReceiveLogs;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Servitech D&M
 */
public class Receptor { 
    public static void main(String[] argv){
       new Receptor().Ejecutar();
    }
    
    private void Ejecutar(){
         try {
            ReceiveLogs.InicializarReceptor();
        } catch (IOException ex) {
            Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}

