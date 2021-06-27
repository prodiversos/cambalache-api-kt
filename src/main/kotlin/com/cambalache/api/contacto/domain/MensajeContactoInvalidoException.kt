package com.cambalache.api.contacto.domain

import com.cambalache.api.ApplicationException
import com.cambalache.api.ApplicationResponseError
import java.lang.RuntimeException

class MensajeContactoInvalidoException(
    private val errores: List<String>
) : ApplicationException() {
    override val details: List<String> get() = errores
}