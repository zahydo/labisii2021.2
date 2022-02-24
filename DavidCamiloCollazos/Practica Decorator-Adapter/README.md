
## 17/11/21
PRACTICA-DECORATOR-ADAPTER 
Se implemento:
    ADAPTER: un repositorio llamado FoodJsonArrayRepository que graba y recupera comidas en un arreglo de String JSON, y el adaptador
    FoodRepositoryJsonArrayAdapter que cumple con la interface y usa el nuevo repositorio.
    DECORATOR: se implemento un decorador de Food llamado CryptFood que permite cifrar el nombre del plato.
    Cuando se muestra el nombre en las cajas de texto este no esta cifrado en la tabla si.

Requirements
    - maven 1.6, 1.8, 11
    - java v 11
    
Team 
    Dacoes dacoes@unicauca.edu.co

Para compilar el proyecto:
    se debe estar en la carpeta donde se encuentra el proyecto
    1. Microkernel-common: 
    mvn clean install package

Para correr el proyecto:
    Ubicarse en la terminal en la carpeta del proyecto y correr el siguiente comando:
    1. Para Windows:
    mvn exec:java -Dexec.mainClass="co.edu.unicauca.commandrestaurant.presentation.GUIFood"

Nota:
    - El codigo para encriptar y desencriptar se tomo de Somos Programadores:Encriptar y des-encriptar cadenas con MD5
    https://www.youtube.com/channel/UCbs7Y9iSJlEcBftVxrb2UPQ.
    - En la carpeta diagramas se encuentra un pdf y un archivo que contienen los diagramas de secuencia de addFood y txtFocusLost(este busca la Food y muestra el nombre desencriptado).