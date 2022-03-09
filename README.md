# labisii2021.2

Bienvenidos al curso de Laboratorio de Ingeniería de Software II.

## Uso del repositorio
Este repositorio será utilizado para guardar todas las prácticas que vayan realizando los estudiantes del curso.

## Estructura de directorios
La ubiación de este README será la raíz del proyecto, partiendo desde aquí, cada estudiante debe crear una carpeta en donde subirá sus prácticas y un README adicional que mantenga actualizado el contenido de su folder.

### Ejemplo

/hyun/README.md

/hyun/primeraPractica
/hyun/segundaPractica
/hyun/segundaPractica

## Estrategia de Integración Continua
Vamos a seguir buenas prácticas para integración continua como [feature branching](https://www.atlassian.com/es/git/tutorials/comparing-workflows/feature-branch-workflow) y [code review](https://github.com/features/code-review/). Para ello, vamos a seguir el siguiente proceso cada vez que vayan a subir una nueva práctica:

### Subir cambios al repositorio remoto

1. Crear una rama para trabajar en tus cambios. El atributo -b nos crea la rama si no existe, en caso de que exista no es necesario ponerlo.
```
git checkout -b "NOMBRE_ESTUDIANTE|GRUPO|PAREJA-NOMBRE_PRACTICA"
```
2. Seleccionar los cambios a guardar
```
git add .
```
3. Guardar los cambios localmente con un commit
```
git commit -m "NOMBRE_ESTUDIANTE|GRUPO|PAREJA-NOMBRE_PRACTICA: Mensaje explicativo de lo que está guardando"
```
4. Descargar los cambios de la rama principal
```
git pull --rebase origin main
```
4.1. Si se está trabajando en equipo o en parejas deben publicar la rama primero y hacer el pull de esta rama
```
git pull --rebase origin NOMBRE_ESTUDIANTE|GRUPO|PAREJA-NOMBRE_PRACTICA
```
5. Subir los cambios a su rama
```
git push origin NOMBRE_ESTUDIANTE|GRUPO|PAREJA-NOMBRE_PRACTICA
```

### Creación de la Pull Request
Una vez su trabajo haya sido subido a la rama correspondiente, deberá crear una Pull Request seleccionando su respectiva rama.
Siga el proceso indicado en la documentación adjunta en el siguiente [link](https://docs.github.com/es/github/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request)

## Calificación del trabajo
Una vez el docente realice las respectivas validaciones de los proyectos de clase, los cambios van a ser aprobados o rechazados con comentarios para cambios requeridos.

## Dudas y comentarios
Si tiene dudas o dificultades en el proceso por favor comunicarse en los espacios de asesoría del curso, o envíe un correo a [santiagodorado@unicauca.edu.co](mailto:santiagodorado@unicauca.edu.co)
