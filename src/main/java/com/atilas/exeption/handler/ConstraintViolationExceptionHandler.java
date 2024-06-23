package com.atilas.exeption.handler;

import com.atilas.util.MessageService;
import com.atilas.util.MessageServiceError;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.hibernate.validator.internal.engine.path.PathImpl;

import java.util.List;
import java.util.logging.Logger;

@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        List<MessageServiceError> errors = e.getConstraintViolations().stream().map(error ->
                MessageServiceError.builder()
                        .message(error.getMessage())
                        .field(((PathImpl)error.getPropertyPath())
                                .getLeafNode().getName())
                        .build()).toList();
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(MessageService.builder()
                        .statusCode(Response.Status.BAD_REQUEST.getStatusCode())
                        .message("violation constraint")
                        .errors(errors)
                        .build()).build();
    }
}
