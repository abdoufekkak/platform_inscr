package com.app.webExeption;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.exception.ErreurMessage;
import com.app.exception.Exception500;


@RestControllerAdvice
public class WebException500 {
	@ExceptionHandler(value={Exception500.class})
	   public  ResponseEntity<Object> erreur404(Exception500 exception500){ 
		   ErreurMessage erreurMessage= new ErreurMessage(new Date(),exception500.getMessage(),500);
		   return new ResponseEntity<Object>(erreurMessage,HttpStatus.FOUND);};
}
