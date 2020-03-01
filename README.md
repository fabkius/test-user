# test-user
ms para agregar usuarios a una bd en memoria H2 con generación de token de sesion con JWT


Arquitectura:

Se realiza solución sobre un ms creado con springboot 2.0 con java versión 8, se estructura y ordena internamente en la separación de 3 capas (capa controladores, capa de negocio y capa de acceso a datos), se implementa una bd en memoria H2 la cual autogenera sus tablas y relaciones en base a los objetos de dominio que se utilizan en el guardado y consulta de los datos.

Se implemeta Hibernate para la persistencia con la bd.

Se implementa para la seguridad de las sessiones JWT.

Deuda tecnica:

- Falto realizar test en la capa de acceso a datos (por temas de tiempo no alcancé a buscar otras soluciones en los mock con hibernate)
- No se alcanzo a implementar uuid en los id de los registros, solo se implemento un identificador tipo Long.

