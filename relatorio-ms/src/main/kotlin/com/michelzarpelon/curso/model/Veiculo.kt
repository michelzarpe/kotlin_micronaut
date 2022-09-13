package com.michelzarpelon.curso.model

@NoArgs
data class Veiculo(
    var id: Long,
    var marca: String,
    var modelo: String,
    var placa: String
)
