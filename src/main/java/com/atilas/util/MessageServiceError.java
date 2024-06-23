package com.atilas.util;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageServiceError {
    private String message;
    private String field;
}