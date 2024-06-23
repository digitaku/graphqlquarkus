package com.atilas.exeption.handler;

import com.atilas.exeption.ApplicationException;
import com.atilas.util.MessageService;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.logging.Level;
import java.util.logging.Logger;

@Provider
public class ApplicationExceptionHandler implements ExceptionMapper<ApplicationException> {
    private static final Logger LOG = Logger.getLogger(ApplicationExceptionHandler.class.getName());

    @Override
    public Response toResponse(ApplicationException e) {
        LOG.log(Level.INFO, "Erro tratado ao executar ".concat(e.getStackTrace()[0].getMethodName()), e);
        return Response.status(e.getStatusCode())
                .entity(MessageService.builder()
                        .statusCode(e.getStatusCode())
                        .message(e.getMessage())
                        .errors(e.getErrorList())
                ).build();
    }
}
