# 3ra Practica: Microkernel.

El proyecto se contruyo con la asistencia de Maven. Por lo tanto para correr el proyecto y sus pruebas a traves de CLI, es necesario correr los siguientes comandos (con [Maven](https://maven.apache.org/) instalado) desde el directorio raiz del proyecto.

## Para correr el main:

Proceso para correr el programa por CLI:


Limpiar, instalar dependencias y construir .jar:
1. Microkernel-common: 
`mvn clean install package`
2. Microkernel-colombia-plugin:
`mvn clean install package`
3. Microkernel-south-plugin:
`mvn clean install package`
4. Microkernel-mexico-plugin:
`mvn clean install package` 
5. Microkernel-core: 
`mvn clean install package` 



Crear carpeta dist/ y dist/plugins/, y copiar los jar en lost directorios de la siguiente manera:
>dist/plugins/Microkernel-colombia-plugin-0.1.0.jar
>dist/plugins/Microkernel-mexico-plugin-0.1.0.jar
>dist/Microkernel-common-0.1.0.jar
>dist/Microkernel-core-1.jar


Copiar archivo de configuración de los plugins en dist/ (este archivo se encuentra en Microkernel-core):
>dist/plugin.properties


Ejecutar los .jar y correr el main
Ubicarse en la terminal en la carpeta dist/ y correr el siguiente comando:
1. Para Windows:
`java -cp "./*;./plugins/*" co.unicauca.microkernel.app.Application`
2. Para Linux|Mac:
`java -cp "./*:./plugins/*" co.unicauca.microkernel.app.Application`