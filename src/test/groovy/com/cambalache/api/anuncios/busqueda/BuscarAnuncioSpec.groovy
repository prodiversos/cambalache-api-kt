package com.cambalache.api.anuncios.busqueda

import com.cambalache.api.anuncios.busqueda.application.BuscarAnuncioQuery
import com.cambalache.api.anuncios.busqueda.application.BuscarAnuncioQueryHandler
import com.cambalache.api.anuncios.busqueda.domain.AnuncioRepository
import io.micronaut.context.ApplicationContext
import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Sort
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class BuscarAnuncioSpec extends Specification {
    @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    void "obtiene anuncios paginados"() {
        given: 'Consulta filtrada por título, tipo de artículo y rango de precios, limitada a la página 1 con 10 resultados'
        def pageOffset = 0
        def pageSize = 10
        def query = new BuscarAnuncioQuery(
                "%automático%",
                "CARRO",
                15_000,
                150_000,
                Pageable.from(pageOffset, pageSize)
        )

        and: 'Se cuenta con un repositorio de datos de anuncios publicados'
        def repository = embeddedServer.applicationContext.getBean(AnuncioRepository)
        def queryHandler = new BuscarAnuncioQueryHandler(repository)

        when: 'Se buscan anuncios'
        def results = queryHandler.handle(query)

        then: 'Se encuentran anuncios de acuerdo al filtro'
        results.size() > 0
    }
}

