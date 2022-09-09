package com.michelzarpelon.curso.model

import io.micronaut.core.annotation.Introspected
import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
@Entity(name = "veiculo")
data class Veiculo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @field:NotBlank(message = "Inserir modelo")
    @field:NotNull(message = "Inserir modelo")
    var modelo: String,
    @field:NotBlank(message = "Inserir modelo")
    @field:NotNull(message = "Inserir modelo")
    var marcar: String,
    @field:NotBlank(message = "Inserir modelo")
    @field:NotNull(message = "Inserir modelo")
    var placa: String
): Serializable{

    companion object{
        private const val serialVersionUID: Long = 1L
    }

    override fun toString(): String {
        return "Veiculo(id=$id, modelo='$modelo', marcar='$marcar', placa='$placa')"
    }
}
