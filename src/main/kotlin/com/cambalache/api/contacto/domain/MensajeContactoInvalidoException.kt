package com.cambalache.api.contacto.domain

import com.cambalache.api.ApplicationException

class MensajeContactoInvalidoException(
    private val errores: List<String>
) : ApplicationException("Mensaje de contacto no válido") {
    override val details: List<String> get() = errores
}