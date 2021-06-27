package com.cambalache.api

import com.cambalache.api.contacto.domain.MensajeContactoInvalidoException
import com.google.common.base.CaseFormat

open class ApplicationException : RuntimeException {
    constructor() : super()
    constructor(message: String?) : super(message)

    open val details: List<String>
        get() = emptyList()

    open val errorCode: String
        get() {
            var code = MensajeContactoInvalidoException::class.simpleName ?: "UNKNOWN";
            val lastExceptionIndex = code.lastIndexOf("Exception")
            if (lastExceptionIndex >= 0) {
                code = code.substring(0, lastExceptionIndex)
            }

            return CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, code)
        }

    fun toApplicationError() = ApplicationResponseError(
        code = errorCode,
        message = message,
        details = details,
        stackTrace = stackTrace
    )
}