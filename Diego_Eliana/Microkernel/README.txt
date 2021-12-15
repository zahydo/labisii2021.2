command prompt must be on this dir ./Diego_Eliana/MicroKernel

Clean, install dependencies and build .jar:
1. Microkernel-common: 
    mvn clean install package
2. Microkernel-colombia-plugin:
    mvn clean install package 
3. Microkernel-mexico-plugin:
    mvn clean install package 
4. Microkernel-core: 
    mvn clean install package 

Create dir dist/ y dist/plugins/, and copy jar files as shown below:
dist/plugins/Microkernel-colombia-plugin-0.1.0.jar
dist/plugins/Microkernel-mexico-plugin-0.1.0.jar
dist/Microkernel-common-0.1.0.jar
dist/Microkernel-core-1.jar

Copy plugin config file in dist/ (on microkernel-core):
dist/plugin.properties

Execute .jar files and run main
On dist/ run:
1. For Windows:
java -cp "./*;./plugins/*" co.unicauca.microkernel.app.Application
2. For Linux|Mac:
java -cp "./*:./plugins/*" co.unicauca.microkernel.app.Application

Practica MicroKernel