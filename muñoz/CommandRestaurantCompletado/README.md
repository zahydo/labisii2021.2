# Practica: Práctica Command

## Integrantes 
Andrés David Muñoz

## Proceso para correr el programa por CLI:

### *Limpiar, instalar dependencias y construir .jar:*

1. ubicarse en \muñoz\CommandRestaurantCompletado y ejecutar: 
```
mvn clean install package
```

### *Ejecutar los .jar y correr el main*
Ubicarse en la terminal en la carpeta del proyecto y correr el siguiente comando:
Para Windows:

```
java -cp target/CommandRestaurant-1.jar co.edu.unicauca.commandrestaurant.presentation.GUIFood

```

### nota: maven por cli lanza un null point al importar import org.slf4j.LoggerFactory; 
### Sirve en netbeans - no molesta ese error de importación

