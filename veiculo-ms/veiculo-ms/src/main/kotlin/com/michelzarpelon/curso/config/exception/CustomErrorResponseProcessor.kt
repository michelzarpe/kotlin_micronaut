package com.michelzarpelon.curso.config.exception

import io.micronaut.context.annotation.Replaces
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.server.exceptions.response.ErrorContext
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor
import io.micronaut.http.server.exceptions.response.HateoasErrorResponseProcessor
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
@Replaces(HateoasErrorResponseProcessor::class)
class CustomErrorResponseProcessor : ErrorResponseProcessor<StandardError> {

    companion object {
        private val LOG = LoggerFactory.getLogger(CustomErrorResponseProcessor::class.java)
    }

    override fun processResponse(
        errorContext: ErrorContext,
        baseResponse: MutableHttpResponse<*>
    ): MutableHttpResponse<StandardError> {

        val errors = errorContext.errors.joinToString { it.message }

        val rootCause: Throwable? = if (errorContext.rootCause.isPresent) errorContext.rootCause.get() else null

        LOG.error("CustomErrorResponseProcessor rootCause: [$rootCause], errorContext: [$errorContext], baseResponse: [${baseResponse}]")

        return if (baseResponse.code() in 400..499) {

            HttpResponse.serverError(StandardError("bad_request", errors))
                .contentType(MediaType.APPLICATION_JSON_TYPE)
                .status(baseResponse.status)

        } else {

            val internalServerError = StandardError("internal_error", "Internal server error.")

            HttpResponse.serverError(internalServerError)
                .contentType(MediaType.APPLICATION_JSON_TYPE)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)

        }

    }


}