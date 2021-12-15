# Practica Patrón: Microkernel
## Vaya al directorio raíz del proyecto con un comando similar a este:

cd ...\labisii2021.2\martinez_peña\terceraPractica

## Limpiar, instalar dependencias y construir .jar 

1. Microkernel-common
```
cd ...\labisii2021.2\martinez_peña\terceraPractica\Microkernel-common
```
mvn clean install package 

2. Microkernel-colombia-plugin 
```
cd ...\labisii2021.2\martinez_peña\terceraPractica>cd Microkernel-colombia-plugin
```
mvn clean install package 

3. Microkernel-coreadelsur-plugin 
```
cd ...\labisii2021.2\martinez_peña\terceraPractica\Microkernel-coreadelsur-plugin
```
mvn clean install package 

4. Microkernel-peru-plugin 
```
cd ...\labisii2021.2\martinez_peña\terceraPractica\Microkernel-peru-plugin
```
mvn clean install package 

5. Microkernel-china-plugin 
```
cd ...\labisii2021.2\martinez_peña\terceraPractica\Microkernel-china-plugin
```
mvn clean install package

6. Microkernel-mexico-plugin 
```
cd ...\labisii2021.2\martinez_peña\terceraPractica\Microkernel-mexico-plugin
```
mvn clean install package

7. Microkernel-core
```
cd ...\labisii2021.2\martinez_peña\terceraPractica\Microkernel-core
```
mvn clean install package

## Correr el core 
```
cd ... \labisii2021.2\martinez_peña\terceraPractica\Microkernel-core
```
## Para ejecutar el microkernel-core :

mvn exec:java -Dexec.mainClass="co.unicauca.microkernel.app.Application"


