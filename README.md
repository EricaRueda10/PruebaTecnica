# Prueba Técnica - Backend Spring Boot

Proyecto Spring Boot que autentica usuarios con la API de DummyJSON y guarda en PostgreSQL los datos del login, incluyendo usuario, hora, tokenAcceso y tokenRefresh.

## 🛠️ Instrucciones de ejecución

### 1. Clonar el repositorio

git clone https://github.com/EricaRueda10/PruebaTecnica.git

### 2. Configurar la base de datos (PostgreSQL)

Se debe tener la BD PostgreSQL ejecutándose y un esquema creado.

Base de datos: loginbd

<img width="68" alt="{58FFD9CB-5009-479F-BD88-D74AEDFC9647}" src="https://github.com/user-attachments/assets/43d66630-c2fa-43c0-8c96-93e693a4d32d" />

Usuario: postgres

Contraseña: Erica08.

El archivo application.properties debe verse así:

![img_1.png](img_1.png)

### 3. Ejecutar la aplicación desde su clase PruebaTecnicaMain

La aplicación se ejecuta correctamente y puedes usar los 
siguientes scripts para inicar sesión:

Ejemplo de login con curl: 

curl -X POST http://localhost:8080/api/auth/login  -H "Content-Type: application/json" -d '{"username": "evelyng", "password": "evelyngpass"}'

Ejemplo de json para probar en postman:

![img_2.png](img_2.png)

### 4. Consultar la BD para ver los registros guardados cada que se inicia sesión

![img_3.png](img_3.png)

![img_4.png](img_4.png)

![img_5.png](img_5.png)

### 5. Explicación de cómo se guarda el registro de login

Cuando un usuario realiza una autenticación a través del endpoint /api/auth/login, la aplicación envía sus credenciales (username y password) a la API externa https://dummyjson.com/auth/login utilizando un FeignClient. Si las credenciales son válidas, la API responde con un accessToken, un refreshToken y los datos del usuario autenticado.

Con esta información, el sistema construye una instancia de la entidad Login, la cual contiene los siguientes campos: username, loginTime (la fecha y hora actual del login), accessToken y refreshToken. Luego, esta instancia se guarda en la base de datos mediante el repositorio LoginRepository, el cual extiende JpaRepository, usando el método save.

Este proceso permite almacenar un historial de inicios de sesión válidos, registrando quién accedió, cuándo lo hizo y con qué tokens de autenticación, lo cual es útil para trazabilidad y auditoría.
