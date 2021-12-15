# Practica_3 - Microkernel 

Realizado con Maven - Java

## Trabajo Realizado:
```
se implementaron tres nuevos plugins para calcular el costo de envio de los siguientes paises:
Nombre: china         Codigo: ch
Nombre: Peru          Codigo: pe
Nombre: Corea del Sur Codigo: cs
```
## Proceso para correr el programa por CLI:
```

## Limpiar, instalar dependencias y construir .jar:
```
1. Microkernel-common: 
mvn clean install package
2. Microkernel-colombia-plugin:
mvn clean install package 
3.Microkernel-china-plugin:
mvn clean install package 
4.Microkernel-peru-plugin:
mvn clean install package 
5.icrokernel-Coreadelsur-plugin:
mvn clean install package
6. Microkernel-mexico-plugin:
mvn clean install package 
7. Microkernel-core: 
mvn clean install package 
```


## Crear carpeta dist/ y dist/plugins/, y copiar los jar en lost directorios de la siguiente manera:
```
dist/plugins/Microkernel-colombia-plugin-0.1.0.jar
dist/plugins/Microkernel-mexico-plugin-0.1.0.jar
dist/plugins/Microkernel-peru-plugin-0.1.0.jar
dist/plugins/Microkernel-china-plugin-0.1.0.jar
dist/plugins/Microkernel-coreadelsur-plugin-0.1.0.jar
dist/Microkernel-common-0.1.0.jar
dist/Microkernel-core-1.jar
```

## Copiar archivo de configuración de los plugins en dist/ (este archivo se encuentra en Microkernel-core):
dist/plugin.properties

## Para ejecutar el programa debe ubicarse en la terminal en la carpeta dist/ y correr el siguiente comando
```
1. Comando para Windows:
java -cp "./*;./plugins/*" co.unicauca.microkernel.app.Application
2. Comando para Linux o Mac:
java -cp "./*:./plugins/*" co.unicauca.microkernel.app.Application
```

