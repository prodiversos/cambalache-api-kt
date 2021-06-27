package com.cambalache.api.anuncios.busqueda.application

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.model.Pageable

@Introspected
data class BuscarAnuncioQuery(
    val titulo: String?,
    val idTipoArticulo: String?,
    val precioMinimo: Double?,
    val precioMaximo: Double?,
    val pageable: Pageable?
)
