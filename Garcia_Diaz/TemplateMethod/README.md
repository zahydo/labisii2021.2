# Patrón Template
## Realizado en Java - Maven

Con el fin de ejecutar el programa debera seguir los siguientes pasos:

## Para cada una de las siguientes carpetas, ubicarse en cada una de ellas y construir los jar con el comando mostrado a continuación:
```
1. ServerSocketTemplate
2. Restaurant-commons
3. Restaurant-Client
4. Restaurant-Server

```
## Para construir los jar: 
```
mvn clean install package
```

## Para ejecutar proyecto: 
Nos aseguramos de encontrarnos en la carpeta Restaurant-Server, de no ser así nos debemos ubicarnos en ella y empezamos por correr el server:

## Posicionarse en la ubicacion de la carpeta Restaurant-Server: 
```
cd ...\labisii2021.2\Garcia_Diaz\TemplateMethod\Restaurant-Server
```
##Para correr el server:
```
mvn exec:java -Dexec.mainClass="co.unicauca.restaurant.server.app.RestaurantApplication"
```
## Ahora nos ubicamos en en la carpeta Restaurant-Client: 
```
cd ...\labisii2021.2\Garcia_Diaz\TemplateMethod\Restaurant-Client
```
##Para correr el cliente:
```
mvn exec:java -Dexec.mainClass="co.unicauca.restaurant.client.presentation.Client"
```

##Para ejecutar el test:
Nos ubicamos en la carpeta Restaurant-Server y ejecutamos el test con el siguiente comando:
```
mvn test
```