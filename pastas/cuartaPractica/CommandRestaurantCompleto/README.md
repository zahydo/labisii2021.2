# 4ta Practica: Patron Command.

El proyecto se contruyo con la asistencia de Maven. Por lo tanto para correr el proyecto y sus pruebas a traves de CLI, es necesario correr los siguientes comandos (con [Maven](https://maven.apache.org/) instalado) desde el directorio raiz del proyecto.

## Para correr el main:

Proceso para correr el programa por CLI:


Limpiar, instalar dependencias y construir .jar:
`mvn clean install package`

Y luego
`mvn exec:java -Dexec.mainClass="co.edu.unicauca.commandrestaurant.presentation.Main"`