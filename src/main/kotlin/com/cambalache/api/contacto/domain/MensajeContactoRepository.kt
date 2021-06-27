package com.cambalache.api.contacto.domain

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface MensajeContactoRepository : CrudRepository<MensajeContacto, Int> {

    // TODO: Pasar el argumento 'situacion' como enum en lugar de string
    @Query(
        value = "select mensaje_contacto_crear(:nombre, :correo, :comentario, cast(:situacion as situacion_mensaje_contacto), cast(:fechaRegistro as timestamp with time zone))",
        nativeQuery = true
    )
    fun create(nombre: String, correo: String, comentario: String, situacion: String, fechaRegistro: Date): Int

}

