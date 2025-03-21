# Invoice Management System

Este es un sistema de gestión de facturas desarrollado con **Spring Boot**, **JPA (Hibernate)** y **Swagger** para documentación de la API.

## 🚀 Tecnologías Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- Lombok
- Swagger OpenAPI
- MySQL (o H2 para pruebas)
- Maven

## 📦 Instalación y Configuración

### 1. Clonar el repositorio
```sh
 git clone https://github.com/tu_usuario/tu_proyecto.git
 cd tu_proyecto
```

### 2. Configurar Base de Datos
En `src/main/resources/application.properties`, configurar los detalles de la base de datos:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/invoice_db
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

Si deseas usar **H2 en memoria**, cambia a:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

### 3. Construir y ejecutar la aplicación
```sh
 mvn clean install
 mvn spring-boot:run
```

La aplicación estará corriendo en `http://localhost:8080`

## 🔗 Endpoints de la API

La documentación de la API está disponible en **Swagger**:
- `http://localhost:8080/swagger-ui.html`

### 📄 Endpoints Principales

#### **Clientes**
- `GET /clients` → Obtener todos los clientes
- `POST /clients` → Crear un nuevo cliente
- `GET /clients/{id}` → Obtener un cliente por ID
- `PUT /clients/{id}` → Actualizar un cliente
- `DELETE /clients/{id}` → Eliminar un cliente

#### **Facturas**
- `GET /invoices` → Obtener todas las facturas
- `POST /invoices` → Crear una nueva factura
- `GET /invoices/{id}` → Obtener una factura por ID
- `PUT /invoices/{id}` → Actualizar total de la factura
- `DELETE /invoices/{id}` → Eliminar una factura

#### **Productos**
- `GET /products` → Obtener todos los productos
- `POST /products` → Crear un nuevo producto
- `GET /products/{id}` → Obtener un producto por ID
- `PUT /products/{id}` → Actualizar producto
- `DELETE /products/{id}` → Eliminar un producto

## 🛠 Configuración Adicional

### 📌 Habilitar Lombok en tu IDE
Si tienes problemas con Lombok, asegúrate de:
1. Instalar el **plugin de Lombok** en tu IDE.
2. Habilitar **annotation processing** en la configuración.

### 📌 Base de Datos
Para MySQL, crea la base de datos antes de ejecutar la aplicación:
```sql
CREATE DATABASE invoice_db;
```




