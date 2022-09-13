package com.michelzarpelon.curso.model

import java.math.BigDecimal

@NoArgs
data class Venda(
    var cliente: String,
    var veiculo: Veiculo,
    var valor: BigDecimal,
    var parcelas: List<Parcela>
)