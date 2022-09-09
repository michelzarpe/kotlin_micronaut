package com.michelzarpelon.curso.service

import com.michelzarpelon.curso.model.Veiculo
import com.michelzarpelon.curso.repository.VeiculoRepository
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class VeiculoService(
    private val veiculoRepository: VeiculoRepository
) {

    companion object {
        private val LOG = LoggerFactory.getLogger(Veiculo::class.java)
    }

    fun create(veiculo: Veiculo): Veiculo {
        LOG.info("Salvando veiculo $veiculo")
        return veiculoRepository.save(veiculo)
    }

    fun findById(id: Long): Veiculo {
        LOG.info("Procurando veiculo com id $id")
        return veiculoRepository.findById(id).orElseThrow{ RuntimeException()}
    }

}