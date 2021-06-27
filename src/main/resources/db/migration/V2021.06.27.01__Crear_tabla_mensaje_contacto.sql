create type situacion_mensaje_contacto as enum('REGISTRADO', 'ENVIADO', 'FALLIDO');

create table mensaje_contacto (
    id_mensaje_contacto serial not null primary key,
    nombre varchar(50) not null,
    correo varchar(50) not null,
    comentario varchar(100) not null,
    situacion situacion_mensaje_contacto not null,
    destino varchar(50) null,
    fecha_registro timestamp with time zone not null,
    fecha_procesamiento timestamp with time zone null,
    comentario_procesamiento text null
);

create index ix$mensaje_contacto$correo on mensaje_contacto(correo);
create index ix$mensaje_contacto$situacion on mensaje_contacto(situacion);
create index ix$mensaje_contacto$fecha_registro on mensaje_contacto(fecha_registro);
