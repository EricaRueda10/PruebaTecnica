# Prueba Técnica - Backend Spring Boot

Proyecto Spring Boot que autentica usuarios con la API de DummyJSON y guarda en PostgreSQL los datos del login, incluyendo usuario, hora, tokenAcceso y tokenRefresh.

## 🛠️ Instrucciones de ejecución

### 1. Clonar el repositorio

git clone https://github.com/EricaRueda10/PruebaTecnica.git

### 2. Configurar la base de datos (PostgreSQL)

Se debe tener la BD PostgreSQL ejecutándose y un esquema creado.

Base de datos: loginbd
<img width="68" alt="{58FFD9CB-5009-479F-BD88-D74AEDFC9647}" src="https://github.com/user-attachments/assets/43d66630-c2fa-43c0-8c96-93e693a4d32d" />

Tabla: 

<img width="128" alt="{14BC7C49-6964-45D3-8331-3F1EB7F02FE2}" src="https://github.com/user-attachments/assets/881972ee-3822-4403-aa46-5e7947d49f61" />

Usuario: postgres

Contraseña: Erica08.

El archivo application.properties debe verse así:

<img width="392" alt="{9CB1DB8C-758C-406F-8C43-DF225B79E396}" src="https://github.com/user-attachments/assets/81b4d739-2c32-4a3a-a7d4-c071be71be6f" />

### 3. Ejecutar la aplicación desde su clase PruebaTecnicaMain

La aplicación se ejecuta correctamente y puedes usar los 
siguientes scripts para inicar sesión:

Ejemplo de login con curl: 

curl -X POST http://localhost:8080/api/auth/login  -H "Content-Type: application/json" -d '{"username": "evelyng", "password": "evelyngpass"}'

Ejemplo de json para probar en postman:

<img width="492" alt="{2A5D86E5-DD17-4E40-A78D-057D1A5CD78E}" src="https://github.com/user-attachments/assets/f473d358-d36f-4a14-954f-f2bd31ba9279" />

### 4. Consultar la BD para ver los registros guardados cada que se inicia sesión

<img width="749" alt="{B259B1B4-3F12-4B55-86AD-BBD77CB9E185}" src="https://github.com/user-attachments/assets/a0956f7a-4ba9-4139-a9bc-6f2ec62d8ea8" />

<img width="753" alt="{605FF43B-603F-4CA0-8DA4-7AD97E6B8AB4}" src="https://github.com/user-attachments/assets/960c4f2e-4420-4782-8628-56440351773f" />

<img width="753" alt="{1AA7E845-7ECF-4773-A5F0-97104590D757}" src="https://github.com/user-attachments/assets/413d8267-8735-4181-b5ba-e6159233e044" />

### 5. Explicación de cómo se guarda el registro de login

Cuando un usuario realiza una autenticación a través del endpoint /api/auth/login, la aplicación envía sus credenciales (username y password) a la API externa https://dummyjson.com/auth/login utilizando un FeignClient. Si las credenciales son válidas, la API responde con un accessToken, un refreshToken y los datos del usuario autenticado.

Con esta información, el sistema construye una instancia de la entidad Login, la cual contiene los siguientes campos: username, loginTime (la fecha y hora actual del login), accessToken y refreshToken. Luego, esta instancia se guarda en la base de datos mediante el repositorio LoginRepository, el cual extiende JpaRepository, usando el método save.

Este proceso permite almacenar un historial de inicios de sesión válidos, registrando quién accedió, cuándo lo hizo y con qué tokens de autenticación, lo cual es útil para trazabilidad y auditoría.

## ¡Tener en cuenta!

En la siguiente ruta se encuentran más usuarios con los que se pueden hacer pruebas adicionales:

https://dummyjson.com/users
