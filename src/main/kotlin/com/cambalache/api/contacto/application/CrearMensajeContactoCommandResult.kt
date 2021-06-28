package com.cambalache.api.contacto.application

import io.micronaut.core.annotation.Introspected
import io.swagger.v3.oas.annotations.media.Schema

@Introspected
@Schema(name = "Resultado de crear mensaje de contacto", description = "Resultado de registrar un nuevo mensaje de contacto")
data class CrearMensajeContactoCommandResult(
    @Schema(description = "Identificador del nuevo mensaje de contacto.") val idMensajeContacto: Int
)
