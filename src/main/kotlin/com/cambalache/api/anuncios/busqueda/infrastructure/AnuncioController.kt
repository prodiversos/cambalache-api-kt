package com.cambalache.api.anuncios.busqueda.infrastructure

import com.cambalache.api.anuncios.busqueda.application.BuscarAnuncioQuery
import com.cambalache.api.anuncios.busqueda.application.BuscarAnuncioQueryHandler
import com.cambalache.api.anuncios.busqueda.application.BuscarAnuncioQueryResult
import io.micronaut.context.annotation.Value
import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Sort
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
    ): List<BuscarAnuncioQueryResult> {
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
        return buscarAnuncioQueryHandler.handle(query)
    }
}