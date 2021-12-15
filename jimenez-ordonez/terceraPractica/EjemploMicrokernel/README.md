# Práctica Microkernel: Ejemplo Plugins
## Usabilidad
El proyecto fue creado usando [maven](https://maven.apache.org/), asegúrese  de tenerlo previamente instalado.
## Limpiar, instalar dependencias y construir .jar:
Para construir las dependencias se debe ejecutar el comando:
~~~
mvn clean install package
~~~
Asegurese de ejecutar el comando en cada uno de los siguientes directorios y siguiendo este orden:
1. `.\Microkernel-common\`
2. `.\Microkernel-colombia-plugin\`
3. `.\Microkernel-mexico-plugin\`
4. `.\Microkernel-southkorea-plugin\`
4. `.\Microkernel-core\`
## Organizar los paquetes:
En el directorio `.\EjemploMicrokernel\Microkernel-core\` cree las carpetas `.\dist\` y `.\dist\plugins\` . Luego, copie los .jar construidos anteriormente de la siguiente manera:
* `.\dist\plugins\Microkernel-colombia-plugin-0.1.0.jar`
* `.\dist\plugins\Microkernel-mexico-plugin-0.1.0.jar`
* `.\dist\plugins\Microkernel-southkorea-plugin-0.1.0.jar`
* `.\dist\Microkernel-common-0.1.0.jar`
* `.\dist\Microkernel-core-1.jar`
## Copiar archivo de configuración de los plugins
Copiar el archivo `.\Microkernel-core\plugin.properties` en la carpeta  `.\dist\`.
## Ejecutar los .jar y correr el main
Ubicarse en la terminal en el directorio `.\Microkernel-core\dist\` y correr el siguiente comando:
1. Para Windows:
~~~
java -cp "./*;./plugins/*" co.unicauca.microkernel.app.Application
~~~
2. Para Linux | Mac:
~~~
java -cp "./*:./plugins/*" co.unicauca.microkernel.app.Application
~~~
## Nota:
Para agregar más plugins en tiempo de ejecución solo tiene que hacer lo siguiente:
1. Crear un proyecto para el nuevo plugin.
2. Construir el .jar.
3. Copiar el nuevo .jar en la carpeta `.\dist\plugins\`.
4. Modificar el archivo `.\dist\plugin.properties`.

