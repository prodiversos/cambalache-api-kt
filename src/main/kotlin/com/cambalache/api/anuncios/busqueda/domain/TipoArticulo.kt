package com.cambalache.api.anuncios.busqueda.domain

import javax.persistence.*

@Entity
data class TipoArticulo(
    @Id @Column(name = "id_tipo_articulo") val idTipoArticulo: String,
    @Column(name = "descripcion") val descripcion: String,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true) val anuncioList: List<Anuncio>
)
