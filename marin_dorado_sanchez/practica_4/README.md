# Practica Arquitectura Orientada a eventos

## Integrantes: Fabián David Marín, Héctor Fernando Dorado, Juán Sebastián Sánchez

### Anotación:
#### Los suscriptores emplean el archivo de propiedades, que permite establecer un modo de almacenamiento, como puede ser por memoria o una base de datos MySQL

## Cualquier caso

## Correr contenedores de Docker MySQL

### Contenedor: db_publicador

```
docker run --rm --name db_publicador -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=publicador -d -p 3306:3306 mysql
```
### Contenedor: publicador
```
docker run --link db_publicador:publicador -p 8080:8080 --name admin_publicador --rm -d adminer
```

### Contenedor: db_suscriber
```
docker run --rm --name db_suscriptor -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=suscriptor -d -p 3307:3306 mysql
```

### Contenedor: admin_suscriptor
```
docker run --link db_suscriptor:suscriptor -p 8081:8080 --name admin_suscriptor --rm -d adminer
```

## Ir al directorio donde está el proyecto:

## Limpiar y construir .jar 

1. Se dirige al directorio del proyecto LayersMVC y se ejecuta lo siguiente por CLI
```
mvn clean install package 
```
## Iniciar clase principal del publicador LayersMVC

```
java -cp "mysql-connector-java-8.0.23-bin.jar;target\LayersMVC-1.jar" co.edu.unicauca.layersmvc.presentation.ClientMain
```
2. Se dirige al directorio del proyecto LayersMVCSuscriber y se ejecuta lo siguiente por CLI
```
mvn clean install package 
```
## Iniciar clase principal del subscritor LayersMVCSubscriber

```
java -cp target\LayersMVC-1.jar co.edu.unicauca.layersmvc.presentation.ClientMain

```


## Iniciar plugins de RabbitMQ:
```
rabbitmq-plugins enable rabbitmq_management
```

## Ingresar al RabbitMQ:
```
http://localhost:15672/
```
```
User: guest
```
```
Password: guest
```

## Adminier publisher
User: publicador
Usuario: root
Password: password
Base de datos: publicador

## Adminier suscriber
User: suscriptor
Usuario: root
Password: password
Base de datos: suscriptor