package com.waracle.api;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-12T11:39:55.360Z")

public class ApiException extends Exception {

    private final int code;

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
