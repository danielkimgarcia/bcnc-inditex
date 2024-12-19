# Overview - Inditex Test

## Tecnologias

Para la prueba propuesta utilicé las siguientes tecnologías asociadas al framework Spring y Springboot:

- Java versión 17

- DevTools

- Lombok

- Flyway

- Base de datos H2

- Spring Doc

- Map Struct

- Junit y Mockito

- Jacoco Plugin

## Resumen

La arquitectura propuesta fue hexagonal, utilizando principios de SOLID y Clean Code. 

Se incluyeron pruebas unitarias en el proyecto para una cobertura máxima del código. El informe se puede consultar en la carpeta **target/jacoco/index.html**

**Flyway** es una herramienta para la gestión y versionado de desarrollo en bases de datos relacionales y la utilicé para gestionar los scripts que son responsables de generar la estructura de tablas y de registrar los datos iniciales en la base de datos **H2**, necesarios para la prueba propuesta.

Un controlador de excepciones personalizado fue utilizado para tratamento de excepciones **CustomExceptionHandler**

El contrato base utilizado para crear la API se puede encontrar en la carpeta **resources/openapi.yaml**

Un archivo fue utilizado para formatar las mensajes de validación **resources/ValidationMessages.properties**

**Notas importantes:** 

- La interfaz API creada para el controlador no se creó automáticamente a través del archivo de definición openAPI.yaml. Sin embargo, se recomienda ampliamente utilizar este procedimiento automatizado utilizando herramientas como swagger codegen u openApi Generator.
- Para esta prueba, la relación entre las entidades Marca y Precio se normalizó utilizando la anotación @ManyToOne, que para fines de rendimiento no se recomienda si los resultados no requieren dicha relación para devolver datos.
- Las pruebas se dividieron en pruebas unitarias y de integración. Según la convención de Maven, todas las clases tienen el sufijo final 'Test'. Sin embargo, para las clases de integración, el sufijo se creó como 'ITTest'. Esta convención se puede modificar y, de ser así, se deberá agregar un complemento adicional a pom.xml para que el informe de cobertura se pueda crear correctamente.
Ejemplo:

```
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.22.1</version>
        <includes>
            definiciones customizadas...
        </includes>
    </plugin>
```

## Comandos para build, install, test and start 

1. ```mvn clean install -Dmaven.test.skip=true```
2. ```java -jar target\danielgarciatest-0.0.1-SNAPSHOT.jar```
3. ```mvn test```
4. Acceder a la url http://localhost:8080/swagger-ui/index.html
5. Acceder console de H2 a través del enlace: http://localhost:8080/h2-console. Utilizar "sa" para usuario y contraseña y "jdbc:h2:mem:inditex" para JDBC URL


## English

Hello!

For the proposed test, I used the following technologies associated with the Spring and Spring Boot frameworks:

- Java version 17

- DevTools

- Lombok

- Flyway

- H2 Database

- Spring Doc

- Map Struct

- Junit y Mockito

- Jacoco Plugin

The proposed architecture was hexagonal, using SOLID and Clean Code principles.

Unit tests were included in the project for maximum code coverage. The report can be consulted in the folder **target/jacoco/index.html**

**Flyway** is a tool for managing and versioning development in relational databases and I used it to manage the scripts that are responsible for generating the table structure and registering the initial data in the database **H2 **, necessary for the proposed test.

A custom exception handler was used to handle **CustomExceptionHandler** exceptions.

The base contract used to create the API can be found in the **resources/openapi.yaml** folder

A file was used to format the validation messages **resources/ValidationMessages.properties**

**Important notes:** 

- The API interface created for the controller was not automatically created via the openAPI.yaml definition file. However, it is highly recommended to use this automated procedure using tools such as swagger codegen or openApi Generator.
- For this test, the relationship between the Brand and Price entities was normalized using the @ManyToOne annotation, which for performance purposes is not recommended if the results do not require such a relationship to return data.
- The tests were divided into unit and integration tests. According to Maven convention, all classes have the final suffix 'Test'. However, for integration classes, the suffix was created as 'ITTest'. This convention can be modified, and if so, an additional plugin will need to be added to pom.xml so that the coverage report can be created correctly.
Example:

```
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.22.1</version>
        <includes>
            your definitions here...
        </includes>
    </plugin>
```

## Commands to build, install, test and start the application

1. ```mvn clean install -Dmaven.test.skip=true```
2. ```java -jar target\danielgarciatest-0.0.1-SNAPSHOT.jar```
3. ```mvn test```
4. Go to swagger doc throught this link: http://localhost:8080/swagger-ui/index.html
5. H2 can be reached by this link: http://localhost:8080/h2-console. Use "sa" for user and password y "jdbc:h2:mem:inditex" as JDBC URL