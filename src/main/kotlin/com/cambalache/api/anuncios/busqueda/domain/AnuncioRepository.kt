package com.cambalache.api.anuncios.busqueda.domain

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.PageableRepository

@Repository
interface AnuncioRepository : PageableRepository<Anuncio, Int> {
    @Query("select a from Anuncio as a " +
            "join a.tipoArticulo as ta " +
            "where " +
            "  (a.titulo like :titulo or :titulo is null) and " +
            "  (ta.idTipoArticulo = :idTipoArticulo or :idTipoArticulo is null) and " +
            "  (a.precio >= :precioMinimo or :precioMinimo is null) and " +
            "  (a.precio <= :precioMaximo or :precioMaximo is null)"
    )
    fun findLike(
        titulo: String?,
        idTipoArticulo: String?,
        precioMinimo: Double?,
        precioMaximo: Double?,
        pageable: Pageable?
    ): List<Anuncio>
}