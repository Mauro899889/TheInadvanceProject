1- No se necesita ningun script de creacion de base de datos, se crea automaticamente y se inserta el regex inicial de validacion de contraseña.

2- Levantar la aplicacion, la app consta de 2 endpoints

Endpoint 1: Crear un nuevo usuario
URL: http://localhost:8080/users
Método: POST
Produce: application/json
Consume: application/json

Example:

{
"name": "Juan Rodriguez2",
"email": "ajuanr2290488@odriguez.org",
"password": "hunter67",
"phones": [
{
"number": "1234567",
"citycode": "21",
"contrycode": "57"
}
]
}

Endpoint 2: Actualizar el regex de validacion de las contraseñas. El property usado es el llamado passwordRegex.
URL: http://localhost:8080/users/configurations/{property}
Método: POST
Produce: application/json
Consume: application/json

Example:
{
"value": "^\\d+$"
}


3- Credenciales de bd h2 embedded http://localhost:8080/h2-console
User: a
Pwd: a

4- Swagger: http://localhost:8080/swagger-ui/index.html

