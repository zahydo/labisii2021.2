/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Dominio.Product;
import com.google.gson.Gson;
import java.util.ArrayList;




/**
 *
 * @author Servitech D&M
 */
public class controlador {
    
   ArrayList<Product> ListaProductos;
   
   
    
    public controlador(){

        ListaProductos = new ArrayList<>();
    }
   
    public void Ejecutar(String prmDatosRecibidos){
        String[] vecDatosRecibidos = SepararMensajes(prmDatosRecibidos);
        AccionAgregarModificar(vecDatosRecibidos[1], vecDatosRecibidos[2]);
        ImprimirDatos(ListaProductos, 0);
       
    }
    
    private void ImprimirDatos(ArrayList prmListaDatosRecibidos,int prmIndice){
        if(prmIndice<prmListaDatosRecibidos.size()){
           System.out.println("ID : "+ListaProductos.get(prmIndice).getProductId()+" Nombre: "
           +ListaProductos.get(prmIndice).getName()+" Precio: $"+ListaProductos.get(prmIndice).getPrice()); 
            ImprimirDatos(prmListaDatosRecibidos, prmIndice+1);
        }
    }
    
    
    private String[] SepararMensajes(String prmMsj){
        String[] vardatos = new String[3];
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
    
    
    private void AccionAgregarModificar(String prmDatosProducto,String prmDatosAccion){
        if(prmDatosAccion.equals("Agregar")){
            ListaProductos.add(CrearObjeto(prmDatosProducto));
        }else{
            Product ProductoModificar = CrearObjeto(prmDatosProducto);
            ModificarProducto(ListaProductos, ProductoModificar);
        }
    }
    
    private void ModificarProducto(ArrayList<Product> prmListaProductos,Product prmProductoModificar){
        ModificarProducto(prmListaProductos, prmProductoModificar, 0);
    }
    
    private void ModificarProducto(ArrayList<Product> prmListaProductos,Product prmProductoModificar,int prmIndice){
        if(prmIndice<prmListaProductos.size()){
            if(prmListaProductos.get(prmIndice).getProductId()==prmProductoModificar.getProductId()){
                prmListaProductos.get(prmIndice).setName(prmProductoModificar.getName());
                prmListaProductos.get(prmIndice).setPrice(prmProductoModificar.getPrice());
                prmIndice = prmListaProductos.size();
            }
            ModificarProducto(prmListaProductos,prmProductoModificar,prmIndice+1);
        }
    }
    
  
 
    
}
