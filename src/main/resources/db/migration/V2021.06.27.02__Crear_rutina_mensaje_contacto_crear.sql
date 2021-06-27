create or replace function mensaje_contacto_crear(
    _nombre varchar(50),
    _correo varchar(50),
    _comentario varchar(100),
    _situacion situacion_mensaje_contacto,
    _fecha_registro timestamp with time zone
) returns int language plpgsql as $$
    begin
        insert into mensaje_contacto
            (nombre, correo, comentario, situacion, fecha_registro)
        values
            (_nombre, _correo, _comentario, _situacion, _fecha_registro)
        ;

        return lastval();
    end
    $$
