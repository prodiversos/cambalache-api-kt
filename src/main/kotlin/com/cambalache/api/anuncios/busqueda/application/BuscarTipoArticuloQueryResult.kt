package com.cambalache.api.anuncios.busqueda.application

import io.micronaut.core.annotation.Introspected

@Introspected
data class BuscarTipoArticuloQueryResult(
    val idTipoArticulo: String,
    val descripcion: String
)
