package com.michelzarpelon.curso.service

import com.michelzarpelon.curso.config.exception.ObjectNotFoundException
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

        //tratamento de exception só para testar no micronaut
        //Feito dois tipos de tratamento: Custom para tudo que não tiver handller de 400 a 499

        return try {

            veiculoRepository
                .findById(id)
                .orElseThrow { ObjectNotFoundException("Objecto não encontrado") }

        } catch (e: Exception) {

            LOG.error("Tratei com uma exception generica,  veiculo com id $id")

            throw ObjectNotFoundException("Objecto não encontrado")
        }
    }

    fun findAll() = veiculoRepository.findAll()
}