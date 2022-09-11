package com.michelzarpelon.curso.controller

import com.michelzarpelon.curso.model.Veiculo
import com.michelzarpelon.curso.service.VeiculoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Controller("/veiculos")
@Validated
class VeiculoController(
    private val veiculoService: VeiculoService
) {

    companion object {
        private val LOG = LoggerFactory.getLogger(Veiculo::class.java)
    }

    @Get(produces = [MediaType.APPLICATION_JSON], value = "/{id}")
    fun getById(@PathVariable id: Long): Veiculo {

        LOG.info("Buscando retorno no service para veiculo: $id")

        return veiculoService.findById(id)
    }

    @Get(produces = [MediaType.APPLICATION_JSON])
    fun getAll(): MutableList<Veiculo> {

        LOG.info("Buscando todos os veiculos")

        return veiculoService.findAll()
    }

    @Post(produces = [MediaType.APPLICATION_JSON], consumes = [MediaType.APPLICATION_JSON])
    fun create(@Body @Valid veiculo: Veiculo): HttpResponse<Veiculo> {
        return HttpResponse.ok(veiculoService.create(veiculo))
    }


}