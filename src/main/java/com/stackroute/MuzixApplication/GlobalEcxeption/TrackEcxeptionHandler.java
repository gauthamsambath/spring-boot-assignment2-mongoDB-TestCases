package com.stackroute.MuzixApplication.GlobalEcxeption;

import com.stackroute.MuzixApplication.CustomEcxeptions.EmpyFieldExeption;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TrackEcxeptionHandler {
    @ExceptionHandler
    public String handleInvalidFieldEcxeption(EmpyFieldExeption e)
        {
            return e.getMessage();
        }
}
