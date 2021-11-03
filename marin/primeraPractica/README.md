labisii2021.2

* Polimorfismo
En este proyecto se pone a prueba el concepto de Polimorfismo para una agencia de viajes, la cual proporciona diferentes tipos de viaje.
Existe un método que brinda la descripción a cada uno de los diferentes tipos de viaje.

* Test
Usando JUnit para las pruebas unitarias de los datos esperados a datos predefinidos con el propósito de comprobar que la codificación se haya realizado debbidamente.

Ejecución por línea de comandos:
1. Abrir una terminal de comandos
2. Ubicar el proyecto en la carpeta \marin\primeraPractica
   2.1 para Windows usar cd "nombre-directorio" para ir encontrando carpetas
3. Limpiar el proyecto usando: 
   - mvn clean 
   Esto limpiará todo ejecutable del proyecto para evitar fallos o incompatibilidad, por el maven plugin "maven-clean-plugin" dentro del POM
4. Construir el proyecto usando:
   - mvn install package o senciilamente:
   - mvn package
   Esto construye el proyecto por el plugin del pom.xml "maven-compiler-plugin" creando un directorio target dentro y adentro el ejectutable jar. Además ejectuta los Test de las clases gracias a la dependencia "junit" dentro del PM y al plugin de maven "maven-surefire-plugin"
5. Ejecutar el jar con lo siguiente:
   - java -jar target\primeraPractica-1.0-SNAPSHOT.jar
   O entrando primero a la carpeta target: ...\primeraPractica cd target y luego:
   - java -jar primeraPractica-1.0-SNAPSHOT.jar
En una carpeta llamada recursos están las imágenes explícitas sobre el proceso.