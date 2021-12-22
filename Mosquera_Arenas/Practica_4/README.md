# LayerMVC Publicador Subscriptor
Realizado por:
    Jose Sebastian Arenas Rodriguez -> jarenas@unicauca.edu.co> 
    Miguel Andres Mosquera Monje -> miguelmonje@unicauca.edu.co>
    David Camilo Collazos -> dacoes@unicauca.edu.cp

El proyecto se construyo en Java haciendo uso de Maven(Se debe instalar previamente).

## Proceso para correr la infraestructura del programa usando Docker.

1. Para correr Rabbit MQ
```
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 -d rabbitmq:3.9-management
```
Rabbit
  * localhost: http://localhost:15672/
  * Usuario: guest 
  * Contraseña: guest
  
2. Para instanciar una base MySql y Adminer
```
docker run --rm --name mysqluno -e MYSQL_ROOT_PASSWORD=12345678 -e MYSQL_DATABASE=agency -d -p 3307:3306 mysql
```
```
docker run --link mysqluno:agency -p 8080:8080 --name admineruno --rm -d adminer
```
Adminer -> 
  * localhost: http://localhost:8080/
  * Servidor: agency
  * Usuario: root
  * Contraseña: 1234678
  * Base de datos: agency

3. Script para crear la Tabla de la base de Datos
```
CREATE TABLE `Producto` (
  `id` varchar(15) primary key NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `valor` varchar(50) NOT NULL
);
```

## Proceso para ejecutar el programa:
Situarse en las respectivas carpetas de cada proyecto Limpiar y construir los .jar con la siguiente instruccion y orden:

```
mvn clean install package 

```
### Orden:
1. LayersMVC-commons
2. LayersMVC
3. LayerMVC-Sub


### Correr el LayersMVC quien servira de Publicador
```
mvn exec:java -Dexec.mainClass="co.edu.unicauca.layersmvc.presentation.ClientMain"
```

### Correr LayersMVC-Sub que sera subscriptor.
#### Nota!
Para guardar productos en memoria se pasa como argumento "1", para guardar en Base de Datos pasar como argumento "2".

El siguiente ejemplo es para almacenar en base de Datos:
```
mvn exec:java -Dexec.mainClass="co.edu.unicauca.subscriber.LayersMVC.suscriberMain" -Dexec.args="2"
```

El siguiente ejemplo es para almacenar en Memoria:
```
mvn exec:java -Dexec.mainClass="co.edu.unicauca.subscriber.LayersMVC.suscriberMain" -Dexec.args="1"
```


