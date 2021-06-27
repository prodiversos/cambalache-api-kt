package com.cambalache.api.contacto.domain

import java.lang.RuntimeException

class MensajeContactoInvalidoException(message: String) : RuntimeException(message)