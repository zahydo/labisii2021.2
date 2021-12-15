
## 17/11/21
PRACTICA-MICROKERNEL  
Se agrego al trabajo entregado el plugin que permite calcular envios a Corea del Sur.

Requirements
    - maven 1.6, 1.8, 11
    - java v 11
    
Team 
    Dacoes dacoes@unicauca.edu.co

Notes:
    el proyecto fue entregado con maven 1.5 pero al compilarlo generaba un error, al tener esto se coloco maven en 1.6, el plugin de corea del sur necesita de maven 11.

Para compilar el proyecto:
    se debe estar en la carpeta donde se encuentra el proyecto
    1. Microkernel-common: 
    mvn clean install package
    2. Microkernel-colombia-plugin:
    mvn clean install package
    3. Microkernel-corea_del_Sur-plugin
    mvn clean install package
    4. Microkernel-mexico-plugin:
    mvn clean install package 
    5. Microkernel-core: 
    mvn clean install package 

Para correr el proyecto:
    Crear carpeta dist/ y dist/plugins/, y copiar los jar en lost directorios de la siguiente manera:
        dist/plugins/Microkernel-colombia-plugin-0.1.0.jar
        dist/plugins/Microkernel-mexico-plugin-0.1.0.jar
        dist/plugins/Microkernel-corea_del_Sur-plugin-1.0.jar
        dist/Microkernel-common-0.1.0.jar
        dist/Microkernel-core-1.jar
    Ubicarse en la terminal en la carpeta dist/ y correr el siguiente comando:
    1. Para Windows:
    java -cp "./*;./plugins/*" co.unicauca.microkernel.app.Application
    2. Para Linux|Mac:
    java -cp "./*:./plugins/*" co.unicauca.microkernel.app.Application
