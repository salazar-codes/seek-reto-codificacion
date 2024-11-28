# Guía de Configuración y Ejecución de la Aplicación

Esta guía proporciona instrucciones detalladas para configurar y ejecutar la aplicación en su entorno local.

## Requisitos Previos

Antes de comenzar, asegúrese de tener instalados los siguientes componentes:

- **Java Development Kit (JDK) 17**: La aplicación está desarrollada utilizando Java 17. Puede descargarlo desde el [sitio oficial de Oracle](https://www.oracle.com/java/technologies/downloads/).

- **Maven 3.8.1 o superior**: Se utiliza Maven como herramienta de construcción y gestión de dependencias. Descárguelo desde [aquí](https://maven.apache.org/download.cgi).

- **MySQL 8.0 o superior**: La aplicación utiliza una base de datos MySQL. Puede obtenerla en el [sitio oficial de MySQL](https://dev.mysql.com/downloads/).

## Configuración de la Base de Datos

1. **Instalación de MySQL**: Siga las instrucciones de instalación proporcionadas en el [sitio oficial de MySQL](https://dev.mysql.com/downloads/).

2. Para facilitar la configuración de la base de datos, puede utilizar Docker Compose para crear un contenedor de MySQL. A continuación, se muestra un archivo docker-compose.yml que define un servicio de MySQL:

```yaml
version: '3'

services:
  mysqldb:
    image: mysql
    container_name: seek-candidate-db
    ports:
      - 3307:3306
    expose:
      - '3306'
    environment:
      - MYSQL_DATABASE=candidate_db
      - MYSQL_USER=user
      - MYSQL_PASSWORD=password
      - MYSQL_ROOT_PASSWORD=password
    volumes:
      - ./mysql-data:/var/lib/mysql
volumes:
  mysql-data:
```
Para iniciar el contenedor, ejecute el siguiente comando en el directorio donde se encuentra el archivo docker-compose.yml:

bash
Copiar código
docker-compose up -d
Este comando descargará la imagen de MySQL, creará un contenedor con las credenciales y la base de datos especificadas, y expondrá el puerto 3306 para que la aplicación pueda conectarse a él. 

2. **Creación de la Base de Datos**:

    - Acceda a la consola de MySQL:

      ```bash
      mysql -u root -p
      ```

    - Cree la base de datos:

      ```sql
      CREATE DATABASE candidate_db;
      ```

    - Salga de la consola de MySQL:

      ```sql
      EXIT;
      ```

3. **Estructura de la Base de Datos**:

    - **Tabla `users`**:

      ```sql
      CREATE TABLE users (
          id BIGINT AUTO_INCREMENT PRIMARY KEY,
          email VARCHAR(255) NOT NULL,
          password VARCHAR(255) NOT NULL,
          first_name VARCHAR(255),
          last_name VARCHAR(255)
      );
      ```

    - **Datos de Prueba**:

      ```sql
      INSERT INTO users (email, password, first_name, last_name) VALUES
      ('juan.perez@example.com', 'password123', 'Juan', 'Pérez'),
      ('maria.gomez@example.com', 'password456', 'María', 'Gómez');
      ```

## Configuración de la Aplicación

1. **Clonación del Repositorio**:

    - Clone el repositorio de la aplicación en su máquina local:

      ```bash
      git clone https://github.com/salazar-codes/seek-reto-codificacion
      ```

2. **Configuración de Propiedades**:

    - Navegue al directorio del proyecto:

      ```bash
      cd repositorio
      ```

    - Abra el archivo `src/main/resources/application.properties` y configure las siguientes propiedades:

      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/candidate_db
      spring.datasource.username=su_usuario
      spring.datasource.password=su_contraseña
      spring.jpa.hibernate.ddl-auto=update
      ```

    - Reemplace `su_usuario` y `su_contraseña` con las credenciales de su base de datos MySQL.

## Construcción y Ejecución de la Aplicación

1. **Construcción del Proyecto**:

    - Ejecute el siguiente comando para compilar y empaquetar la aplicación:

      ```bash
      mvn clean install
      ```

2. **Ejecución de la Aplicación**:

    - Inicie la aplicación con el siguiente comando:

      ```bash
      mvn spring-boot:run
      ```

    - La aplicación estará disponible en `http://localhost:8091`.

## Acceso a la Documentación de la API

La aplicación incluye documentación de la API generada con OpenAPI 3.

- **Swagger UI**: Acceda a la interfaz de usuario de Swagger en `http://localhost:8091/swagger-ui.html` para explorar y probar los endpoints de la API.

- **Especificación OpenAPI**: La especificación completa de la API está disponible en formato JSON en `http://localhost:8091/v3/api-docs`.

## Pruebas de la Aplicación

La aplicación incluye pruebas automatizadas que se ejecutan con Maven.

- **Ejecución de Pruebas**:

  ```bash
  mvn test
  ```

- **Cobertura de Pruebas**: Para generar un informe de cobertura de pruebas, ejecute:

  ```bash
  mvn jacoco:report
  ```

  El informe estará disponible en `target/site/jacoco/index.html`.

## Consideraciones Adicionales

- **Variables de Entorno**: Para mayor seguridad, considere utilizar variables de entorno para las credenciales de la base de datos en lugar de almacenarlas directamente en el archivo `application.properties`.

- **Configuración de Seguridad**: La aplicación utiliza Spring Security para proteger los endpoints. Asegúrese de que las rutas necesarias estén configuradas para permitir el acceso según sea necesario.

- **Actualizaciones de Dependencias**: Mantenga las dependencias del proyecto actualizadas para aprovechar las últimas características y correcciones de seguridad.

Para más detalles sobre la configuración y uso de la aplicación, consulte la documentación oficial en el repositorio del proyecto. 