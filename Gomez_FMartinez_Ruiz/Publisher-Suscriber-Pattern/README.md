### Integrantes 

- Angie Carolina Gómez Acosta
- Maria Fernanda Martinez Moreno
- Juan Esteban Ruiz Benavides

### Este proyecto fue creado con Maven y es necesario tenerlo instalado en tu equipo, del mismo modo que se hace uso de la virtualización de Docker por lo que es necesario tenerlo
## Primero se encapsula el servicio de Rabbit con Docker 
```
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 -d rabbitmq:3.9-management
```
## En el terminal haciendo uso de cd se posiciona en la raiz del proyecto Publicador con una ruta similar a esta 
```
...\Gomez_FMartinez_Ruiz\Publisher-Suscriber-Pattern\LayersMVC
```
## Se limpia y construye 
```
mvn clean install package 
```
## Se replica lo anterior para el proyecto Suscriptor
```
...\Gomez_FMartinez_Ruiz\Publisher-Suscriber-Pattern\SubscriberLayers
```
## Se limpia y construye
```
mvn clean install package 
```
## Se ejecuta el propgrama principal desde la ruta del Publicador
```
java -cp target\LayersMVC-1.jar co.edu.unicauca.layersmvc.presentation.ClientMain
```