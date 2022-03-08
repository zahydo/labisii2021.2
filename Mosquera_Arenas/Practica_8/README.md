# Patron Template
Realizado por:
    Jose Sebastian Arenas Rodriguez -> jarenas@unicauca.edu.co> 
    Miguel Andres Mosquera Monje -> miguelmonje@unicauca.edu.co>

El proyecto se construyo en Java haciendo uso de Maven(Se debe instalar previamente).

## Proceso para ejecutar el programa:
Situarse en las respectivas carpetas de cada proyecto Limpiar y construir los .jar con la siguiente instruccion y orden:

1. ServerSocketTemplate
2. Restaurant-commons
3. Restaurant-Server
4. Restaurant-Client

```
mvn clean install package 

```

## Correr el programa con el siguiente comando

### Situarse en la carpeta Restaurant-Server y ejecutar este comando:

```
mvn exec:java -Dexec.mainClass="co.unicauca.restaurant.server.app.RestaurantApplication"

```
### Situarse en la carpeta Restaurant-Client y ejecutar este comando:

```
mvn exec:java -Dexec.mainClass="co.unicauca.restaurant.client.presentation.Client"

```


### Para ejecutar pruebas unitarias, situarse en la carpeta Restaurant-Server y ejecutar el siguiente comando:

```
mvn test

```