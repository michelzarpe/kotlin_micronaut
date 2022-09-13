package com.michelzarpelon.curso.service

import com.michelzarpelon.curso.model.Venda
import jakarta.inject.Singleton
import com.michelzarpelon.curso.repository.VendaRepository

@Singleton
class VendaService(private val vendaRepository: VendaRepository) {

    fun create(venda: Venda){
        vendaRepository.create(venda)
    }

    fun getAll() = vendaRepository.getAll()

}