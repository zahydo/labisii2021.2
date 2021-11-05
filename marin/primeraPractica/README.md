labisii2021.2

* Polimorfismo
- En este proyecto se pone a prueba el concepto de Polimorfismo para una agencia de viajes, la cual proporciona diferentes tipos de viaje. Existe un método que brinda la descripción a cada uno de los diferentes tipos de viaje.
- La versión de interfaces implementa este método (descripcion()) y el método cualquierMetodo2() como interfaces que, de acuerdo a la clase de viajes que la requisieran fueran sobreescritas ahí.

Test
Usando JUnit para las pruebas unitarias de los datos esperados a datos predefinidos con el propósito de comprobar que la codificación se haya realizado debbidamente.

Ejecución por línea de comandos (CID) con maven:
1. Por medio de CID ubicarse en el directorio "marin\primeraPractica" donde se encuentra el proyecto
   - Empleando "cd" para ello. 
2. Dentro del directorio usar el comando:
   - mvn clean
Con ello se busca limpiar el proyecto para luego reconstruirlo y adaptarse a la versión de maven que consigo trae el POM (pom.xml), y evitar errores e incompatibilidades en el sistema; eliminar la carpeta target donde contenía el ejecutable jar.
3. Construir el proyeto de nuevo usando el comando:
   - mvn package también se puede con mvn install package
Gracias a esa instrucción se construye de nuevo la carptea target con las modificaciones del pom.xml basada en maven. También se observa que realiza las pruebas unitarias, ya que dentro del paquete contiene el plugin que permite realizas tests de manera segura.
4. Ejecutar el jar dentro de target, con el comando:
   - java -jar target\primeraPractica-1.0-SNAPSHOT.jar o también 
   - ...\cd target y luego java -jar primeraPractica-1.0-SNAPSHOT.jar
Aquí automáticamente se enrutará a la clase principal que componga el proyecto
5. Hacer los tests
Ubicados en el directorio de "primeraPractica" usar el comando:
   - mvn test
