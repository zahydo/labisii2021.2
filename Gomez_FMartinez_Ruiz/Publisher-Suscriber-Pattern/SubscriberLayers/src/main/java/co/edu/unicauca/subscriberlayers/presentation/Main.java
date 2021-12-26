/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.subscriberlayers.presentation;

import co.edu.unicauca.layersmvc.infra.RabbitSubscriber;

/**
 *
 * @author XssIsor
 */
public class Main {
    
    
      public static void main(String[] args) throws Exception {
        RabbitSubscriber subscriber = new RabbitSubscriber();
        new Thread(subscriber).start();
        
        
    }
}
