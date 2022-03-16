# Practica_8 - Patron Templated-Method

Realizado con Maven - Java

## Trabajo Realizado:
```
se aplico el patrón Método Plantilla al restaurante en su versión cliente-sevidor, se Implemento el manejo de una solicitud del
restaurante. La clase ServerSocketTemplate. crea la clase ServerSocketRestaurant, la cual maneja las solicitudes (request) del sistema del restaurante:
```
## Primero debera limpiar y construir los archivos jar con el siguiente comando y dentro de cada una de las carpetas dentro de PRACTICA_8
```
mvn clean install package

```
## Proceso para correr el programa por CLI, Debe primero entrar a la carpeta del servidor en la siguiente ruta:
```
 cd...\labisii2021.2\Jnino_Jabella\PRACTICA_8\Restaurant-Server-FULL

```
## Ahora debera ejecutar el servidor con el siguiente comando
```
mvn exec:java -Dexec.mainClass="co.unicauca.restaurant.server.app.RestaurantApplication"
```
## Por ultimo para la ejecucion del programa debera ingresar a la carpeta del cliente:
```
cd...\labisii2021.2\Jnino_Jabella\PRACTICA_8\Restaurant-Client-FULL

```
## para la ejecucion del programa debera ingresar el siguiente comando
```
mvn exec:java -Dexec.mainClass="co.unicauca.restaurant.client.presentation.Client"

```

## Para ejecutar las pruebas unitarias debera ingresar a la siguiente ruta:
```
 cd...\labisii2021.2\Jnino_Jabella\PRACTICA_8\Restaurant-Server-FULL

```
## por ultimo debera ingresar el siguiente comando:
```
 mvn test

```