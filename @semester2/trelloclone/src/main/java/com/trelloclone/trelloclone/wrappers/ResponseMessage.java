package com.trelloclone.trelloclone.wrappers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseMessage {
    public static ResponseEntity success(){
        return buildHttpReponse(HttpStatus.OK, null, null);

    }

    public static ResponseEntity success(String message){
        return buildHttpReponse(HttpStatus.OK, message, null);
    }

    public static ResponseEntity success(String message, Object data){
        return buildHttpReponse(HttpStatus.OK, message, data);
    }
    public static ResponseEntity success(Object data){
        return buildHttpReponse(HttpStatus.OK, null, data);
    }

    public static ResponseEntity notFound(){
        return buildHttpReponse(HttpStatus.NOT_FOUND, null, null);
    }
    public static ResponseEntity notFound(String message){
        return buildHttpReponse(HttpStatus.NOT_FOUND, message, null);
    }

    private static HashMap<String,Object> buildHttpMessage(HttpStatus status, String message,Object data){

        HashMap<String,Object> httpResponse = new HashMap<>();
        String httpResponseMessage
                = message != null
                ? message:
                status.getReasonPhrase();
        httpResponse.put("message", httpResponseMessage);
        httpResponse.put("status", status.value());

        if (data!= null){
            httpResponse.put("collection",data);
        }

        return httpResponse;
    }

    private static  ResponseEntity buildHttpReponse(HttpStatus status, String message,Object data){
        var httpResponse = buildHttpMessage(status, message, data);

        return ResponseEntity.status(status).body(httpResponse);
    }

}
