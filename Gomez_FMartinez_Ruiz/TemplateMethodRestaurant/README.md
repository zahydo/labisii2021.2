# Template-Method Pattern

Proyecto creado con maven. Es necesario tenerlo instalado y agregado a sus variables de entorno. Dirigase a su documentación oficial:
https://maven.apache.org/

## Ejecución

Para ejecutar correctamente el programa dirigase a la raíz de cada proyecto en el siguiente orden:

1.
´´´
.../TemplateMethodRestaurant/Restaurant-commons
´´´

Y ejecutar 

´´´
mvn clean install package
´´´

2.
´´´
.../TemplateMethodRestaurant/ServerSocketTemplate
´´´

Y ejecutar 

´´´
mvn clean install package
´´´

3.
´´´
.../TemplateMethodRestaurant/Restaurant-Server
´´´

Y ejecutar 

´´´
mvn clean install package
´´´

4.
´´´
.../TemplateMethodRestaurant/Restaurant-Client
´´´

Y ejecutar 

´´´
mvn clean install package
´´´

Para correr el programa primero se inicia el server:

´´´
mvn java -cp ./target/TemplateMethodRestaurant.jar 'co.unicauca.restaurant.server.app.RestaurantApp'
´´´

Después se corre el cliente

´´´
mvn java -cp ./target/TemplateMethodRestaurant.jar 'co.unicauca.restaurant.client.presentation.MainClass'
´´´

## Pruebas unitarias

Para correr las pruebas unitarias primero se inicializa el server:
´´´
mvn java -cp ./target/TemplateMethodRestaurant.jar 'co.unicauca.restaurant.server.app.RestaurantApp'
´´´

Después se corren las pruebas: 

´´´
mvn test -cp ./target/TemplateMethodRestaurant.jar 'co.unicauca.restaurant.client.access.FoodAccessImplSocketTest'
´´´
