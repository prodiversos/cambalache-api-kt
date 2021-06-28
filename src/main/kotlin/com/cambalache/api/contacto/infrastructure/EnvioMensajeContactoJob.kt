package com.cambalache.api.contacto.infrastructure

import com.cambalache.api.contacto.application.EnviarMensajeContactoCommand
import com.cambalache.api.contacto.application.EnviarMensajeContactoCommandHandler
import com.cambalache.api.contacto.domain.SituacionMensajeContacto
import io.micronaut.scheduling.annotation.Scheduled
import org.slf4j.LoggerFactory
import javax.inject.Singleton

/***
 * Los mensajes de contacto se registran en la base de datos
 * cuando el usuario llena el formulario en pantalla
 * pero el correo correspondiente se envía al buzón configurado
 * en una tarea independiente a intervalos configurables
 */
@Singleton
class EnvioMensajeContactoJob(
    private val enviarMensajeContactoCommandHandler: EnviarMensajeContactoCommandHandler
) {
    @Scheduled(fixedDelay = "\${application.rh.mail.delay}")
    fun execute() {
        try {
            enviarMensajeContactoCommandHandler.handle(EnviarMensajeContactoCommand(SituacionMensajeContacto.REGISTRADO))
        } catch (exception: Exception) {
            // TODO: Configurar appenders para almacenar logs en base de datos y archivos que roten por fecha
            val logger = LoggerFactory.getLogger(EnvioMensajeContactoJob::class.java)
            logger.error("Error al enviar correo con mensaje de contacto ${exception.message ?: exception.javaClass.simpleName}", exception)
        }
    }
}