package com.cambalache.api.anuncios.busqueda.application

import com.cambalache.api.anuncios.busqueda.domain.AnuncioRepository
import io.micronaut.data.model.Pageable
import javax.inject.Inject

class BuscarAnuncioQueryHandler @Inject constructor(private val anuncioRepository: AnuncioRepository) {
    fun handle(buscarAnuncioQuery: BuscarAnuncioQuery): List<BuscarAnuncioQueryResult> {
        val (titulo, idTipoArticulo, precioMinimo, precioMaximo, pageable) = buscarAnuncioQuery
        return anuncioRepository
            .findLike(titulo, idTipoArticulo, precioMinimo, precioMaximo, pageable ?: Pageable.unpaged())
            .map { anuncio ->
                BuscarAnuncioQueryResult(
                    anuncio.idAnuncio,
                    anuncio.titulo,
                    anuncio.tipoArticulo.idTipoArticulo,
                    anuncio.tipoArticulo.descripcion,
                    anuncio.precio,
                    anuncio.imagen,
                    anuncio.fechaPublicacion,
                    anuncio.nombreAnunciante,
                    anuncio.correoAnunciante,
                    anuncio.telefonoAnunciante
                )
            }
    }
}