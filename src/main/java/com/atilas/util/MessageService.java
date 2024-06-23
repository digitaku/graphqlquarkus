package com.atilas.util;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageService {

    private Integer statusCode;
    private String message;
    private List<MessageServiceError> errors;
}
