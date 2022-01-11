# Practica Patrón: Publicador-Subscriptor

### Descripción:
#### Los Subscriptores de este proyecto, trabajan con un archivo de propiedades en el cual se define la forma de almacenamiento de información (memory, mysql). Solo use una propiedad: "subscriber.repository" al valor que desee según sea el caso: mysql o memory

## Para cualquier caso

### Contenedor Docker RabbitMQ
```
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 -d rabbitmq:3.9-management
```

## Correr contenedores de Docker MySQL (solo si eligió la propiedad anterior como: mysql): 

### DB Publisher

```
docker run --rm --name db_publisher -e MYSQL_ROOT_PASSWORD=123 -e MYSQL_DATABASE=product_publisher -d -p 3306:3306 mysql
```
### Adminer Publisher
```
docker run --link db_publisher:product_publisher -p 8080:8080 --name adminer_publisher --rm -d adminer
```

### DB Suscriber
```
docker run --rm --name db_subscriber -e MYSQL_ROOT_PASSWORD=123 -e MYSQL_DATABASE=product_subscriber -d -p 3307:3306 mysql
```

### Adminer Publisher
```
docker run --link db_subscriber:product_subscriber -p 8081:8080 --name adminer_subscriber --rm -d adminer
```

## Vaya al directorio raíz del proyecto con un comando similar a este:
cd ...\labisii2021.2\martinez_peña\cuartaPractica

## Limpiar y construir .jar 

1. LayersMVC
```
cd ...\labisii2021.2\martinez_peña\cuartaPractica\LayersMVC
```
```
mvn clean install package 
```
## Iniciar clase principal del publicador LayersMVC

```
java -cp "mysql-connector-java-8.0.23-bin.jar;target\LayersMVC-1.jar" co.edu.unicauca.layersmvc.presentation.ClientMain
```
2. LayersMVCSubscriber
```
cd ...\labisii2021.2\martinez_peña\cuartaPractica\LayersMVCSubscriber
```
```
mvn clean install package 
```
## Iniciar clase principal del subscritor LayersMVCSubscriber(recuerde el modo de almacenamiento de datos)

```
java -cp target\LayersMVC-1.jar co.edu.unicauca.layersmvc.presentation.ClientMain

```




