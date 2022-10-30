package com.seatcode.moweraut.exceptions;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ApiException implements Serializable {

    @Serial
    private static final long serialVersionUID = 2087186807998734879L;
    private final HttpStatus status;
    private final String message;

}