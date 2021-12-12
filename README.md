# Tarjetas Banamex
Proyecto para recomendar tarjetas Banamex - IBM Academy.  Proyecto basado en: [Entregable.docx](https://github.com/Rengeruri/TarjetasBanamex/files/7698101/Entregable.docx)

La arquitectura de este proyecto me gustó bastante pues solo tiene 3 entidades: Usuario, Perfil y Tarjeta. La lógica es simple pues si observamos la tabla del documento veremos que son perfiles ideales para recomendar las tarjetas. Por el diseño de la tabla cada usuario puede caer solo en un perfil (muchos usuarios pueden pertenecer a un perfil), y cada perfil puede tener varias tarjetas (también una tarjeta puede estar en varios perfiles). De ahí el modelo entidad-relación 😄

## 9/12/2021

Se subió el proyecto con la estructura de las entidades, los contratos y las implementaciones. Me gustó mucho la arquitectura de las relaciones entre ellas por lo que no debería cambiar.

Falta por hacer: Testing y controladores.

## 11/12/2021

El proyecto sufrió bastantes detalles así que lo numeraré.

#### Se implementó:
1. ¡Ya hace lo que pide el documento! Técnicamente el proyecto ya es funcional, aún así lo seguiré retocando.
2. Se implementó una función en el repositorio de Perfil. Este método logra, a través de una petición a la BD, extraer el perfil en el que cae el usuario y por ende ya podemos conocer sus tarjetas recomendadas.
3. Ahora tiene controladores funcionales con los métodos que creí necesarios para el funcionamiento; no hay muchos por lo mismo.
4. El controlador de Usuario tiene un método solo para guardar al usuario (soloGuardarUsuario()) y otro para guardarlo con su busqueda de perfil ideal(guardarUsuario()), este segundo es el que le otorga la funcionalidad.

#### Detalles:
1. Algunas funciones están en español y otras en inglés. Esto lo hice por cuestiones de tiempo pues la mayoría se implementaron a través del Query Method y las personalizadas a través de la notación @Query. Al final todas estarán en español con la notación @Query.
2. La función guardarUsuario() tiene bastante lógica para mi gusto.
3. Implementar DTO: Creo que el punto 3 se soluciona con DTO, tendré que ver las repeticiones de las clases.

Falta por hacer: Testing, swagger y DTO
