package com.michelzarpelon.curso.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.michelzarpelon.curso.dto.output.VeiculoResponse
import com.michelzarpelon.curso.http.VeiculoHttp
import jakarta.inject.Singleton
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

@Singleton
class VeiculoService(
    private val veiculoHttp: VeiculoHttp,
    private val objectMapper: ObjectMapper
) {

    fun getVeiculo(veiculo: Long): VeiculoResponse {

        val veiculoResponse = veiculoHttp.getById(veiculo)

        gravarCache(veiculoResponse)

        return veiculoResponse
    }

    fun gravarCache(veiculoResponse: VeiculoResponse) {

        val jedisPool = JedisPool(JedisPoolConfig(), "127.0.0.1", 6379)

        val jedis = jedisPool.resource

        val veiculoJSON = objectMapper.writeValueAsString(veiculoResponse)

        jedis.set(veiculoResponse.id.toString(), veiculoJSON)
    }


}