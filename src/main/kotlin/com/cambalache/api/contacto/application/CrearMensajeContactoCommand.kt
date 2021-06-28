package com.cambalache.api.contacto.application

import com.cambalache.api.contacto.domain.MensajeContacto
import com.cambalache.api.contacto.domain.MensajeContactoInvalidoException
import io.micronaut.core.annotation.Introspected
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*

/**
 * Representa la intención del usuario de registrar un comentario
 * dirigido a los administradores de Recursos Humanos
 */
@Introspected
@Schema(name = "Creación de un Mensaje de Contacto", description = "Datos requeridos para registrar un nuevo mensaje de contacto.")
class CrearMensajeContactoCommand(
    @Schema(description = "Nombre del empleado") val nombre: String?,
    @Schema(description = "Correo de contacto del empleado") val correo: String?,
    @Schema(description = "Comentario dirigido a Recursos Humanos") val comentario: String?
) {
    private val emailRegex = Regex("""(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])""")
    private val nombreMaxLength = 50
    private val comentarioMaxLength = 100

    /**
     * Valida los campos del mensaje de contacto
     * -     nombre: Requerido con no más de 50 caracteres
     * -     correo: Requerido y con formato de dirección de correo válida
     * - comentario: Requerido con no más de 100 caracteres
     */
    private fun validate() {
        val errores = mutableListOf<String>()

        if (nombre == null) {
            errores.add("El nombre es requerido.")
        } else if (nombre.trim().length > nombreMaxLength) {
            errores.add("El nombre excede los $nombreMaxLength caracteres permitidos.")
        }

        if (correo == null) {
            errores.add("La dirección de correo es requerida.")
        } else if (! (emailRegex matches correo)) {
            errores.add("La dirección de correo no es válida.")
        }

        if (comentario == null) {
            errores.add("El comentario es requerido.")
        } else if (comentario.trim().length > comentarioMaxLength) {
            errores.add("El comentario excede los $comentarioMaxLength caracteres permitidos.")
        }

        if (errores.isNotEmpty()) {
            throw MensajeContactoInvalidoException(errores)
        }
    }

    /**
     * Valida los datos del comando y lo
     * convierte en una entidad del dominio
     */
    fun toMensajeContacto(fechaRegistro: Date = Date()): MensajeContacto {
        validate()

        return MensajeContacto(
            nombre = nombre!!.trim(),
            correo = correo!!.trim(),
            comentario = comentario!!.trim(),
            fechaRegistro = fechaRegistro
        )
    }
}
