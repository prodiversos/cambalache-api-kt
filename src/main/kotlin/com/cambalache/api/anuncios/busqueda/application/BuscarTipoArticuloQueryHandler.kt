package com.cambalache.api.anuncios.busqueda.application

import com.cambalache.api.anuncios.busqueda.domain.TipoArticuloRepository
import javax.inject.Singleton

@Singleton
class BuscarTipoArticuloQueryHandler(private val tipoArticuloRepository: TipoArticuloRepository) {
    fun handle(buscarTipoArticuloQuery: BuscarTipoArticuloQuery): List<BuscarTipoArticuloQueryResult> {
        val (descripcion) = buscarTipoArticuloQuery
        return tipoArticuloRepository
            .findLike(descripcion)
            .map { tipoArticulo ->
                BuscarTipoArticuloQueryResult(
                    idTipoArticulo = tipoArticulo.idTipoArticulo,
                    descripcion = tipoArticulo.descripcion
                )
            }
    }
}