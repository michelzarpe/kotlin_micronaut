package com.michelzarpelon.curso.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.michelzarpelon.curso.model.Venda
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class VendaConsumer (
    private val objectMapper: ObjectMapper) {

    @Topic("ms-vendas")
    fun receberVenda(id: String, vendaJSON: String){
        val venda = objectMapper.readValue(vendaJSON, Venda::class.java)
    }
}
