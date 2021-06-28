package com.cambalache.api.anuncios.busqueda.application

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class BuscarAnuncioQueryResult(
    val idAnuncio: Int,
    val titulo: String,
    val idTipoArticulo: String,
    val descripcionTipoArticulo: String,
    val precio: Double,
    val imagen: String?,
    val fechaPublicacion: Date,
    val nombreAnunciante: String,
    val correoAnunciante: String,
    val telefonoAnunciante: String?
)
