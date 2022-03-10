# Práctica - Patrón Template Method


# Usabilidad

El proyecto fue creado usando [maven](https://maven.apache.org/), asegúrese  de tenerlo previamente instalado.


## Limpiar, instalar dependencias y construir .jar

Para construir los jar con sus dependencias se debe ejecutar el comando:
~~~bash
mvn clean install package
~~~
Asegurese de ejecutar este comando en cada uno de los siguientes directorios y siguiendo este orden:

1. `.\ServerSocketTemplate\`
2. `.\Restaurant-commons\`
3. `.\Restaurant-Server\`
4. `.\Restaurant-Client\`

## Ejecutar los .jar

Después de construir los .jar, para correr la solución seguir los siguientes pasos en orden.

### Restaurant-Server

Para poner a correr el server, estando en el directorio `.\Restaurant-Server\` ejecutar el siguiente comando:

~~~bash
java -cp .\target\Restaurant-Server.jar 'co.unicauca.restaurant.server.app.RestaurantApplication'
~~~

---
**NOTA**

Tener en cuenta que al ejecutar el Server la terminal quedará bloqueda, para terminar la ejecución:
1. En Windows y Linux: \
    <kbd>Ctrl</kbd> + <kbd>c</kbd>
2. En Mac: \
    <kbd>Command</kbd> + <kbd>.</kbd>
---

### Restaurant-Client

Para poner a correr el client, estando en el directorio `.\Restaurant-Client\` ejecutar el siguiente comando:

~~~bash
java -cp .\target\Restaurant-Client.jar 'co.unicauca.restaurant.client.presentation.GUIMain'
~~~
