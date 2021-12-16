### Integrantes

 - Daniel Esteban Cerón Grupo B
 - Juan Esteban Ruiz Grupo B

### Para correr el código deben realizarse los siguientes pasos :D

1. Microkernel-common:
```
mvn clean install package
```
2. Microkernel-colombia-plugin:
```
mvn clean install package 
```
3. Microkernel-mexico-plugin:
```
mvn clean install package
```
4. Microkernel-southkorea-plugin:
```
mvn clean install package
```
5. Microkernel-core: 
```
mvn clean install package 
```

## Se crean la carpeta dist y la subcarpeta dist/plugins y se pegan los .jar
 
 * En dist se colocan el common y el core, además del properties.plugins
 * En dist/plugins se colocan los plugins de todos los países

## Ubicarse en la carpeta dist en el terminal y ejecutar

1. Para Windows:
```
java -cp "./*;./plugins/*" co.unicauca.microkernel.app.Application
```
2. Para Linux|Mac:
```
java -cp "./*:./plugins/*" co.unicauca.microkernel.app.Application
```