# Cambalache API (Kotlin)
API REST para búsqueda de anuncios y mensajes de contacto de la aplicación Cambalache.

## Casos de Uso
### 1. Buscar Anuncios 
* Condiciones Previas: El usuario desea comprar o intercambiar artículos.
* Condiciones Posteriores: El usuario verá un listado de artículos de su interés.
* Actor: Empleado de la empresa. 
* Escenario Principal
  1. El usuario se dirige al buscador de anuncios.
  2. El usuario introduce un texto para buscar en títulos de anuncios.
  3. El usuario selecciona un tipo de artículo.
  4. El usuario introduce un precio mínimo y un precio máximo para delimitar resultados.
  5. La aplicación muestra resultados mientras el usuario cambia sus criterios de búsqueda.
* Escenario Alternativo: Búsqueda bajo demanda.
  1. El usuario hace clic en un botón "Buscar" para realizar la búsqueda bajo demanda y actualizar resultados mostrados.
* Criterios de Aceptación
  - Los filtros son acumulativos entre si. 
  - Los filtros pueden ejecutarse de manera asíncrona sin necesidad de hacer clic en el botón "Buscar".
  - El botón "Buscar" permite realizar la búsqueda bajo demanda y actualizar los resultados mostrados.
  - Los resultados deben mostrarse en tarjetas con imagen, título del anuncio y costo publicado.
  - Los resultados deben paginarse mostrando una cantidad configurable de tarjetas por página.
  - El módulo de búsqueda de anuncios debe mostrar un enlace de acceso al módulo de contacto (Caso de Uso #2).
    
### 2. Enviar Mensaje de Contacto
* Condiciones Previas: El usuario necesita enviar un comentario a los administradores de Recursos Humanos. 
* Condiciones Posteriores: Los administradores de Recursos Humanos reciben comentario del usuario. 
* Actores
  * Principal: Empleado de la empresa.
  * Secundarios: Administrador de Recursos Humanos.
* Escenario Principal
  1. El usuario introduce su nombre.
  2. El usuario introduce un correo de contacto.
  3. El usuario introduce un comentario.
  4. El usuario hace clic en botón "Enviar".
  5. La aplicación valida información y envía correo al buzón configurado.
* Escenario Alternativo: Campos vacíos.
  1. La aplicación muestra mensaje de error indicando que todos los campos son requeridos.
* Criterios de Aceptación
  - Los adminstradores de Recursos Humanos deben recibir correos de contacto que
    incluyan los datos completos: nombre, correo y comentario.


## Requisitos
La aplicación está escrita en [Kotlin](https://kotlinlang.org/) y compilada
para Java Virtual Machine (JVM) compatible con [JDK 11](https://jdk.java.net/).

Opcionalmente, si se utiliza [GraalVM](https://www.graalvm.org/), que es una distribución del JDK,
además de ejecutarse sobre JVM, puede compilarse a una [Imagen Nativa](https://www.graalvm.org/docs/getting-started/#native-images)
del sistema operativo donde será ejecutada con la finalidad de mejorar tiempo de arranque y desempeño.


## TDD
Ejecutar los siguientes comandos para realizar las pruebas de los casos de uso.

### Linux & Mac
```shell
./gradlew test -i
```

### Windows
```shell
.\gradlew.bat test -i
```


## Ejecución Local Sobre JVM
Ejecutar los siguientes comandos para iniciar la aplicación en ambiente de desarrollo local y sobre JVM.

### Linux & Mac
```shell
MICRONAUT_ENVIRONMENTS=development ./gradlew run --continuous
```

### Windows
```shell
MICRONAUT_ENVIRONMENTS=development .\gradlew.bat run --continuous
```

## Ejecución Local como Imagen Nativa
Si se utiliza GraalVM es posible crear una imagen nativa de la aplicación y ejecutar con un mejor tiempo de inicio y desempeño.
```shell

```