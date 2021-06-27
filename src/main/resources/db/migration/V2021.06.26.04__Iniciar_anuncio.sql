insert into anuncio
(id_tipo_articulo, titulo, precio, imagen, fecha_publicacion, nombre_anunciante, correo_anunciante, telefono_anunciante)
select
    a.id_tipo_articulo, a.titulo, a.precio, a.imagen, a.fecha_publicacion::timestamp with time zone, a.nombre_anunciante, a.correo_anunciante, a.telefono_anunciante
from (
    -- 1
    select 'ELECTRONICO' as id_tipo_articulo,
            'Tablet Samsung Galaxy Tab S2 con funda' as titulo,
            6500 as precio,
            null as imagen,
            '2021-02-22 22:22:22' as fecha_publicacion,
            'Juan Pérez' as nombre_anunciante,
            'juanitoperez88@hotmail.com' as correo_anunciante,
            '(612) 111 22 33' as telefono_anunciante
    union
    -- 2
    select 'CARRO',
           'Nissan Versa 2019 negro transmisión manual',
           130000,
           null,
           '2021-02-28 22:22:22',
           'Ana Medina',
           'anitalavalatina@gmail.com',
           '(612) 444 55 66'
    union
    -- 3
    select 'OTRO',
           'Botella térmica metálica 1.2 litros',
           165,
           null,
           '2021-03-04 12:54:29',
           'Oscar Soto',
           'oscarinsoto22@gmail.com',
           '(55) 777 88 99'
    union
    -- 4
    select 'CARRO',
           'Volkswagen Vento 2018 blanco automático',
           110000,
           null,
           '2021-03-11 15:32:16',
           'Patricia Ramírez',
           'patyram87@gmail.com',
           '(624) 999 11 22'
     union
     -- 5
     select 'ELECTRONICO',
            'Smart TV LG 32 pulgadas',
            4300,
            null,
            '2021-05-04 09:16:45',
            'Braulio Ortega',
            'bortega2233@gmail.com',
            '(613) 888 99 11'
     union
     -- 6
     select 'CASA',
            'Hermosa casa de 2 pisos, 3 recamaras y 2 baños en excelente ubicación',
            750000,
            null,
            '2021-05-06 11:22:21',
            'Andrés Amador',
            'andy8199@gmail.com',
            '(612) 222 33 44'
    union
    -- 7
    select 'MUEBLE',
           'Sofá cama matrimonial en excelentes condiciones',
           2500,
           null,
           '2021-05-08 16:11:59',
           'Luis Flores',
           'luisflores77@hotmail.com',
           null
    union
    -- 8
    select 'OTRO',
           'Reloj de pared caratula blanca',
           140,
           null,
           '2021-05-26 14:09:57',
           'Maria Andrade',
           'mariaandrade66@live.com',
           '(55) 777 88 99'
    union
    -- 9
    select 'OTRO',
           'Guitarra electroacústica negra',
           2800,
           null,
           '2021-05-28 17:14:53',
           'Pablo Olmedo',
           'pablitolm@gmail.com',
           null
     union
     -- 10
     select 'MUEBLE',
            'Litera individual chocolate',
            7500,
            null,
            '2021-06-01 18:56:13',
            'Mónica Duarte',
            'moniduarte79@hotmail.com',
            '(55) 123 45 67'
     union
     -- 11
     select 'LINEA_BLANCA',
            'Lavadora Whirlpool 20 kg blanca',
            5200,
            null,
            '2021-06-02 12:19:17',
            'Andrea Talamantes',
            'andytalamantes@live.com',
            null
     union
     -- 12
     select 'OTRO',
            'Carro de juguete rojo con poco uso en excelentes condiciones',
            1200,
            null,
            '2021-06-06 13:11:22',
            'Arturo González',
            'arturogon56@yahoo.com.mx',
            '(612) 987 65 43'
    union
    -- 13
    select 'LINEA_BLANCA',
           'Refrigerador Daewoo Gris de 11 pies con pequeños detalles superficiales',
           7000,
           null,
           '2021-06-07 14:00:00',
           'Karla Robles',
           'karlitar58@gmail.com',
           null
    union
    -- 14
    select 'OTRO',
           'Maleta Samsonite negra individual 28 pulgadas',
           1600,
           null,
           '2021-06-09 16:20:00',
           'Martín Agúndez',
           'magun87@hotmail.com',
           null
    union
    -- 15
    select 'ELECTRONICO',
           'Laptop HP 15 pulgadas, Intel Core i3, 4GB ram, 250GB disco duro',
           3800,
           null,
           '2021-06-22 19:35:00',
           'Fernanda Ortega',
           'ferortega76@gmail.com',
           '(613) 132 44 99'
) as a
    left join anuncio as x
        on x.id_tipo_articulo = a.id_tipo_articulo and
           x.titulo = a.titulo
where x.id_anuncio is null
order by a.fecha_publicacion
;