# Laboratorio 7: Method Template Pattern
Se hace uso de la tecnología Maven en este proyecto. Asegúrese de instalar previamente.

## Limpie y construya el .Jar del Common (Dependencia del proyecto servidor restaurante)
## Integrante

-  [`Antonio Estrada`](https://github.com/AntonioEstrda)
-  [`Hector Rivera`](https://github.com/Hauries)
##Ejecute el siguiente comando

```
mvn clean install package
```


## Genera en primera instancia el archivo .jar del servidor: 
```
mvn clean package
```

##Ejecute el siguiente comando

```
mvn clean install package
```

## Realice el mismo procedimiento anterior: 
```
mvn clean install package
```

## Para ejecutar el proyecto será algo similar a esto:
```
mvn java -cp target\ServerSocketRestaurant-1.0-SNAPSHOT.jar co.unicauca.restaurant.server.app.RestaurantApplication
```

## Ahora es momento de levantar el proyecto cliente con un comando similar a éste:

## Para ejecutar el proyecto será algo similar a esto:
```
mvn java -cp target\ClientRestaurant-1.0-SNAPSHOT.jar co.unicauca.restaurant.client.app.RestaurantClientApplication
```
## Para las pruebas unitarias con JUnit:
```
mvn test
```
