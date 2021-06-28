package com.cambalache.api.anuncios.busqueda.application

import io.micronaut.core.annotation.Introspected
import io.swagger.v3.oas.annotations.media.Schema

@Introspected
@Schema(name = "Tipo de Artículo", description = "Identificador y descripción del tipo de artículo.")
data class BuscarTipoArticuloQueryResult(
    @Schema(description = "Identificador del tipo de artículo") val idTipoArticulo: String,
    @Schema(description = "Descripción para mostrar del tipo de artículo") val descripcion: String
)
