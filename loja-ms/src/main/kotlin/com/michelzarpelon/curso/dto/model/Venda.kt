package com.michelzarpelon.curso.dto.model

import com.michelzarpelon.curso.dto.output.VeiculoResponse
import java.io.Serializable
import java.math.BigDecimal

class Venda(
    val cliente: String,
    val veiculo: VeiculoResponse,
    val valor: BigDecimal,
    val parcelas: List<Parcela>
): Serializable {

    companion object{
        private const val serialVersionUID: Long = 1L
    }

}