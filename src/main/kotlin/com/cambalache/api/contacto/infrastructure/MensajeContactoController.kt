package com.cambalache.api.contacto.infrastructure

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated

@Validated
@Controller("mensaje-contacto")
class MensajeContactoController {
    @Post
    fun create() {

    }
}