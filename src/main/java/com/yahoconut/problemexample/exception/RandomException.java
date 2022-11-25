package com.yahoconut.problemexample.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponseException;

public class RandomException extends ErrorResponseException {
    public RandomException() {
        super(HttpStatusCode.valueOf(500));
    }
}
