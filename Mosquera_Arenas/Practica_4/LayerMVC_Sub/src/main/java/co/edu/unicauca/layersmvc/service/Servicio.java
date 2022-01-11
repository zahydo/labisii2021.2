/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.layersmvc.service;

import co.edu.unicauca.layersmvc.access.IProductRepository;
import co.unicauca.layersmvc.commons.Product_protocol;

/**
 *
 * @author David E
 */
public class Servicio {
    
    private IProductRepository repositorio;
    
    public Servicio(IProductRepository repositorio){
        this.repositorio = repositorio;
    }
    
    public boolean actionRepository( Product_protocol protocolp){
        if (protocolp.getAccion().equals("save")){
           return repositorio.save(protocolp.getProducto());
        }else if(protocolp.getAccion().equals("update")){
           return repositorio.update(protocolp.getProducto());
        }
        return false;
    }
}
