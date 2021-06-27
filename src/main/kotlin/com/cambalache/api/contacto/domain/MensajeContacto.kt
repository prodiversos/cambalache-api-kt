package com.cambalache.api.contacto.domain

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class MensajeContacto(
    @Id @GeneratedValue @Column var idMensajeContacto: Int,
    @Column var nombre: String,
    @Column var correo: String,
    @Column var comentario: String,
    @Column var situacion: SituacionMensajeContacto,
    @Column var destino: String?,
    @Column var fechaRegistro: Date,
    @Column var fechaProcesamiento: Date?,
    @Column var comentarioProcesamiento: String?
)
