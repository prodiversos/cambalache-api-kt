package com.cambalache.api.contacto.application

import com.cambalache.api.contacto.domain.SituacionMensajeContacto
import io.micronaut.core.annotation.Introspected
import io.swagger.v3.oas.annotations.media.Schema

@Introspected
@Schema(name = "Envío de un Mensaje de Contacto", description = "Datos requeridos para enviar un mensaje de contacto a su destino.")
data class EnviarMensajeContactoCommand(
    @Schema(description = "Situación de los mensajes de contacto que se desean enviar.") val situacion: SituacionMensajeContacto
)