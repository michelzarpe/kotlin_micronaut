package com.michelzarpelon.curso.dto.model

import java.io.Serializable
import java.math.BigDecimal

class Parcela(
    val valor: BigDecimal,
    var dataVencimento: String
): Serializable {

    companion object{
        private const val serialVersionUID: Long = 1L
    }

}