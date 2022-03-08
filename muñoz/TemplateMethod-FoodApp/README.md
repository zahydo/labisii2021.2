# Practica: Práctica Template

## Integrantes 
Andrés David Muñoz

## Proceso para correr el programa por CLI:

### *Limpiar, instalar dependencias y construir .jar:*


1. ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\FoodApp-commons y ejecutar: 
```
mvn clean install package
```

1. ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\ServerSocketTemplate y ejecutar: 
```
mvn clean install package
```

1. ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\FoodApp-Server y ejecutar: 
```
mvn clean install package
```

2. En una nueva terminal, ubicarse en ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\FoodApp-Client y ejecutar: 
```
mvn clean install package
```


### *Ejecutar los .jar y correr los  main*
1. Ubicarse en la terminal en la carpeta del proyecto  ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\FoodApp-Server y correr el siguiente comando:

```
java -cp target/FoodApp-Server-1.0-SNAPSHOT.jar co.unicauca.foodapp.server.app.FoodServerApplication
```

1. Ubicarse en la terminal en la carpeta del proyecto ..\labisii2021.2\muñoz\TemplateMethod-FoodApp\FoodApp-Client y correr el siguiente comando:

```
java -cp target/FoodApp-Client-1.0-SNAPSHOT.jar co.unicauca.foodapp.client.presentation.GUIFood

```

### Nota: al ejecutarlo en mvn aparece un error de importanción de paquetes, que no recuerdo cómo resolver, de cualquier manera, si se ejecuta en el netbeans, el proyecto funciona adecuadamente. 

