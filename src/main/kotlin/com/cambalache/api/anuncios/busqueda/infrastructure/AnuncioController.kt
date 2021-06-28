package com.cambalache.api.anuncios.busqueda.infrastructure

import com.cambalache.api.ApplicationException
import com.cambalache.api.ApplicationResponse
import com.cambalache.api.anuncios.busqueda.application.BuscarAnuncioQuery
import com.cambalache.api.anuncios.busqueda.application.BuscarAnuncioQueryHandler
import io.micronaut.context.annotation.Value
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.validation.Validated
import javax.inject.Inject

@Validated
@Controller(value = "anuncio")
class AnuncioController @Inject constructor(
    private val buscarAnuncioQueryHandler: BuscarAnuncioQueryHandler,
    @Value("\${application.pagination.pageSize}") private val defaultPageSize: Int
) {
    @Get
    fun getLike(
        @QueryValue titulo: String?,
        @QueryValue idTipoArticulo: String?,
        @QueryValue precioMinimo: Double?,
        @QueryValue precioMaximo: Double?,
        @QueryValue pageOffset: Int?,
        @QueryValue pageSize: Int?,
        @QueryValue sortProperty: String?,
        @QueryValue sortDirection: String?
    ): HttpResponse<Any> {
        try {
            // TODO: Corregir error de ruta no válida en el
            //  nombre de la propiedad al utilizar Sort.of(...)
            //val fechaPublicacionProperty = "fechaPublicacion"
            //val finalSortProperty = sortProperty ?: fechaPublicacionProperty
            //val finalSortDirection = Sort.Order.Direction.valueOf(sortDirection ?: (if (finalSortProperty == fechaPublicacionProperty) "DESC" else "ASC"))

            val query = BuscarAnuncioQuery(
                titulo,
                idTipoArticulo,
                precioMinimo,
                precioMaximo,
                Pageable.from(
                    pageOffset ?: 0,
                    pageSize ?: defaultPageSize //,
                    //Sort.of(Sort.Order(finalSortProperty, finalSortDirection, true))
                )
            )
            val result = buscarAnuncioQueryHandler.handle(query)

            return HttpResponse.ok(ApplicationResponse.Ok(result))
        } catch (exception: ApplicationException) {
            return HttpResponse.serverError(exception)
        }
    }
}