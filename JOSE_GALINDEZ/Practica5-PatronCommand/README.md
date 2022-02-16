JOSE RICARDO GALINDEZ LOPEZ
YAQUELIN ALEJANDRA GOMEZ

Practica 5 - Patron Command Solid 16/Feb/2021

Para ejecutar el programa principal la CL se
ejecutan los siguientes comandos:

Posicionarse en la ubicacion del proyecto: 

cd ...\labisii2021.2\JOSE_GALINDEZ\Practica5-PatronCommand\CommandRestaurant

Para compilar el proyecto y generar el .jar
mvn compile
(puede hacer antes mvn clean para limpiar el proyecto)

Para correr el proyecto
mvn exec:java -Dexec.mainClass="co.edu.unicauca.commandrestaurant.presentation.GUIFood"
Nota: En caso de no encontrar el ClientMain ejecutar mvn install y correr la la anterior linea


