package com.cambalache.api.contacto.application

import com.cambalache.api.contacto.domain.MensajeContactoRepository
import javax.inject.Singleton
import javax.transaction.Transactional

/**
 * Valida y registra la intención del usuario de enviar
 * un comentario a los administradores de Recursos Humanos
 */
@Singleton
open class CrearMensajeContactoCommandHandler(private val mensajeContactoRepository: MensajeContactoRepository) {
    /**
     * Registra un nuevo mensaje de contacto que será enviado posteriormente
     * en una tarea programada al buzón de recursos humanos configurado
     */
    @Transactional
    open fun handle(crearMensajeContactoCommand: CrearMensajeContactoCommand): CrearMensajeContactoCommandResult {
        // Convertir el comando en un mensaje de contacto
        val mensajeContacto = crearMensajeContactoCommand.toMensajeContacto()

        // Registrar el mensaje de contacto en la base de datos
        val idMensajeContacto = mensajeContactoRepository.create(
            mensajeContacto.nombre,
            mensajeContacto.correo,
            mensajeContacto.comentario,
            mensajeContacto.situacion.name,
            mensajeContacto.fechaRegistro
        )

        // Devolver el identificador generado para el mensaje de contacto registrado
        return CrearMensajeContactoCommandResult(idMensajeContacto)
    }
}