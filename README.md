# Getting Started - Oesía Test

## Espanhol

¡Hola!

Para la prueba propuesta utilicé las siguientes tecnologías asociadas al framework Spring y Springboot:

*Java versión 17

*Junit y Mockito

*Lombok

*Base de datos H2

*Flyway

*Spring Doc

Flyway es una herramienta para la gestión y versionado de desarrollo en bases de datos relacionales y la utilicé para gestionar los scripts que son responsables de generar la estructura de tablas y de registrar los datos iniciales en la base de datos H2, necesarios para la prueba propuesta.

No es necesaria ninguna acción de configuración. Al iniciar el proyecto, se crea una instancia de H2 y FlyWay se encarga de ejecutar los scripts para la generación de la estructura.

Después de la inicialización del proyecto, el console de H2 puede ser accedido a través del enlace: http://localhost:8080/h2-console. Utilizar "sa" para usuario y contraseña y "jdbc:h2:~/inditex" para JDBC URL

Añadí pruebas unitarias al proyecto, automatizando las pruebas unitarias para los escenarios propuestos en la prueba.

Para una mejor experiencia de documentación de la API que creo, incluí una dependencia de Spring Docs. Después de la inicialización del proyecto, el swagger con la documentación de la API puede ser accedido en el enlace: http://localhost:8080/swagger-ui/index.html

En caso de que el equipo que analizará el proyecto lo desee, puedo disponibilizar el proyecto también a través de GitHub.


## English

Hello!

For the proposed test, I used the following technologies associated with the Spring and Spring Boot frameworks:

*Java version 17

*JUnit and Mockito

*Lombok

*H2 Database

*Flyway

*Spring Doc

Flyway is managing and versioning development tool for databases, and I used it to manage the scripts tha are responsible for generate the table structure and the initial data on the H2 database, necessary for the proposed test.
No configuration action is required. When starting the project, an instance of H2 is created and FlyWay takes care of executing the scripts to generate the structure.

After the project is initialized, the H2 console can be accessed through the link: http://localhost:8080/h2-console. Use "sa" for both username and password and "jdbc:h2:~/inditex" for JDBC URL

I added unit tests to the project, automating the unit tests for the scenarios proposed in the test.

For a better API documentation experience that I created, I included a Spring Docs dependency. After the project is initialized, the Swagger with the API documentation can be accessed at the link: http://localhost:8080/swagger-ui/index.html