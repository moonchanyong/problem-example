package com.yahoconut.problemexample.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponseException;

public class RandomException extends ErrorResponseException {
    public RandomException() {
        super(HttpStatusCode.valueOf(500));
    }
//    public RandomException(HttpStatusCode status) {
//        super(status);
//    }
//
//    public RandomException(HttpStatusCode status, Throwable cause) {
//        super(status, cause);
//    }
//
//    public RandomException(HttpStatusCode status, ProblemDetail body, Throwable cause) {
//        super(status, body, cause);
//    }
//
//    public RandomException(HttpStatusCode status, ProblemDetail body, Throwable cause, String messageDetailCode, Object[] messageDetailArguments) {
//        super(status, body, cause, messageDetailCode, messageDetailArguments);
//    }

//    @Override
//    public HttpStatusCode getStatusCode() {
//        return HttpStatusCode.valueOf(500);
//    }
//
//    @Override
//    public ProblemDetail getBody() {
//        ProblemDetail problemDetail = ProblemDetail.forStatus(500);
//
//        problemDetail.setTitle("random failure.");
//        problemDetail.setDetail("테스트를 위해 랜덤으로 실패한다.");
//
//        return  problemDetail;
//    }
}
