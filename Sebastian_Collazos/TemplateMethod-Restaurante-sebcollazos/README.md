# 5ta Practica: Patron Template
El proyecto se contruyo con la asistencia de Maven. Por lo tanto para correr el proyecto y sus pruebas a traves de CLI, es necesario correr los siguientes comandos (con [Maven](https://maven.apache.org/) instalado) desde el directorio raiz del proyecto.

## Proceso para correr el programa por CLI:
Limpiar, instalar dependencias y construir .jar:

1. ServerSocketTemplate: 
`mvn clean install package`
2. Restaurante-commons:
`mvn clean install package`
3. Restaurante-Server:
`mvn clean install package`
4. Restaurante-Client:
`mvn clean install package` 


## Correr el programa Server por CLI

### Situarse en la carpeta TravelAgency-Server y ejecutar este comando:

```
mvn exec:java -Dexec.mainClass="co.unicauca.restaurant.server.app.RestaurantApplication"
```

## Correr el programa Server por CLI

### Situarse en la carpeta TravelAgency-Client y ejecutar este comando:

```
mvn exec:java -Dexec.mainClass="co.unicauca.restaurant.client.presentation.Client"
```


### Para ejecutar pruebas unitarias JUnit, situarse en la carpeta TravelAgency-Server y ejecutar el comando:

```
mvn test
```