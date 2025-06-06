# Microservices Administración de compras Project

Este proyecto es una arquitectura de microservicios desarrollada con **Spring Boot** y **PostgreSQL** para la gestión de clientes, productos, compras, formas de pago y más. Está diseñado para ser modular, escalable y fácil de mantener.

## 🚀 Microservicios Incluidos

- **microservices-cajero:** Gestión de cajeros.
- **microservices-cliente:** Administración de clientes.
- **microservices-compra:** Procesamiento de compras.
- **microservices-compratotal:** Cálculo del total de compras.
- **microservices-config:** Configuración centralizada para todos los microservicios.
- **microservices-formapago:** Gestión de formas de pago.
- **microservices-interfaz:** Interfaz gráfica para la interacción con los microservicios.
- **microservices-producto:** Gestión de productos.

## ⚙️ Tecnologías Utilizadas

- **Java 22**
- **Spring Boot 3.3.2**
- **PostgreSQL (Supabase)**

---

## 🖥️ Configuración del Entorno en Visual Studio Code

1. **Instalar Java y Maven:**
   - Asegúrate de tener [Java 22](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html) y [Maven](https://maven.apache.org/download.cgi) instalados.
   - Verifica las versiones:
     ```bash
     java -version
     mvn -version
     ```

2. **Instalar Extensiones de VS Code:**
   - Java Extension Pack
   - Spring Boot Extension Pack
   - Docker
   - PostgreSQL

3. **Clonar el Repositorio:**
   ```bash
   git clone https://github.com/Bryan03A/ProyectoControl/ cd tu-repositorio
   ```

4. **Importar el Proyecto en VS Code:**
   - Abre VS Code → `File` → `Open Folder` → Selecciona la carpeta del proyecto.
   - VS Code detectará automáticamente los proyectos de Maven.

---

## 📦 Guía de Instalación

### 1️⃣ Compilación del Proyecto

```bash
mvn clean package
```
Esto generará los archivos `.jar` en las carpetas `target` de cada microservicio.

### 2️⃣ Ejecución de los Microservicios

Primero, ejecuta el microservicio de configuración centralizada:

```bash
java -jar microservices-config/target/microservices-config.jar
```

Luego, ejecuta los demás microservicios en este orden:

```bash
java -jar microservices-cliente/target/microservices-cliente.jar
java -jar microservices-producto/target/microservices-producto.jar
java -jar microservices-cajero/target/microservices-cajero.jar
java -jar microservices-formapago/target/microservices-formapago.jar
java -jar microservices-compra/target/microservices-compra.jar
java -jar microservices-compratotal/target/microservices-compratotal.jar
java -jar microservices-interfaz/target/microservices-interfaz.jar
```

## 📊 Base de Datos

- **PostgreSQL**: Configurado en [Supabase](https://supabase.com/).
- **MongoDB Atlas**: Para la gestión de ciertos datos.
- puede acceder a la base de datos desde un administrador mediante:
```psql -h aws-0-us-west-1.pooler.supabase.com -p 5432 -d postgres -U postgres.tseqkdyltupklalpgtki```

Configura las credenciales de las bases de datos en los archivos `application.yml` de cada microservicio.

---

## 📝 Pruebas

Para ejecutar las pruebas unitarias y de integración:

```bash
mvn test
```

---

## 📢 Contribuciones

Si deseas contribuir:
1. Haz un fork del repositorio.
2. Crea una rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m 'Agregada nueva funcionalidad'`).
4. Sube tus cambios (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

---

## 💡 Contacto

Desarrollado por Equipo 1 
Correo: [baaguirre@uce.edu.ec]  
GitHub: [https://github.com/BryanA03]
