### Integrantes

 - Juan Esteban Ruiz Grupo B

### Pasos para la correcta ejecución del código :D

Limpiar y construir cada proyecto empezando por el common y terminando por el core.

Crear una carpeta "dist" y una subcarpeta "dist/plugins"
En dist irán los jar de common y core y en dist/plugins irán los plugins de los países

Ubicarse en la carpeta dist en el terminal y ejecutar el comando:
1. Para Windows:
java -cp "./*;./plugins/*" co.unicauca.microkernel.app.Application
2. Para Linux|Mac:
java -cp "./*:./plugins/*" co.unicauca.microkernel.app.Application

