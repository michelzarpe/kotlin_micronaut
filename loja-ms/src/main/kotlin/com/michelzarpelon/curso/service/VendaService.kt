package com.michelzarpelon.curso.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.michelzarpelon.curso.dto.input.VendaRquest
import com.michelzarpelon.curso.dto.model.Parcela
import com.michelzarpelon.curso.dto.model.Venda
import com.michelzarpelon.curso.http.VeiculoHttp
import com.michelzarpelon.curso.producer.VendaProducer
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

class VendaService(
    private val veiculoService: VeiculoService,
    private val objectMapper: ObjectMapper,
    private val vendaProducer: VendaProducer
) {

    fun realizarCompra(venda: VendaRquest): Venda {
        val veiculo = veiculoService.getVeiculo(venda.veiculo)
        val parcelas: List<Parcela> = ArrayList<Parcela>()
        val valorParcela = venda.valor.divide((venda.quantidadeParcelos.toBigDecimal()))
        var dataVencimento = LocalDate.now().plusMonths(1);

        for (numParcela in 1..venda.quantidadeParcelos) {
            var parcela = Parcela(valorParcela, dataVencimento.toString())
            parcelas.plus(parcela)
            dataVencimento = dataVencimento.plusMonths(1)
        }
        var venda = Venda(
            cliente = venda.cliente,
            veiculo = veiculo,
            venda.valor,
            parcelas = parcelas
        )
        confirmarVenda(venda)
        return venda
    }

    fun confirmarVenda(venda: Venda){
        var vendaJSON = objectMapper.writeValueAsString(venda)
        vendaProducer.publicarVenda(UUID.randomUUID().toString(), vendaJSON)
    }


}