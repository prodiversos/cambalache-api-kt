package com.cambalache.api.anuncios.busqueda.domain

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface TipoArticuloRepository : CrudRepository<TipoArticulo, String> {
    @Query("select ta from TipoArticulo as ta where ta.descripcion like :descripcion or :descripcion is null")
    fun findLike(descripcion: String?): List<TipoArticulo>
}