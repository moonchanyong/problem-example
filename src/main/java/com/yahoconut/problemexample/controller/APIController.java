package com.yahoconut.problemexample.controller;

import com.yahoconut.problemexample.exception.RandomException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Random;

@RestController
public class APIController {

    @GetMapping("/")
    public String greeting(@RequestParam String greeting) {
        if (new Random().nextBoolean()) {
            throw new RandomException();
        }else if (greeting.isBlank()) {
            throw new IllegalArgumentException("EMPTY_STRING");
        } else if (greeting.length() > 5) {
            final ProblemDetail problemDetail = ProblemDetail.forStatus(404);
            problemDetail.setTitle("Maximum request length exceeded");
            problemDetail.setType(URI.create("/some-specification-document"));
            problemDetail.setInstance(URI.create("/specific-document"));
            problemDetail.setDetail("5글자 이상은 에러를 내기위해 금지");

            throw new ErrorResponseException(HttpStatusCode.valueOf(404), problemDetail, null);
        }

        return greeting;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail badRequestHandler(HttpServletRequest req, Exception ex) {
       return switch (ex.getMessage()) {
           case "EMPTY_STRING" -> ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), "greeting is empty.");

           default -> ProblemDetail.forStatus(404);
       };
    }
}
