# Practica: Taller principios SOLID


## Integrantes 
Andrés David Muñoz - Diego Collazos Perafán 

##Proceso en CLI 

Diríjase a la ruta del proyecto desde la terminal. 
```
...> cd ..\labisii2021.2\AndresMunoz_DiegoCollazos\PrincipiosSolid
```

1. Para borrar el directorio de salida (target) y compilar el proyecto dejando un nuevo resultado en /target/classes
```
mvn clean compile
```
2. Empaquete el proyecto en /target/PrincipiosSOLID-SolucionTarea-1.0-SNAPSHOT.jar
```
mvn package 
```
3. Ejecute el Main
```
java -cp target/PrincipiosSOLID-SolucionTarea-1.0-SNAPSHOT.jar co.unicauca.parkinglot.presentacion.ClientMain
```
4. Compile y ejecute los test
```
mvn test 
