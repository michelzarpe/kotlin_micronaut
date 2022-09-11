package com.michelzarpelon.curso.service

import com.michelzarpelon.curso.dto.input.VendaRquest
import com.michelzarpelon.curso.dto.model.Parcela
import com.michelzarpelon.curso.dto.model.Venda
import com.michelzarpelon.curso.http.VeiculoHttp
import java.time.LocalDate

class VendaService(
    private val veiculoService: VeiculoService
) {

    fun realizarCompra(venda: VendaRquest) {
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
    }
}