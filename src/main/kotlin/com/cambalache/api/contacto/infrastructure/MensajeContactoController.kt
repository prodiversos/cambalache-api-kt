package com.cambalache.api.contacto.infrastructure

import com.cambalache.api.ApplicationResponse
import com.cambalache.api.contacto.application.CrearMensajeContactoCommand
import com.cambalache.api.contacto.application.CrearMensajeContactoCommandHandler
import com.cambalache.api.contacto.application.CrearMensajeContactoCommandResult
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import javax.validation.Valid

@Validated
@Controller("mensaje-contacto")
class MensajeContactoController(
    private val crearMensajeContactoCommandHandler: CrearMensajeContactoCommandHandler
) {
    @Post
    @Operation(summary = "Crea un mensaje de contacto", description = "Registra un nuevo mensaje de contacto que será enviado al buzón de correo configurado.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Consulta ejecutada con éxito devolviendo el identificador del nuevo mensaje."),
        ApiResponse(responseCode = "400", description = "La petición contiene datos no válidos.")
    )
    fun create(@Valid crearMensajeContactoCommand: CrearMensajeContactoCommand): HttpResponse<ApplicationResponse<CrearMensajeContactoCommandResult>> {
        val commandResult = crearMensajeContactoCommandHandler.handle(crearMensajeContactoCommand)
        return HttpResponse.ok(ApplicationResponse.Ok(commandResult))
    }

}