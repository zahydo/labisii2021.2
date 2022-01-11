/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.subscriber.presentation;

import com.mycompany.subscriber.domain.service.ServiceModel;
import com.mycompany.subscriber.infra.ISubscriber;
import com.mycompany.subscriber.infra.RabbitMQSubscriber;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Controlador implements ISubscriber{
    ServiceModel service; 
    
    public Controlador(){
        service = new ServiceModel(); 
        Runnable suscriber = new RabbitMQSubscriber(this);
        new Thread(suscriber).start();
    }
    
    @Override
    public void onMessage(String msg) {
        try {
            service.gestionarMsg(msg);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
