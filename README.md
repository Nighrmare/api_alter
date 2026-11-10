# **ALTER - API de Tienda Virtual (Proyecto de Formación)**

API REST desarrollada como parte del proyecto de formación ALTER del SENA. Su propósito es gestionar la información de una tienda virtual de prendas de vestir y servir como backend para el proyecto frontend.

## **Información del Aprendiz**

- **Nombre:** Luisa Maria Bastidas Londoño
- **Programa:** Análisis y Desarrollo de Software (ADSO)
- **Número de Ficha:** 3186697
- **Centro de Formación:** CLEM
## **Sobre el proyecto**

ALTER es una tienda virtual enfocada en la venta de prendas de vestir. El proyecto se está desarrollando por partes, separando el frontend del backend para organizar mejor sus funcionalidades, este repositorio corresponde al backend, desarrollado con Spring Boot, encargado de gestionar la información mediante una API REST y conectarse a una base de datos MySQL. Actualmente, cuenta con la gestión de categorías mediante operaciones CRUD (crear, consultar, actualizar y eliminar). Se irán incorporando nuevas funcionalidades a medida que avance el desarrollo.

## **Tecnologías utilizadas**

- **Java 25:** lenguaje de programación utilizado para desarrollar el backend.
- **Spring Boot 4:** framework para la creación y configuración de la aplicación.
- **Spring Web MVC:** permite crear los controladores y endpoints REST.
- **Spring Data JPA / Hibernate:** facilita la comunicación entre la aplicación y la base de datos.
- **MySQL:** sistema de gestión de la base de datos.
- **Maven:** gestión de dependencias y construcción del proyecto.
- **Lombok:** reduce código repetitivo, como getters y setters.
- **Git y GitHub:** control de versiones y almacenamiento del código fuente.
- **Postman:** herramienta utilizada para probar los endpoints de la API.

## **Estructura del proyecto**

```text
tienda/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/alter/tienda/
│   │   │       ├── controller/
│   │   │       │   └── CategoriaController.java
│   │   │       ├── model/
│   │   │       │   └── Categoria.java
│   │   │       ├── repository/
│   │   │       │   └── CategoriaRepository.java
│   │   │       ├── service/
│   │   │       │   └── CategoriaService.java
│   │   │       ├── ServletInitializer.java
│   │   │       └── TiendaApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/alter/tienda/
│               └── TiendaApplicationTests.java
├── .env.example
├── .gitignore
├── .gitattributes
├── pom.xml
└── README.md
```
## **Funcionalidades actuales**

- Conexión de Spring Boot con una base de datos MySQL.
- Configuración de la conexión mediante variables de entorno.
- Consulta de todas las categorías registradas.
- Consulta de una categoría por su identificador.
- Registro de nuevas categorías.
- Actualización del nombre y la descripción de una categoría.
- Eliminación de categorías.
- Validación del nombre al registrar o actualizar una categoría.
- Respuestas HTTP para indicar el resultado de las operaciones.

## **Endpoints de categorías**

La ruta base es `/api/categorias`.

| **Método** | **Ruta** | **Descripción** | **Respuesta exitosa** |
|---|---|---|---|
| `GET` | `/api/categorias` | Lista todas las categorías. | `200 OK` |
| `GET` | `/api/categorias/{id}` | Consulta una categoría por su ID. | `200 OK` |
| `POST` | `/api/categorias` | Registra una nueva categoría. | `201 Created` |
| `PUT` | `/api/categorias/{id}` | Actualiza una categoría existente. | `200 OK` |
| `DELETE` | `/api/categorias/{id}` | Elimina una categoría. | `204 No Content` |

**Ejemplo del cuerpo para registrar o actualizar una categoría:**

```json
{
    "nombre": "Accesorios",
    "descripcion": "Productos complementarios"
}
```

El nombre es obligatorio y no puede estar vacío. Si la información enviada no cumple esta condición, la API responde `400 Bad Request`. Si el identificador solicitado no existe, responde `404 Not Found`. Los endpoints fueron probados utilizando Postman, verificando las respuestas de las operaciones CRUD y algunos casos de validación.

## **Instalación y ejecución**

### **Requisitos**

- JDK 25 o superior.
- Apache Maven instalado.
- MySQL en ejecución.
- Base de datos `alter` creada previamente, con las tablas correspondientes al proyecto.

La aplicación utiliza `ddl-auto=validate`, por lo que Hibernate comprueba que la estructura de la base de datos sea compatible con las entidades, pero no crea ni modifica las tablas automáticamente.

### **Configuración local**

1. Clonar el repositorio:

```powershell
git clone https://github.com/Nighrmare/api_alter.git
```

2. Ingresar a la carpeta del proyecto:

```powershell
cd api_alter
```

3. Crear el archivo `.env` a partir de la plantilla:

```powershell
Copy-Item .env.example .env
```

4. Abrir el archivo `.env` y configurar los datos de conexión a MySQL:

```properties
DB_URL=jdbc:mysql://localhost:3306/alter
DB_USERNAME=root
DB_PASSWORD=cambia_esta_contrasena
```

Reemplazar los valores de ejemplo por los datos correspondientes a la instalación local de MySQL. Si la contraseña está vacía, se puede dejar `DB_PASSWORD=`.

El archivo `.env` contiene la configuración local y está excluido de Git para evitar publicar credenciales. El archivo `.env.example` sí se incluye en el repositorio como plantilla.

### **Ejecutar el proyecto**

5. Ejecutar las pruebas:

```powershell
mvn test
```

6. Iniciar la aplicación:

```powershell
mvn spring-boot:run
```

Una vez iniciada, la API estará disponible en:

`http://localhost:8080`

Para consultar las categorías se puede utilizar:

`http://localhost:8080/api/categorias`

También se pueden probar las demás operaciones mediante Postman.

## **Estado del proyecto**

El backend de ALTER se encuentra en desarrollo. Actualmente cuenta con la configuración inicial de Spring Boot, la conexión a MySQL y el CRUD de categorías.

### **Funcionalidades pendientes**

- Implementar el CRUD de productos.
- Gestionar las variantes de productos (tallas, colores y existencias).
- Implementar el registro y la autenticación de usuarios.
- Gestionar las direcciones de entrega.
- Desarrollar el carrito de compras.
- Implementar la gestión de pedidos y sus detalles.
- Incorporar la gestión de pagos.

A medida que avance el proyecto, se irán agregando nuevas funcionalidades y actualizando esta documentación.