# test-user
ms para agregar usuarios a una bd en memoria H2 con generación de token de sesion con JWT

Instalacion:

- Para ejecutar ms se debe realizar con el comando (en el directorio raiz del proyecto): ./gradlew bootRun , levanta por el puerto 8081


Arquitectura:

    - Se realiza solución sobre un ms creado con springboot 2.0 con java versión 8, se estructura y ordena internamente en la separación de 3 capas (capa controladores, capa de negocio y capa de acceso a datos), se implementa una bd en memoria H2 la cual autogenera sus tablas y relaciones en base a los objetos de dominio que se utilizan en el guardado y consulta de los datos.

    - Se implemeta Hibernate para la persistencia con la bd.

    - Se implementa para la seguridad de las sessiones JWT.

    - Se realizan test unitarios en las clases principales del artefacto.

Deuda técnica:

    - Falto realizar test en la capa de acceso a datos (por temas de tiempo no alcancé a buscar otras soluciones en los mock con hibernate)
    - No se alcanzo a implementar uuid en los id de los registros, solo se implemento un identificador tipo Long (no me funciono a la primera el tema de las llaves foreaneas con hibernate).

Modo de uso:

Para ejecutar la creación de un usuario, se debe realizar los siguientes pasos:

 1) llamar a api rest: "/user/add" con el siguiente objeto para guardar un usuario:
    
    tipo: POST
    
	    {
		"name": "fabian book4",
		"email": "mails@mail1.com",
		"password": "Awetee16",
		"phones":[
			{
				"number":"3333",
				"citycode":"43",
				"contrycode": "12"
			}
			]
	    }
    
  En la respuesta, debera devolver el siguiente objeto:
 
    
	    {
	    "id": 2,
	    "created": "01-03-2020 02:16:50",
	    "modified": "01-03-2020 02:16:50",
	    "last_login": "01-03-2020 02:16:50",
	    "token": "Bearer       eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJuaXNzdW1KV1QiLCJzdWIiOiJtYWlsc0BtYWlsMS5jb20iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNTgzMDM5ODEwLCJleHAiOjE1ODMwNDA0MTB9.xvpuqCSllzywz6Y7LUROuIK5mwAYtmbu_daBAFoXv7M3bdHgfnlUIho61p1DiiRcEsSKUjXtrBRx5VLPxWKrYQ",
	    "isactive": true
	}


 2) Para consultar el usuario creado, se debe invocar la api rest: "/user/find/{id a consultar}", y agregar en los headers, el atributo: "Authorization" con el valor del atributo "token" de la respuesta anterior.
 
Si la operacion del punto 3 es correcta, el servicio deberia retornar la siguiente respuesta:
 
	    {
	    "id": 2,
	    "name": "fabian book4",
	    "email": "mails@mail13.com",
	    "password": "Aweteeq1",
	    "phones": [
		{
		    "idphone": 1,
		    "number": "3333",
		    "citycode": "43",
		    "contrycode": "12"
		}
	    ]
	}
 
     
