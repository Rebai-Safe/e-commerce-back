package com.ecommerce.beans;

/**
 * This bean is used to represent a response of a HTTP web service
 * @param <T> Object Type.
 */
public class Response<T> {
    private T object;
    private String message;
    private int code;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
