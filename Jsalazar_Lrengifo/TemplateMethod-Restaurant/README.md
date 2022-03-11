# Práctica - Patrón Template Method
# Integrantes
  Grupo B
  Juan Andrés Salazar - Laura Marcela Mendez
## Limpiar, instalar dependencias y construir .jar

Para construir los jar con sus dependencias se debe ejecutar el comando:

mvn clean install package

Asegurese de ejecutar este comando en cada uno de los siguientes directorios y siguiendo este orden:

1. `.\ServerSocketTemplate\`
2. `.\Restaurant-commons\`
3. `.\Restaurant-Server\`
4. `.\Restaurant-Client\`

Después de construir los .jar, para correr la solución seguir los siguientes pasos en orden.

### Restaurant-Server

Para poner a correr el server, estando en el directorio `.\Restaurant-Server\` ejecutar el siguiente comando:


java -cp .\target\Restaurant-Server.jar 'co.unicauca.restaurant.server.app.RestaurantApplication'


### Restaurant-Client

Para poner a correr el client, estando en el directorio `.\Restaurant-Client\` ejecutar el siguiente comando:


java -cp .\target\Restaurant-Client.jar 'co.unicauca.restaurant.client.presentation.GUIMain'


## Test

Después de construir los .jar, para correr los test en el directorio `.\Restaurant-Server\` ejecutar el comando:



