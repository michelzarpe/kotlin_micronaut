package com.michelzarpelon.curso.controller

import com.michelzarpelon.curso.dto.input.VendaRquest
import com.michelzarpelon.curso.service.VendaService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/vendas")
class VendaController(
    private val vendaService: VendaService
) {

    @Post
    fun realizarVenda(@Body venda: VendaRquest): HttpResponse<*>{
        return HttpResponse.ok(vendaService.realizarCompra(venda));
    }
}