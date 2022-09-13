package com.michelzarpelon.curso.model

import java.math.BigDecimal

data class Parcela(
    val valor: BigDecimal,
    val dataVencimento: String
)
