package com.michelzarpelon.curso.config.exception

import io.micronaut.context.annotation.Requirements
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Produces
@Singleton
@Requirements(Requires(classes = [ObjectNotFoundException::class]))
class NotFoundExceptionHandler: ExceptionHandler<ObjectNotFoundException, HttpResponse<*>> {

    companion object {
        private val LOG = LoggerFactory.getLogger(NotFoundExceptionHandler::class.java)
    }

    override fun handle(request: HttpRequest<*>?, exception: ObjectNotFoundException?): HttpResponse<StandardError> {

        LOG.error("Error NotFaudExceptionHandler request: [${request}], exception: [${exception}]")

        return HttpResponse.notFound(StandardError("not_found",exception?.message!!))
    }


}