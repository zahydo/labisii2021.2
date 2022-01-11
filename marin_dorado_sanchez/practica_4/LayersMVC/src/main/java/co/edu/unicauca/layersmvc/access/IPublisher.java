/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.layersmvc.access;
import co.edu.unicauca.layersmvc.domain.Product;


/**
 *
 * @author Fabián David Marín, Héctor Fernando Dorado, Juán Sebastián Sánchez
 */
public interface IPublisher{
    
    public void Publish(Product producto, String accion) throws Exception;
    
}
