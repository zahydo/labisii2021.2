# Laboratorio 7: Method Template Pattern
Se hace uso de la tecnología Maven en este proyecto. Asegúrese de instalar previamente.

## Vaya al directorio raíz del proyecto con un comando similar a este:
```
cd ...\labisii2021.2\martinez_peña_MethodTemplatePattern\ServerRestaurant
```

## Genera en primera instancia el archivo .jar del servidor: 
```
mvn clean package
```
## Para ejecutar el proyecto será algo similar a esto:
```
mvn java -cp target\ServerRestaurant-1.0-SNAPSHOT.jar co.unicauca.restaurant.server.app.RestaurantApplication
```
## Ahora es momento de levantar el proyecto cliente con un comando similar a éste:

## Vaya al directorio raíz del proyecto con un comando similar a este:
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
