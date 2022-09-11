package com.michelzarpelon.curso.http.fallback

import com.fasterxml.jackson.databind.ObjectMapper
import com.michelzarpelon.curso.dto.output.VeiculoResponse
import com.michelzarpelon.curso.http.VeiculoHttp
import io.micronaut.retry.annotation.Fallback
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

@Fallback
class VeiculoHttpFallBack(
    private val objectMapper: ObjectMapper
): VeiculoHttp {

    override fun getById(id: Long): VeiculoResponse {

        val jedisPool = JedisPool(JedisPoolConfig(), "127.0.0.1", 6379)

        val jedis = jedisPool.resource

        val veiculoJSON = jedis.get(id.toString())

        val veiculo = objectMapper.readValue(veiculoJSON, VeiculoResponse::class.java)

        return veiculo
    }
}