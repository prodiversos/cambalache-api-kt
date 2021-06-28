package com.cambalache.api.anuncios.busqueda.infrastructure

import com.cambalache.api.ApplicationResponse
import com.cambalache.api.anuncios.busqueda.application.BuscarTipoArticuloQuery
import com.cambalache.api.anuncios.busqueda.application.BuscarTipoArticuloQueryHandler
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

@Controller("tipo-articulo")
class TipoArticuloController(private val buscarTipoArticuloQueryHandler: BuscarTipoArticuloQueryHandler) {
    @Get
    @Operation(summary = "Busca tipos de artículos", description = "Busca tipos de artículos filtrando opcionalmente por descripción.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Consulta ejecutada con éxito devolviendo cero o más resultados.")
    )
    fun getLike(@QueryValue descripcion: String?): HttpResponse<Any> {
        val query = BuscarTipoArticuloQuery(descripcion)
        val result = buscarTipoArticuloQueryHandler.handle(query)

        return HttpResponse.ok(ApplicationResponse.Ok(result))
    }
}