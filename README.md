
# 🚀 Proyecto de Microservicios

Este proyecto implementa una arquitectura de microservicios utilizando **Spring Boot**, **PostgreSQL (Supabase)** y **MongoDB Atlas**. Está diseñado para ser modular, escalable y de fácil mantenimiento.

---

## 🖥️ Importar el Proyecto en Visual Studio Code

1. Abre **Visual Studio Code**.  
2. Dirígete a `File` → `Open Folder`.  
3. Selecciona la carpeta raíz del proyecto.  
4. **VS Code** detectará automáticamente los proyectos de Maven y cargará las dependencias.  

---

## 📦 Guía de Instalación

### 1️⃣ Compilación del Proyecto

Ejecuta el siguiente comando en la raíz del proyecto para compilar todos los microservicios:  
```bash
mvn clean package
```  
Esto generará los archivos `.jar` en las carpetas `target` de cada microservicio.  

---

### 2️⃣ Ejecución de los Microservicios

Primero, ejecuta el microservicio de configuración centralizada:  
```bash
java -jar microservices-config/target/microservices-config.jar
```  

Luego, ejecuta los demás microservicios en el siguiente orden:  
```bash
java -jar microservices-cliente/target/microservices-cliente.jar
java -jar microservices-producto/target/microservices-producto.jar
java -jar microservices-cajero/target/microservices-cajero.jar
java -jar microservices-formapago/target/microservices-formapago.jar
java -jar microservices-compra/target/microservices-compra.jar
java -jar microservices-compratotal/target/microservices-compratotal.jar
java -jar microservices-interfaz/target/microservices-interfaz.jar
```  

---

### 3️⃣ Ejecución con Docker

Si prefieres ejecutar los microservicios con Docker, utiliza el siguiente comando:  
```bash
docker-compose up --build
```  
Esto construirá y levantará todos los contenedores definidos en el archivo `docker-compose.yml`.  

---

## 📊 Configuración de Base de Datos

- **PostgreSQL:** Configurado en [Supabase](https://supabase.com/).  
- **MongoDB Atlas:** Para la gestión de ciertos datos.  

Asegúrate de configurar las credenciales de acceso en los archivos `application.yml` de cada microservicio.  

---

## 📝 Ejecución de Pruebas

Para ejecutar las pruebas unitarias e integradas en el proyecto:  
```bash
mvn test
```  

---

## 📢 Contribuciones

¿Te gustaría contribuir? ¡Sigue estos pasos!  

1. Haz un **fork** del repositorio.  
2. Crea una nueva rama para tu funcionalidad:  
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```  
3. Realiza tus cambios y confirma los commits:  
   ```bash
   git commit -m 'Agregada nueva funcionalidad'
   ```  
4. Sube tus cambios al repositorio:  
   ```bash
   git push origin feature/nueva-funcionalidad
   ```  
5. Abre un **Pull Request** en GitHub para revisión.  

---

## 💡 Contacto

**Desarrollado por:** [Tu Nombre o Equipo]  
**Correo:** [tu-email@example.com]  
**GitHub:** [https://github.com/tu-usuario](https://github.com/tu-usuario)  

---

¡Si necesitas más ayuda o deseas personalizar alguna sección, házmelo saber!
