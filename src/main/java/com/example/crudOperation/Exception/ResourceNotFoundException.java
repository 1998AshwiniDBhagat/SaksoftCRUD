package com.example.crudOperation.Exception;

import lombok.Getter;
import lombok.Setter;

/** @createdBy - Ashwini Bhagat **/

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
