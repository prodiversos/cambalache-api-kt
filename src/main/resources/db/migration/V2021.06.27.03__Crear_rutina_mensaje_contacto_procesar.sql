create or replace function mensaje_contacto_procesar(
    _id_mensaje_contacto int,
    _situacion situacion_mensaje_contacto,
    _destino varchar(50),
    _fecha_procesamiento timestamp with time zone,
    _comentario_procesamiento text
) returns void language plpgsql as $$
    begin
        update mensaje_contacto
        set
            situacion = _situacion,
            destino = _destino,
            fecha_procesamiento = _fecha_procesamiento,
            comentario_procesamiento = _comentario_procesamiento
        where id_mensaje_contacto = _id_mensaje_contacto
        ;
    end
    $$
