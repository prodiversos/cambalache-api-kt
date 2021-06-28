package com.cambalache.api.contacto.application

import com.cambalache.api.contacto.domain.MensajeContactoRepository
import com.cambalache.api.contacto.domain.SituacionMensajeContacto
import io.micronaut.context.annotation.Value
import java.util.*
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class EnviarMensajeContactoCommandHandler(
    private val mensajeContactoRepository: MensajeContactoRepository,
    @Value("\${application.rh.mail.recipient}") private val destino: String
) {
    @Transactional
    open fun handle(enviarMensajeContactoCommand: EnviarMensajeContactoCommand): List<EnviarMensajeContactoCommandResult> {
        val resultList = mutableListOf<EnviarMensajeContactoCommandResult>()
        val mensajeList = mensajeContactoRepository.findBySituacion(enviarMensajeContactoCommand.situacion.name)

        mensajeList.forEach { mensaje ->
            mensaje.destino = destino
            mensaje.fechaProcesamiento = Date()

            try {
                // TODO: Enviar correo a destino y actualizar el mensaje

                // mensaje.situacion = SituacionMensajeContacto.ENVIADO
            } catch (exception: Exception) {
                mensaje.situacion = SituacionMensajeContacto.FALLIDO
                mensaje.comentarioProcesamiento = exception.message
            } finally {
                // mensajeContactoRepository.save(mensaje)

                resultList.add(EnviarMensajeContactoCommandResult(
                    idMensajeContacto = mensaje.idMensajeContacto!!,
                    situacion = mensaje.situacion,
                    destino = mensaje.destino!!,
                    fechaProcesamiento = mensaje.fechaProcesamiento!!,
                    comentarioProcesamiento = mensaje.comentarioProcesamiento
                ))
            }
        }

        return resultList
    }
}