package com.cambalache.api.anuncios.busqueda.infrastructure

import com.cambalache.api.ApplicationException
import com.cambalache.api.ApplicationResponse
import com.cambalache.api.anuncios.busqueda.application.BuscarTipoArticuloQuery
import com.cambalache.api.anuncios.busqueda.application.BuscarTipoArticuloQueryHandler
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

@Controller("tipo-articulo")
class TipoArticuloController(private val buscarTipoArticuloQueryHandler: BuscarTipoArticuloQueryHandler) {
    @Get
    fun getLike(@QueryValue descripcion: String?): HttpResponse<Any> {
        try {
            val query = BuscarTipoArticuloQuery(descripcion)
            val result = buscarTipoArticuloQueryHandler.handle(query)
            return HttpResponse.ok(ApplicationResponse.Ok(result))
        } catch (exception: ApplicationException) {
            return HttpResponse.serverError(ApplicationResponse.Error(exception.toApplicationError()))
        }
    }
}