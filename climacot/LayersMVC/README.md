# TALLER Layers MVC

# Para contruir la aplicacion

## Limpiar, instalar dependencias y construir .jar:
1. LayersMVC: 
mvn clean install package
2. suscriptordb:
mvn clean install package 
3. suscriptorSql:
mvn clean install package 

# para ejecutar localmente

1. Tener un docker con rabbit MQ iniciado.
2. Iniciar LayerMVC ejecutarlo
3. Iniciar los dos suscriptores
4. Crear un producto en LayersMVC quien es el publicador
5. Revisar la salida por consola de los suscriptores

## comandos de ejecucion de los proyectos

### Antes de usar el comando ubicarse en la raiz de cada uno de los proyectos
El mismo comando para ejecutar los 3 proyectos
1. mvn exec:java -Dexec.mainClass="co.edu.unicauca.layersmvc.presentation.ClientMain"
