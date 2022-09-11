package com.michelzarpelon.curso.dto.output

import java.io.Serializable

data class VeiculoResponse(
    var id: Long,
    var modelo: String,
    var marcar: String,
    var placa: String
): Serializable {

    companion object{
        private const val serialVersionUID: Long = 1L
    }

    override fun toString(): String {
        return "Veiculo(id=$id, modelo='$modelo', marcar='$marcar', placa='$placa')"
    }
}
