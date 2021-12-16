# Tarjetas Banamex
Proyecto para recomendar tarjetas Banamex - IBM Academy.  Proyecto basado en: [Entregable.docx](https://github.com/Rengeruri/TarjetasBanamex/files/7698101/Entregable.docx)

El proyecto sufrió un cambio de enfoque. Originalmente había una relación uno a muchos entre Usuario y Perfil, y una relación muchos a muchos entre Perfil y Tarjetas. Ahora la entidad Usuario ha sido eliminada pues no es necesario realizar CRUD's con los usuarios, pero mantego eso en las otras dos entidades pues es mi forma de almacenar la información de la tabla.
La filosofía de la entidad relación esta basada en que el un perfil puede tener muchas tarjetas y que muchas tarjetas pueden estar en varios perfiles. Cuando se quiere hacer una recomendación se ingresan los 3 parametros especificados en el documento y se encuentra el perfil que tenga los rangos donde el usuario pueda pertenecer.

## 13/12/2021

#### Se implementó
1. El proyecto ya tiene una funcionalidad con parametros. Antes era con variables.
2. Se eliminó la lógica de los controladores, ahora solo hay condiciones para lanzar las excepciones.
3. Todas las funciones ya están en español.
4. Todas las funciones de los controladores ya están encapsuladas.

#### Detalles:
1. Implementar DTO para extraer solo las tarjetas en las consultas.
2. Mantengo el GenericoDAO y el GenericoDAOImp pues los utilicé para guardar la información de las tarjetas y los perfiles a la base de datos. Preguntar a David si eso justifica su permanencia o tengo que eliminarlo de todos modos.
3. Se eliminó la entidad usuario, ahora es una clase que no hace nada por lo que la eliminaré si al final no es requerida.

Falta por hacer: Testing, swagger, DTO y documentación.

## 15/12/2021

#### Se implementó
1. Se agregó DTO para que la impresión de las tarjetas fuera limpia.
2. Se implementó testeo para el repositorio de Perfil, solamente se hizo con una función pues es la única función implementada en el DAO.
3. Se agregó la documentación a los métodos de los controladores de Perfil y de Tarjeta.

#### Detalles:
1. Aún mantengo la clase inútil: Usuario. Mañana David me recomendará eliminarla o no.

Falta por hacer: Implementar Swagger
