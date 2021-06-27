package com.cambalache.api.contacto.domain

import java.util.*
import javax.persistence.*

@Entity
data class MensajeContacto(
    @Id @GeneratedValue @Column var idMensajeContacto: Int? = null,
    @Column var nombre: String,
    @Column var correo: String,
    @Column var comentario: String,
    @Column @Enumerated(EnumType.STRING) var situacion: SituacionMensajeContacto = SituacionMensajeContacto.REGISTRADO,
    @Column var destino: String? = null,
    @Column var fechaRegistro: Date,
    @Column var fechaProcesamiento: Date? = null,
    @Column var comentarioProcesamiento: String? = null
)
