package com.cambalache.api

import com.cambalache.api.contacto.domain.MensajeContactoInvalidoException
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
@Produces
@Requires(classes = [ApplicationException::class, ExceptionHandler::class])
class ApplicationExceptionHandler : ExceptionHandler<ApplicationException, HttpResponse<Any>> {
    private val logger = LoggerFactory.getLogger(ApplicationExceptionHandler::class.java)

    override fun handle(request: HttpRequest<*>?, exception: ApplicationException): HttpResponse<Any> {
        val applicationError = ApplicationResponse.Error(exception.toApplicationError())

        // TODO: Configurar appenders para almacenar logs en base de datos y archivos que roten por fecha
        logger.error("Error de aplicación (${exception.errorCode}): ${exception.message ?: exception.javaClass.simpleName}", exception)

        return if (exception.javaClass.isAssignableFrom(MensajeContactoInvalidoException::class.java)) HttpResponse.badRequest(applicationError) else HttpResponse.serverError(applicationError)
    }
}