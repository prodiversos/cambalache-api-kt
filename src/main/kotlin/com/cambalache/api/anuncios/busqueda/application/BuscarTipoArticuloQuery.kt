package com.cambalache.api.anuncios.busqueda.application

import io.micronaut.core.annotation.Introspected
import io.swagger.v3.oas.annotations.media.Schema

@Introspected
@Schema(name = "Búsqueda de tipos de artículos", description = "Criterio para buscar tipos de artículos.")
data class BuscarTipoArticuloQuery(
    @Schema(description = "Texto para buscar en la descripción de los tipos de artículos") val descripcion: String?
)
