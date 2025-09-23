Proyecto API de Usuarios, Reservas y Eventos 🎟️

Este proyecto es una API REST construida con **Spring Boot**, que gestiona **usuarios, eventos y reservas**.  
La arquitectura sigue el patrón de **capas (controlador, servicio y repositorio)** y utiliza **Spring Data JPA** para la persistencia en base de datos.

---

Tecnologías utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- Spring Web
- MySQL
- Maven
- Lombok
- JUnit 5 + Mockito (para pruebas unitarias)

---

Estructura del proyecto
```
src/main/java/com/miapp
 ┣ controller   → Controladores REST
 ┣ service      → Servicios con la lógica de negocio
 ┣ repository   → Repositorios JPA
 ┣ model        → Entidades y DTOs
 ┗ exception    → Manejo de excepciones
```

---

Configuración
Clonar repositorio
``bash
git clone https://github.com/tuusuario/tu-repo.git
cd tu-repo
``

Configurar base de datos
En `application.properties` 

#MySQL
`````
spring.datasource.url=jdbc:mysql://localhost:3306/miapp
spring.datasource.username=root
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
``````

Ejecutar aplicación
bash
mvn spring-boot:run


---

# Endpoints principales
#Usuarios
- GET /usuarios → Listar todos los usuarios
- GET /usuarios/{id} → Obtener un usuario por ID
- POST /usuarios → Crear un nuevo usuario
- PUT /usuarios/{id} → Editar usuario existente
- DELETE /usuarios/{id} → Eliminar usuario

#Reservas
- GET /reservas → Listar todas las reservas
- GET /reservas/{id} → Obtener una reserva por ID
- POST /reservas → Crear una nueva reserva
- PUT /reservas/{id} → Editar reserva existente
- DELETE /reservas/{id} → Eliminar reserva

#Eventos
- GET /eventos → Listar todos los eventos
- GET /eventos/{id} → Obtener un evento por ID
- POST /eventos → Crear un nuevo evento
- PUT /eventos/{id} → Editar evento existente
- DELETE /eventos/{id} → Eliminar evento

Autor

Proyecto desarrollado por Jorge Alberto Sanchez Nava.

