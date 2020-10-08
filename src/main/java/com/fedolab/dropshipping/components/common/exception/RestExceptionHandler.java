package com.fedolab.dropshipping.components.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected <T extends ResponseDefault, E extends CustomException> ResponseEntity<T> handleServiceException(E ex) {
        printException(ex);
        printFailedResponse(new ResponseDefault());
        return ResponseCreator.failedResponse((T) new ResponseDefault(), ex);
    }

    @ExceptionHandler(Exception.class)
    protected <T extends ResponseDefault> ResponseEntity<T> handleException(Exception ex) {
        printException(ex);
        printFailedResponse(new ResponseDefault());
        return ResponseCreator.failedResponse((T) new ResponseDefault(), ex);
    }

    private void printFailedResponse(ResponseDefault responseDefault) {
        log.info("Failed Response returned");
        log.debug("Failed Response returned with data : {}", responseDefault.toString());
    }

    private <E> void printException(E ex) {
        log.info("Executing RestExceptionHandler.handleException");
        log.debug("Executing RestExceptionHandler.handleException for : {}", ex.getClass().getSimpleName());
        log.error("{} : ", ex.getClass().getSimpleName(), ex);
        log.info("Creating Failed Response for : {}", ex.getClass().getSimpleName());
    }
}
