# Laboratorio Ingeniería de Software II 2021-2 Grupo B

En esta Carpeta se guarda el contenido del proyecto Productor-Subscriptor, se adjunta también el diagrama de componentes.

## Integrantes

-  [`Sebastian Collazos`](https://github.com/secoveGordo)
-  [`Antonio Estrada`](https://github.com/antonioestrda)
-  [`Hector Rivera`](https://github.com/hauries)

## Entregas

-  [x] 24/12/21 : Práctica Productor-Subscriptor

## Usabilidad

El proyecto fue creado usando [maven](https://maven.apache.org/), asegúrese  de tenerlo previamente instalado.
Proceso para correr el programa por CLI:


## Limpiar, instalar dependencias y construir .jar:

1. proyecto hyun, tanto en productor como en subsciptor: 
mvn clean install package


## Ubicarse en la terminal en la carpeta del productor y correr el siguiente comando:

java -cp target/Productor-1.jar co.edu.unicauca.Productor.presentation.ClientMain

## Y desde la carpeta del subsriptor:

java -cp target/Subscritor1-1.jar co.edu.unicauca.Subscriptor1.presentation.ClientMain

## Teniendo instalado RabbitMQ

# Con Docker:

docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 -d rabbitmq:3.9-management

# Con Windows:

1. Install Erlang https://erlang.org/download/otp_versions_tree.html

2. Install RabbitMQ https://www.rabbitmq.com/install-windows.html#installer

# Consider the requirements of RabbitMQ related to Erlang

https://www.rabbitmq.com/which-erlang.html

## Si no les funciona el comando "mvn clean install package", agregar la siguiente etiqueta al pom de cada proyecto:

<properties>
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
<maven.compiler.source>1.8</maven.compiler.source>
<maven.compiler.target>1.8</maven.compiler.target>
</properties>

