/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.layersmvc.infra;

/**
 *
 * @author Servitech D&M
 */
public class Notify extends Subject{
    
    public void NotifyAllObserves(String prmEtiqueta,String prmDatosProductos,String prmTipoAccion){
        this.notifyAllObserves(prmEtiqueta, prmDatosProductos, prmTipoAccion);
    }
}
