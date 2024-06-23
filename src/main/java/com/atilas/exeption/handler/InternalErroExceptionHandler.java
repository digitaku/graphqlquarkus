package com.atilas.exeption.handler;

import com.atilas.util.MessageService;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.logging.Level;
import java.util.logging.Logger;


@Provider
public class InternalErroExceptionHandler implements ExceptionMapper<Exception> {
    private static final Logger LOG = Logger.getLogger(InternalErroExceptionHandler.class.getName());

    @Override
    public Response toResponse(Exception e) {
        LOG.log(Level.SEVERE, "Erro tratado ".concat(e.getStackTrace()[0].getMethodName()), e);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(MessageService.builder()
                        .statusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                        .message("Ocorreu um erro interno. Por favor, tente novamente mais tarde ou entre em contato com o suporte técnico.")
                        .build()
                ).build();
    }
}
