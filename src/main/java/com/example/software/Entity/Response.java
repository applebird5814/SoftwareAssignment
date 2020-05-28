package com.example.software.Entity;

public class Response {

    private final boolean success;
    private final String message;


    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Response(boolean success) {
        this.success = success;
        this.message = "";
    }
}
