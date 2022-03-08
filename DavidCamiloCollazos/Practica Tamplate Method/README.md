## 17/11/21
PRACTICA-TEMPATE METHOD
Se implemento:
    *   El patron Método plantilla al restaurante en su version cliente-servidor.
    *   La solicitud que se implemento fue agregar plato y buscar un plato.
    

Requirements
    *   maven 1.6, 1.8, ...,11
    *   java v 11
    
Team: 
    *   Dacoes dacoes@unicauca.edu.co

Para compilar el proyecto:
    se debe estar en la carpeta donde se encuentra el proyecto
    *   1. TravelAgency-commons: 
        *   mvn clean install package
    *   2. ServerSocketTemplate: 
        *   mvn clean install package
    *   3. RestaurantServer: 
        *   mvn clean install package
    *   4. Restaurant-Client: 
        *   mvn clean install package

Para correr el proyecto:
    *   Ubicarse en la terminal en la carpeta indicada y correr el siguiente comando:
    *   1. RestaurantServer:
        *   mvn exec:java -Dexec.mainClass="co.unicauca.restaurant.server.app.RestauranteApplication" 
    *   2. Restaurant-Client:
        *   mvn exec:java -Dexec.mainClass="co.unicauca.restaurant.client.presentation.Main"