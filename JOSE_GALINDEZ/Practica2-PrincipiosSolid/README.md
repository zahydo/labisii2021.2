JOSE RICARDO GALINDEZ LOPEZ

Practica 2 - Principios Solid 17/Nov/2021

Para ejecutar el programa principal y correr las pruebas unitarias mediante la CL se
ejecutan los siguientes comandos:

Posicionarse en la ubicacion del proyecto: 

cd ...\labisii2021.2\JOSE_GALINDEZ\Practica2-PrincipiosSolid\PrincipiosSOLID-SolucionTarea

Para compilar el proyecto y generar el .jar
mvn compile
(puede hacer antes mvn clean para limpiar el proyecto)

Para correr el proyecto
mvn exec:java -Dexec.mainClass="co.unicauca.parkinglot.presentation.ClientMain"
Nota: En caso de no encontrar el ClientMain ejecutar mvn install y correr la la anterior linea

Para ejecutar el test
mvn test
