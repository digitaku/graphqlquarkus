package com.atilas.exeption;

import com.atilas.util.MessageBundle;
import com.atilas.util.MessageServiceError;
import jakarta.ws.rs.core.Response;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class ApplicationException extends RuntimeException {

    private final Integer statusCode;
    private final List<MessageServiceError> errorList;


    public ApplicationException(String messageKeyLoc, Response.Status status) {
        this(messageKeyLoc, Collections.emptyList(), status);
    }

    public ApplicationException(String messageKeyLoc, List<MessageServiceError> errorList, Response.Status status) {
        this(messageKeyLoc, new String[]{}, null, errorList, status);
    }

    public ApplicationException(String messageKeyLoc, String[] parameters, Throwable cause, List<MessageServiceError> errorList, Response.Status status) {
        super(MessageBundle.getMessage(messageKeyLoc, parameters), cause);
        this.statusCode = status.getStatusCode();
        this.errorList = errorList;
    }
}
