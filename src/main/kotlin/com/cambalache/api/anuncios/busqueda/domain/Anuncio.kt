package com.cambalache.api.anuncios.busqueda.domain

import java.util.*
import javax.persistence.*

@Entity
data class Anuncio(
    @Id @GeneratedValue @Column var idAnuncio: Int,
    @Column var titulo: String,

    @JoinColumn(name = "id_tipo_articulo")
    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var tipoArticulo: TipoArticulo,

    @Column var precio: Double,
    @Column var imagen: String?,
    @Column var fechaPublicacion: Date,

    @Column var nombreAnunciante: String,
    @Column var correoAnunciante: String,
    @Column var telefonoAnunciante: String
)