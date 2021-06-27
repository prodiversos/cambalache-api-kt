insert into tipo_articulo
(id_tipo_articulo, descripcion)
select
       ta.id_tipo_articulo,
       ta.descripcion
from (
    select 'CARRO' as id_tipo_articulo, 'Carro' as descripcion union
    select 'CASA', 'Casa' union
    select 'ELECTRONICO', 'Dispositivo Electrónico' union
    select 'LINEA_BLANCA', 'Línea Blanca' union
    select 'MUEBLE', 'Mueble' union
    select 'OTRO', 'Otro'
) as ta
    left join tipo_articulo as x
        on x.id_tipo_articulo = ta.id_tipo_articulo
where x.id_tipo_articulo is null
;
