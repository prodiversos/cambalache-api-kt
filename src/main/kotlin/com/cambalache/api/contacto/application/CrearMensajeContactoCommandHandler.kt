package com.cambalache.api.contacto.application

import com.cambalache.api.contacto.domain.MensajeContactoInvalidoException
import com.cambalache.api.contacto.domain.MensajeContactoRepository
import javax.inject.Singleton

@Singleton
class CrearMensajeContactoCommandHandler(private val mensajeContactoRepository: MensajeContactoRepository) {
    fun handle(crearMensajeContactoCommand: CrearMensajeContactoCommand) {
        throw MensajeContactoInvalidoException("Mensaje no válido.")
    }
}