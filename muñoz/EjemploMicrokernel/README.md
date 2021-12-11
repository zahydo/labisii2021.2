# Practica: Práctica Microkernel

## Integrantes 
Andrés David Muñoz

## Proceso en CLI 

### *Limpiar, instalar dependencias y construir .jar:*

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

4. Microkernel-corea_del_sur-plugin:
```
mvn clean install package
``` 

5. Microkernel-core: 
```
mvn clean install package 
```

### *Crear carpeta dist/ y dist/plugins/, y copiar los jar en lost directorios de la siguiente manera:*
```
dist/plugins/Microkernel-colombia-plugin-0.1.0.jar
```

```
dist/plugins/Microkernel-mexico-plugin-0.1.0.jar
```

```
dist/plugins/Microkernel-corea-del-sur-plugin-0.1.0
```

```
dist/Microkernel-common-0.1.0.jar
```

```
dist/Microkernel-core-1.jar
```

### *Copiar archivo de configuración de los plugins en dist/ (este archivo se encuentra en Microkernel-core):*
```
dist/plugin.properties
```

### *Ejecutar los .jar y correr el main*
Ubicarse en la terminal en la carpeta dist/ y correr el siguiente comando:
1. Para Windows:
```
java -cp "./*;./plugins/*" co.unicauca.microkernel.app.Application
```

2. Para Linux|Mac:
```
java -cp "./*:./plugins/*" co.unicauca.microkernel.app.Application
```

### *Nota:*
Para agregar más plugins en tiempo de ejecución solo tienen que hacer lo siguiente:
1. Crear un proyecto para el nuevo plugin.
2. Construir el .jar.
3. Copiar el nuevo .jar en la carpeta dist/plugins.
4. Modificar el archivo dist/plugin.properties


