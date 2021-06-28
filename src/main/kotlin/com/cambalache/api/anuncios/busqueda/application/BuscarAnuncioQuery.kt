package com.cambalache.api.anuncios.busqueda.application

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.model.Pageable
import io.swagger.v3.oas.annotations.media.Schema

@Introspected
@Schema(name = "Búsqueda de anuncios", description = "Criterio para buscar anuncios.")
data class BuscarAnuncioQuery(
    @Schema(description = "Texto para buscar en títulos de anuncios") val titulo: String?,
    @Schema(description = "Identificador del tipo de artículo buscado") val idTipoArticulo: String?,
    @Schema(description = "Precio minimo del artículo buscado") val precioMinimo: Double?,
    @Schema(description = "Precio máximo del artículo buscado") val precioMaximo: Double?,
    @Schema(description = "Opciones de paginación y ordenamiento") val pageable: Pageable?
)
