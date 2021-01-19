package com.mservicetech.business.validation.exception;

public class BusinessValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String code;

    public BusinessValidationException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessValidationException(String code, String message,  Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }

}
