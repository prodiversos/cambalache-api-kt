package com.cambalache.api

import io.micronaut.core.annotation.Introspected

@Introspected
open class ApplicationResponseError(
    val code: String,
    val message: String?,
    val details: List<String> = emptyList(),
    val stackTrace: Array<StackTraceElement> = emptyArray()
)
