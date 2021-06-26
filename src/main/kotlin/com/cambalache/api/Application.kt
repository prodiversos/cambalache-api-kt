package com.cambalache.api

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
            .args(*args)
            .packages("com.cambalache.api")
            .start()
}

