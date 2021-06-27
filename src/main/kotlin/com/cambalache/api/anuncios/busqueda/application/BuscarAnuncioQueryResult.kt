package com.cambalache.api.anuncios.busqueda.application

import java.util.*

data class BuscarAnuncioQueryResult(
    val idAnuncio: Int,
    val titulo: String,
    val idTipoAnuncio: String,
    val descripcionTipoAnuncio: String,
    val precio: Double,
    val imagen: String?,
    val fechaPublicacion: Date,
    val nombreAnunciante: String,
    val correoAnunciante: String,
    val telefonoAnunciante: String?
)
