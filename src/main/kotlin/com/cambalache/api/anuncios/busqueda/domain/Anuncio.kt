package com.cambalache.api.anuncios.busqueda.domain

import java.util.*
import javax.persistence.*

@Entity
data class Anuncio(
    @Id @GeneratedValue @Column val idAnuncio: Int,
    @Column val titulo: String,

    @JoinColumn(name = "id_tipo_articulo")
    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val tipoArticulo: TipoArticulo,

    @Column val precio: Double,
    @Column val imagen: String,
    @Column val fechaPublicacion: Date,

    @Column val nombreAnunciante: String,
    @Column val correoAnunciante: String,
    @Column val telefonoAnunciante: String
)