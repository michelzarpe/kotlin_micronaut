package com.michelzarpelon.curso.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.michelzarpelon.curso.model.Venda
import com.michelzarpelon.curso.service.VendaService
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class VendaConsumer (
    private val objectMapper: ObjectMapper,
    private val vendaService: VendaService
    ) {

    @Topic("ms-vendas")
    fun receberVenda(id: String, vendaJSON: String){
        val venda = objectMapper.readValue(vendaJSON, Venda::class.java)
        vendaService.create(venda)
    }
}
