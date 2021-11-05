labisii2021.2

 Interfaces. 
 Para esta versión se usaron dos interfaces, con el propósito de almacenar métodos abstractos que pudieran ser sobreescritas por las clases hijas de la clase principal.
 Además, permitión un "herencia múltiple", pues el concepto de manera literal no existe para la herencia en Java, por esta razón se emplean interfaces para mostrar que el ejercicio puede ser resuelto con esta estrategia.

 Test
 Al igual que en la versión del polimorfismo se hacen prubas unitarias a las clases en las cuales intervienen métodos abstractos de las interfaces, recibiendo satisfactoriamente los datos iniciales del test.

. Ejecución por línea de comandos (CID) con maven:
1. Por medio de CID ubicarse en el directorio "marin\primeraPractica_v2_interfaces" donde se encuentra el proyecto
   - Empleando "cd" para ello. 
2. Dentro del directorio usar el comando:
   - mvn clean
Con ello se busca limpiar el proyecto para luego reconstruirlo y adaptarse a la versión de maven que consigo trae el POM (pom.xml), y evitar errores e incompatibilidades en el sistema; eliminar la carpeta target donde contenía el ejecutable jar.
3. Construir el proyeto de nuevo usando el comando:
   - mvn package también se puede con mvn install package
Gracias a esa instrucción se construye de nuevo la carptea target con las modificaciones del pom.xml basada en maven. También se observa que realiza las pruebas unitarias, ya que dentro del paquete contiene el plugin que permite realizas tests de manera segura.
4. Ejecutar el jar dentro de target, con el comando:
   - java -jar target\tallerPolimorfismo_v2-1.0-SNAPSHOT.jar o también 
   - ...\cd target y luego java -jar tallerPolimorfismo_v2-1.0-SNAPSHOT.jar
Aquí automáticamente se enrutará a la clase principal que componga el proyecto
5. Hacer los tests:
Ubicados en el directorio de "primeraPractica_v2_interfaces" usar el comando:
   - mvn test