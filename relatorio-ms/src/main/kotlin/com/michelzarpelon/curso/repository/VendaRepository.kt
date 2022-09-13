package com.michelzarpelon.curso.repository

import com.michelzarpelon.curso.model.Venda
import com.mongodb.client.MongoClient
import com.mongodb.client.result.InsertOneResult
import jakarta.inject.Singleton

@Singleton
class VendaRepository(
    private val mongoClient: MongoClient
) {

    fun create(venda: Venda): InsertOneResult{
        return getConnection().insertOne(venda)
    }

    fun getAll() = getConnection().find().toList()

    fun getConnection() = mongoClient
        .getDatabase("vendas")
        .getCollection("venda",Venda::class.java)


}