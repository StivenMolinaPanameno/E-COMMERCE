# Proyecto de Seguridad con Spring Boot y JWT

Este proyecto es una aplicación que utiliza Spring Boot para la configuración de una base de datos MySQL y JWT para la autenticación y autorización.

Proyecto e-commerce, es la parte del backend de una aplicación de Sprng boot lista para ser consumida por el cliente, donde se hace uso de las posibilidades con **JWT, Spring Security, JUNIT, MYSQL, etc.**


## Configuración del Proyecto

Para configurar el proyecto, debes modificar las siguientes variables en el archivo `application.properties`.

### Variables de Configuración de la Base de Datos

- `spring.datasource.url`: URL de la base de datos MySQL.
  - **Ejemplo**: `jdbc:mysql://localhost:3306/securitydb`
  
- `spring.datasource.username`: Nombre de usuario de la base de datos.
  - **Ejemplo**: `root`
  
- `spring.datasource.password`: Contraseña de la base de datos.
  - **Ejemplo**: `root`
  
- `spring.datasource.driverClassName`: Clase del controlador JDBC de MySQL.
  - **Ejemplo**: `com.mysql.cj.jdbc.Driver`
  
- `spring.jpa.show-sql`: Habilita o deshabilita el registro de las sentencias SQL.
  - **Ejemplo**: `true`
  
- `spring.jpa.hibernate.ddlAuto`: Configuración de Hibernate para la actualización del esquema de la base de datos.
  - **Ejemplo**: `update`

### Variables de Configuración de JWT

- `jwt.secret.key`: Clave secreta utilizada para firmar el token JWT.
  - **Ejemplo**: `8F71ED9DB415E97C48978B1D2A6D9fasddfasdfasdeasdfadsfadsf`
  
- `jwt.time.expiration`: Tiempo de expiración del token JWT en milisegundos.
  - **Ejemplo**: `86400000`

## Instrucciones para Cambiar las Variables

1. Abre el archivo `application.properties` en el directorio `src/main/resources`.
2. Busca las variables que deseas cambiar y modifica sus valores según tus necesidades.
3. Guarda los cambios en el archivo `application.properties`.
4. Reinicia la aplicación para que se apliquen los nuevos valores de configuración.

## Ejemplo de Archivo `application.properties`

```properties
# Configuración de la Base de Datos
spring.datasource.url=jdbc:mysql://localhost:3306/securitydb
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.hibernate.ddlAuto=update

# Configuración de JWT
jwt.secret.key=8F71ED9DB415E97C48978B1D2A6D9fasddfasdfasdeasdfadsfadsf
jwt.time.expiration=86400000
