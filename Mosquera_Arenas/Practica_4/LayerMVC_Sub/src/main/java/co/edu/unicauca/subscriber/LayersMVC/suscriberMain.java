/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.unicauca.subscriber.LayersMVC;



import co.edu.unicauca.layersmvc.access.Factory;
import co.edu.unicauca.layersmvc.access.IProductRepository;
import co.edu.unicauca.layersmvc.suscriber.ISuscriber;
import co.edu.unicauca.layersmvc.suscriber.RabbitMQ_suscriber;

/**
 *
 * @author Sebastian_Arenas
 */

public class suscriberMain {


    public static void main(String[] argv) {
        
        System.out.println("Bienveido");
        System.out.println(argv[0]);
        
        IProductRepository repositorio = Factory.getInstance().getRepository(argv[0]);

        ISuscriber suscriber = new RabbitMQ_suscriber(repositorio);

        suscriber.receive();

    }

}
