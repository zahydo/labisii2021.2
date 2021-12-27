# Practica_4 - Arquitectura Orientada A Eventos - publiser-suscriber

Realizado con Maven - Java

## Trabajo Realizado:
```
-se modifico el LayerMVC para que enviara un mensaje a los suscriptores cada que se agregue o modifique un producto.
-se creo un proyecto suscriptor el cual recibe el mensaje que envio el emisor y dependiendo del mensaje agrega o modifica
un producto en una base de datos.
-se creo un proyecto suscriptor el cual recibe el mensaje que envio el emisor y dependiendo del mensaje agrega o modifica
un producto en memoria.
```
## Proceso para correr el programa por CLI:

## Inicializar Rabbit con docker:

docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 -d rabbitmq:3.9-management

## Limpiar, instalar dependencias y construir .jar:
```
1. Ubicarse dentro de la carpeta LayerMVC: 
mvn clean install package
2. Ubicarse dentro de la carpeta RabbitMQ-Recep-BD:
mvn clean install package 
3.Ubicarse dentro de la carpeta RabbitMQ-Recep-Memoria:
mvn clean install package 
```


## Ubicarse en LayerMVC :
java -cp target/LayersMVC-1.jar co.edu.unicauca.layersmvc.presentation.ClientMain
## Ubicarse en RabbitMQ-Recep-BD :
java -cp target/RabbitMQ-Examples-1.0-SNAPSHOT Presentacion.Receptor
## Ubicarse en RabbitMQ-Recep-Memoria:
java -cp target/RabbitMQ-Recep-Memoria-1.0-SNAPSHOT Presentacion.Receptor


java -cp "./*:./plugins/*" co.unicauca.microkernel.app.Application
```

