/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.subscriber.presentacion;

import com.mycompany.subscriber.domain.service.ServiceModel;

/**
 *
 * @author ASUS
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUIListProductViewController cr = new GUIListProductViewController(new ServiceModel()); 
    }
    
}
