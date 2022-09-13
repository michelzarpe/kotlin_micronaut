package com.michelzarpelon.curso.model

import java.math.BigDecimal

@NoArgs
data class Parcela(
    var valor: BigDecimal,
    var dataVencimento: String
)
