package com.michelzarpelon.curso.http

import com.michelzarpelon.curso.dto.output.VeiculoResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker

@Client(id = "http://localhost:8080")
@CircuitBreaker
interface VeiculoHttp {

    @Get(produces = [MediaType.APPLICATION_JSON], value = "/veiculos/{id}")
    fun getById(@PathVariable id: Long): VeiculoResponse

}