package com.cambalache.api.anuncios.busqueda.application

import io.micronaut.core.annotation.Introspected
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*

@Introspected
@Schema(name = "Anuncio", description = "Título, tipo, precio e imagen de un artículo, así como los datos de su anunciante.")
data class BuscarAnuncioQueryResult(
    @Schema(description = "Identificador del anuncio") val idAnuncio: Int,
    @Schema(description = "Título con detalles del artículo anunciado") val titulo: String,
    @Schema(description = "Identificador del tipo de artículo") val idTipoArticulo: String,
    @Schema(description = "Descripción del tipo de artículo") val descripcionTipoArticulo: String,
    @Schema(description = "Precio del artículo anunciado") val precio: Double,
    @Schema(description = "Imagen del artículo codificada en Base64") val imagen: String?,
    @Schema(description = "Fecha de publicación del anuncio") val fechaPublicacion: Date,
    @Schema(description = "Nombre del anunciante") val nombreAnunciante: String,
    @Schema(description = "Correo de contacto del anunciante") val correoAnunciante: String,
    @Schema(description = "Teléfono de contacto del anunciante") val telefonoAnunciante: String?
)
