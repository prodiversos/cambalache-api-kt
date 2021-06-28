package com.cambalache.api

import io.micronaut.runtime.Micronaut.*
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License

@OpenAPIDefinition(
    info = Info(
        title = "Cambalache API",
        version = "\${api.version}",
        description = "\${openapi.description}",
        license = License(name = "Apache 2.0", url = "https://foo.bar"),
        contact = Contact(url = "https://ti.prodiversos.com", name = "Adrián Avilés", email = "adrian.aviles@prodiversos.com")
    )
)
object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        build()
            .args(*args)
            .packages("com.cambalache.api")
            .start()
    }
}