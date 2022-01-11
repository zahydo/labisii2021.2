## Descripción
Este proyecto fue creado con Maven y es necesario tenerlo instalado en tu equipo, del mismo modo que se hace uso de la virtualización de Docker por lo que es necesario tenerlo.

### Integrantes 

- Angie Carolina Gómez Acosta
- Maria Fernanda Martinez Moreno
- Juan Esteban Ruiz Benavides

## Primero se encapsula el servicio de Rabbit con Docker 
```
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 -d rabbitmq:3.9-management
```
## En el terminal haciendo uso de cd se posiciona en la raiz de cada uno de los proyectos
```
...\Gomez_FMartinez_Ruiz\Publisher-Suscriber-Pattern\LayersMVC
...\Gomez_FMartinez_Ruiz\Publisher-Suscriber-Pattern\Subscriber1
...\Gomez_FMartinez_Ruiz\Publisher-Suscriber-Pattern\Subscriber2
```
## Se limpia y construye (uno a uno)
```
mvn clean install package 
```
## Se ejecuta el programa principal desde la ruta del Publicador (LayersMVC)
```
java -cp target/LayersMVC-1.jar co.edu.unicauca.layersmvc.presentation.ClientMain
```

## Se ejecuta el suscriptor 1 desde el directorio Subscriber1
```
java -cp target/Subscriber1-1.0-SNAPSHOT.jar co.edu.unicauca.subscriberlayers.presentation.Main
```

## Se ejecuta el suscriptor 2 desde el directorio Subscriber2
```
java -cp target/Subscriber2-1.0-SNAPSHOT.jar co.edu.unicauca.subscriberlayers.presentation.Main
```