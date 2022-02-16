#Practica de Patron comando.
El proyecto se contruyo con la ayuda de Maven. Por lo tanto para correr el proyecto y sus pruebas a traves de CLI, 
es necesario correr los siguientes comandos 

## Para correr el main:

mvn compile 
mvn exec:java -Dexec.mainClass="co.edu.unicauca.commandrestaurant.presentation.GUIFood"

## Para correr las pruebas :

mvn test