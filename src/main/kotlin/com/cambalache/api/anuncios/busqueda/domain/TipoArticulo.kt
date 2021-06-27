package com.cambalache.api.anuncios.busqueda.domain

import javax.persistence.*

@Entity
data class TipoArticulo(
    @Id @Column(name = "id_tipo_articulo") var idTipoArticulo: String,
    @Column(name = "descripcion") var descripcion: String,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true) var anuncioList: List<Anuncio>
)
