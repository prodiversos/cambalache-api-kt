package com.cambalache.api.anuncios.busqueda.application

import io.micronaut.core.annotation.Introspected

@Introspected
data class BuscarTipoArticuloQuery(
    val descripcion: String?
)
