package com.cambalache.api.contacto

import com.cambalache.api.contacto.application.CrearMensajeContactoCommand
import com.cambalache.api.contacto.application.CrearMensajeContactoCommandHandler
import com.cambalache.api.contacto.domain.MensajeContactoInvalidoException
import com.cambalache.api.contacto.domain.MensajeContactoRepository
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.lang.Unroll

@MicronautTest
class EnviarComentarioContactoSpec extends Specification {
    @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Unroll
    void "crea mensaje contacto"() {
        given: 'Se desea contactar con los administradores de Recursos Humanos'
        def command = new CrearMensajeContactoCommand(
                "Juan López",
                "juanitolopez78@gmail.com",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
        )

        and: 'Se cuenta con un repositorio de mensajes de contacto'
        def repository = embeddedServer.applicationContext.getBean(MensajeContactoRepository)

        when: 'Se intenta registrar un nuevo mensaje'
        def commandHandler = new CrearMensajeContactoCommandHandler(repository)
        def commandResult = commandHandler.handle(command)

        then: 'El mensaje de contacto se registra con éxito y se obtiene su identificador'
        notThrown(MensajeContactoInvalidoException)
        commandResult.idMensajeContacto > 0
    }
}

