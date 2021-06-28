package com.cambalache.api.contacto.infrastructure

import com.cambalache.api.ApplicationResponse
import com.cambalache.api.contacto.application.CrearMensajeContactoCommand
import com.cambalache.api.contacto.application.CrearMensajeContactoCommandHandler
import com.cambalache.api.contacto.domain.MensajeContactoInvalidoException
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("mensaje-contacto")
class MensajeContactoController(
    private val crearMensajeContactoCommandHandler: CrearMensajeContactoCommandHandler
) {
    @Post
    fun create(@Valid crearMensajeContactoCommand: CrearMensajeContactoCommand): HttpResponse<Any> {
        try {
            val commandResult = crearMensajeContactoCommandHandler.handle(crearMensajeContactoCommand)
            return HttpResponse.ok(ApplicationResponse.Ok(commandResult))
        } catch (exception: MensajeContactoInvalidoException) {
            return HttpResponse.badRequest(ApplicationResponse.Error(exception.toApplicationError()))
        }
    }

}