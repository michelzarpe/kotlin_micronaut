package com.michelzarpelon.curso.controller

import com.michelzarpelon.curso.model.Veiculo
import com.michelzarpelon.curso.service.VeiculoService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import org.slf4j.LoggerFactory

@Controller("veiculos")
class VeiculoController(
    private val veiculoService: VeiculoService
) {

    companion object {
        private val LOG = LoggerFactory.getLogger(Veiculo::class.java)
    }

    @Get(produces = [MediaType.APPLICATION_JSON], value = "/{id}")
    fun getById(@PathVariable id: Long): String {
        LOG.info("Buscando retorno no service para veiculo: $id")
        veiculoService.findById(id)
        return "OLa"
    }

    @Get(produces = [MediaType.APPLICATION_JSON])
    fun getAll(): String {
        LOG.info("Buscando todos os veiculos")
        veiculoService.findAll()
        return "OLa"
    }


}