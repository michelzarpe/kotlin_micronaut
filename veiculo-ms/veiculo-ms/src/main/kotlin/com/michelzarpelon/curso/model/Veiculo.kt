package com.michelzarpelon.curso.model

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity(name = "veiculo")
data class Veiculo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @field:NotBlank
    val modelo: String,
    @field:NotBlank
    val marcar: String,
    @field:NotBlank
    val placa: String
): Serializable{

    companion object{
        private const val serialVersionUID: Long = 1L
    }

    override fun toString(): String {
        return "Veiculo(id=$id, modelo='$modelo', marcar='$marcar', placa='$placa')"
    }
}
