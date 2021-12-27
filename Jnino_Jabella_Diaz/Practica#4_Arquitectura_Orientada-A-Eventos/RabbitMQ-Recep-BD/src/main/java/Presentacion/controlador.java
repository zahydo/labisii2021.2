/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Dominio.Product;
import com.google.gson.Gson;
import Dominio.servicios.ServiceModel;
/**
 *
 * @author Servitech D&M
 */
public class controlador {
    
    
    private ServiceModel model;
    BaseDeDatosReceptor PantallitaBD;
    
    public controlador(){
        model = new ServiceModel();
        PantallitaBD= new BaseDeDatosReceptor(model);
    }
   
    public void Ejecutar(String varDatosRecibidos){
        execute();
        if(varDatosRecibidos!=null){
        String[] varDatosProcesados = SepararMensajes(varDatosRecibidos);
      //  if(varDatosProcesados.length==3){
        AccionBaseDatos(varDatosProcesados[1], varDatosProcesados[2]);
        ActualizarPantalla();
       // }else{
      //      System.out.println("probando error............................................");
       // }
        }
    }
    
    
    private void ActualizarPantalla(){
        model.notifyAllObserves();
    }
    
   
  
            
      public void execute() {
        // Inyección de dependencias
        PantallitaBD.setVisible(true);
        model.addObserver(PantallitaBD);
    }
 
    private String[] SepararMensajes(String prmMsj){
        String[] vardatos ={};
        try {
           vardatos=prmMsj.split("_"); 
        } catch (Exception e) {
        }
        return vardatos;
    }
    private Product CrearObjeto(String prmDatosProducto){
        Gson gson = new Gson();
        Product ProductoNuevo = gson.fromJson(prmDatosProducto, Product.class);
        return ProductoNuevo;
    }
    
    
    private void AccionBaseDatos(String prmDatosProducto,String prmDatosAccion){
        if(prmDatosAccion.equals("Agregar")){
            model.saveProduct(CrearObjeto(prmDatosProducto));
        }else{
            model.updateProduct(CrearObjeto(prmDatosProducto));
        }
    }
    
  
 
    
}
