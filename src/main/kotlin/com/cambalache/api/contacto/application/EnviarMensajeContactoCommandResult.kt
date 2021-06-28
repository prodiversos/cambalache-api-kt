package com.cambalache.api.contacto.application

import com.cambalache.api.contacto.domain.SituacionMensajeContacto
import io.micronaut.core.annotation.Introspected
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*

@Introspected
@Schema(name = "Resultado de crear mensaje de contacto", description = "Resultado de registrar un nuevo mensaje de contacto")
data class EnviarMensajeContactoCommandResult(
    @Schema(description = "Identificador del mensaje.") val idMensajeContacto: Int,
    @Schema(description = "Situación del mensaje.") val situacion: SituacionMensajeContacto,
    @Schema(description = "Destino del mensaje.") val destino: String,
    @Schema(description = "Fecha de procesamiento del mensaje.") val fechaProcesamiento: Date,
    @Schema(description = "Comentario de procesamiento del mensaje.") val comentarioProcesamiento: String?
)
