# Laboratorio 7: Method Template Pattern
Se hace uso de la tecnología Maven en este proyecto. Asegúrese de instalar previamente.

## Limpie y construya el .Jar del Common (Dependencia del proyecto servidor restaurante)
## Vaya a la ruta del proyecto common, será algo similar a esto:
```
cd ...labisii2021.2\martinez_peña_MethodTemplatePattern\TravelAgency-commons
```
##Ejecute el siguiente comando

```
mvn clean install package
```

## Vaya al directorio raíz del proyecto con un comando similar a este:
```
cd ...\labisii2021.2\martinez_peña_MethodTemplatePattern\RestaurantServer
```


## Genera en primera instancia el archivo .jar del servidor: 
```
mvn clean package
```

## Vaya a la ruta del proyecto ServerSocketTemplate, será algo similar a esto:
```
cd ...labisii2021.2\martinez_peña_MethodTemplatePattern\ServerSocketTemplate
```
##Ejecute el siguiente comando

```
mvn clean install package
```

## Vaya al directorio raíz del proyecto servidor con un comando similar a este:
```
cd ...\labisii2021.2\martinez_peña_MethodTemplatePattern\RestaurantServer
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

## Vaya al directorio raíz del proyecto cliente con un comando similar a este:
```
cd ...\labisii2021.2\martinez_peña_MethodTemplatePattern\ClientRestaurant
```
## Para ejecutar el proyecto será algo similar a esto:
```
mvn java -cp target\ClientRestaurant-1.0-SNAPSHOT.jar co.unicauca.restaurant.client.app.RestaurantClientApplication
```
## Para las pruebas unitarias con JUnit:
```
mvn test
```
