package com.springingdream.marketplace.collectors;


public class ApiResponse<T> {

    private Boolean success;
    private T body;

    public ApiResponse() {

    }

    public ApiResponse(Boolean success, T body) {
        this.success = success;
        this.body = body;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}