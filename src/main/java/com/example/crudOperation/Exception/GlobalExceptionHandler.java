package com.example.crudOperation.Exception;

import com.example.crudOperation.Helper.ApiResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** @createdBy - Ashwini Bhagat **/

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ApiResponce> resourceNotFoundHandler(ResourceNotFoundException ex)
    {
        String message=ex.getMessage();
        ApiResponce responce= new ApiResponce();
        responce.setMessage(message);
        return  new ResponseEntity<>(responce, HttpStatus.BAD_REQUEST);
    }
}
