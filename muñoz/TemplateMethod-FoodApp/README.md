# Practica: Práctica Template

## Integrantes 
Andrés David Muñoz

## Proceso para correr el programa por CLI:

### *Limpiar, instalar dependencias y construir .jar:*


1. ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\FoodApp-commons y ejecutar: 
```
mvn clean install package
```

2. ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\ServerSocketTemplate y ejecutar: 
```
mvn clean install package
```

3. ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\FoodApp-Server y ejecutar: 
```
mvn clean install package
```

4. En una nueva terminal, ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\FoodApp-Client y ejecutar: 
```
mvn clean install package
```


### *Configuración de los jar y carpetas client y server*

5. Ubicarse en la carpeta del proyecto ..\labisii2021.2\muñoz\TemplateMethod-FoodApp y crear una carpeta "server", y una carpeta "client"

6. En la carpeta ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\client y en la carpeta ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\server, crear una copia del archivo ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\ServerSocketTemplate\target\ServerSocketTemplate-1.0.jar

7.En la carpeta ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\client y en la carpeta ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\server, crear una copia del archivo ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\FoodApp-commons\target\FoodApp-commons-1.0-SNAPSHOT.jar

8. Ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\server y hacer una copia del archivo "config.properties" ubicado en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\FoodApp-Server

9. Ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\server y hacer una copia del archivo "FoodApp-Server-1.0-SNAPSHOT.jar" ubicado en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\FoodApp-Server\target

10. Ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\client y hacer una copia del archivo "config.properties" ubicado en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\FoodApp-Client

11. Ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\client y hacer una copia del archivo "FoodApp-Client-1.0-SNAPSHOT.jar" ubicado en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\FoodApp-Client\target


### *Ejecución de las aplicaciones *


12. Para correr la aplicación del servidor ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\server y ejecutar en el cmd 

```
java -cp FoodApp-Server-1.0-SNAPSHOT.jar co.unicauca.foodapp.server.app.FoodServerApplication 
```

13. Para correr la aplicación del cliente ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\client y ejecutar en el cmd 

```
java -cp FoodApp-Client-1.0-SNAPSHOT.jar co.unicauca.foodapp.client.presentation.GUIFood

```

### nota: se agrega en la carpeta ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\PNGS_configuración_directorios donde se muestra la configuración final de la carpeta principal, el server, y el cliente 
