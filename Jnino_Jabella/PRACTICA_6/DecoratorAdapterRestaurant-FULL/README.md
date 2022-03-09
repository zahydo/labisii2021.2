# Practica_6 - DecoratorAdapterRestaurant

Realizado con Maven - Java

## Trabajo Realizado:
```
1) Se creo un nuevo decorador de Food llamado CryptFood que permite cifrar el nombre del plato.
En el repositorio el nombre del plato se guarda cifrado, en la interfaz gráfica de usuario en la tabla se
muestra cifrado y en la cajas de texto se muestra descifrado.
2) Se creo un nuevo repositorio llamado FoodJsonArrayRepository que permite grabar y
recuperar comidas (Food) en un arreglo de String Json (List<String> foods). Este repositorio
tiene su propia interfaz de acceso a las operaciones del CRUD de comidas. Se creo un adaptador
FoodRepositoryJsonArrayAdapter que cumple la interface y usa el nuevo repositorio.
*
```
## Para ejecutar el test se debera primero compilar el proyecto con el siguiente comando:
```
mvn compile

```
## Por ultimo para ejecutar el test debera ejecutar el siguiente comando :
```
mvn test

```
## Proceso para correr el programa por CLI, Debe ingresar al directorio raiz donde se encuentra nuestro trabajo:
```
 cd...\labisii2021.2\Jnino_Jabella\PRACTICA_6\DecoratorAdapterRestaurant-FULL

```
## Ahora debera limpiar los recursos de los paquetes antes de la instalacion con el siguiente comando
```
mvn clean install package
```
## Por ultimo para la ejecucion del programa debera ejecutar el siguiente comando :
```
mvn exec:java -Dexec.mainClass=co.edu.unicauca.commandrestaurant.presentation.GUIFood
```


