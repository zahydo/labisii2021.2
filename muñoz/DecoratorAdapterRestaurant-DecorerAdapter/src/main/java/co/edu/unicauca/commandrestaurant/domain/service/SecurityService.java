/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.commandrestaurant.domain.service;

import co.edu.unicauca.commandrestaurant.infra.Security;

/**
 *
 * @author ASUS
 */
public class SecurityService {
    public static String decode(String cadena) throws Exception{
        return (new Security()).descifrar(cadena);     
    }
    
    public static String encode(String cadena) throws Exception{
       return (new Security()).cifrar(cadena); 
    }
}
