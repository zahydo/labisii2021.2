JOSE RICARDO GALINDEZ LOPEZ
YAQUELIN ALEJANDRA GOMEZ

Practica 7 - Adaptador Chain Solid 09/FMar/2021

# Chain

Para ejecutar el programa principal se ejecutan los siguientes comandos:

Posicionarse en la ubicacion del proyecto: 
cd ..\labisii2021.2\JOSE_GALINDEZ\Practica7-TemplateChain\ChainOfResponsabilityRestaurant

Para compilar el proyecto y generar el .jar
mvn compile
(puede hacer antes mvn clean para limpiar el proyecto)

Para correr el proyecto
mvn exec:java -Dexec.mainClass="co.edu.unicauca.cor.app.Main"
Nota: En caso de no encontrar el ClientMain ejecutar mvn install y correr la la anterior linea

#Template

1) Compilar el proyecto

Para el Common posicionarse en la ubicacion: 
-> cd ..\labisii2021.2\JOSE_GALINDEZ\Practica7-TemplateChain\RestaurantCommon
-> mvn compile

Para el ServerSocket posicionarse en la ubicacion: 
-> cd ..\labisii2021.2\JOSE_GALINDEZ\Practica7-TemplateChain\ServerSocketTemplate
-> mvn compile

Para el server posicionarse en la ubicacion: 
-> cd ..\labisii2021.2\JOSE_GALINDEZ\Practica7-TemplateChain\RestaurantServer
-> mvn compile

Para el cliente posicionarse en la ubicacion: 
-> cd ..\labisii2021.2\JOSE_GALINDEZ\Practica7-TemplateChain\RestaurantClient
-> mvn compile

Para correr el proyecto, primero el servidor
-> cd ..\labisii2021.2\JOSE_GALINDEZ\Practica7-TemplateChain\RestaurantServer
-> mvn exec:java -Dexec.mainClass="co.unicauca.restaurant.server.app.RestaurantAplication"

Luego correr el cliente
-> cd ..\labisii2021.2\JOSE_GALINDEZ\Practica7-TemplateChain\RestaurantClient
-> mvn exec:java -Dexec.mainClass="co.unicauca.restaurant.client.presentation.ClientMain"

Nota: En caso de no encontrar el ClientMain ejecutar mvn install y correr la la anterior linea