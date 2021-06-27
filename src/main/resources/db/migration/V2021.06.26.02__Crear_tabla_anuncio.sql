create table anuncio (
    id_anuncio serial not null primary key,
    id_tipo_articulo varchar(50) not null,
    titulo varchar(200) not null,
    precio double precision not null,
    imagen text null,
    fecha_publicacion timestamp with time zone not null,
    nombre_anunciante varchar(100) not null,
    correo_anunciante varchar(255) not null,
    telefono_anunciante varchar(30) null,

    constraint fk$anuncio$tipo_articulo
        foreign key (id_tipo_articulo)
            references tipo_articulo(id_tipo_articulo)
            on update cascade on delete no action
);

create index ix$anuncio$titulo on anuncio (titulo);
create index ix$anuncio$precio on anuncio (precio);
create index ix$anuncio$fecha_publicacion on anuncio (fecha_publicacion);