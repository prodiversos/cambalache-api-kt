package com.cambalache.api.contacto.application

import io.micronaut.core.annotation.Introspected

@Introspected
data class CrearMensajeContactoCommand(
    val nombre: String,
    val correo: String,
    val comentario: String
)
