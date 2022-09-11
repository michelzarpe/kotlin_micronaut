package com.michelzarpelon.curso.dto.input

import java.io.Serializable
import java.math.BigDecimal

data class VendaRquest(
    val cliente: String,
    val veiculo: Long,
    val valor: BigDecimal,
    val quantidadeParcelos: Int
): Serializable {

    companion object{
        private const val serialVersionUID: Long = 1L
    }

}