# Practica: RabbitMQ PublisherSusbcriber
## Integrantes 
Andrés David Muñoz
Eliana Cerquera Yacumal
Diego Collazos Perafan

## Proceso para correr el programa por CLI:

### *Limpiar, instalar dependencias y construir .jar:* Ubicarse en las carpetas correspondientes. 

1. ..\PracticaRabbitMQPublisherSuscriber\LayersMVC:
```
mvn clean install package
```

2. ..\PracticaRabbitMQPublisherSuscriber\Subscriber1
```
mvn clean install package 
```

3. ..\PracticaRabbitMQPublisherSuscriber\Subscriber2
```
mvn clean install package 
```

### *Ejecutar los .jar*
Ubicarse en la terminal en las carpetas correspondientes y correr los siguientes comandos:

1. ..\PracticaRabbitMQPublisherSuscriber\LayersMVC:
```
java -cp target/LayersMVC-1.jar co.edu.unicauca.layersmvc.presentation.ClientMain
```

2. ..\PracticaRabbitMQPublisherSuscriber\Subscriber1
```
java -cp target/Subscriber1-1.0-SNAPSHOT.jar com.mycompany.subscriber.presentacion.principal
```

3. ..\PracticaRabbitMQPublisherSuscriber\Subscriber2
```
java -cp target/Subscriber2-1.0-SNAPSHOT.jar com.mycompany.subscriber.presentation.principal
```