package com.app.webException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.exception.ErreurMessage;
import com.app.exception.Exception404;
@RestControllerAdvice
public class WebException404 {
	@ExceptionHandler(value=Exception404.class)
   public  ResponseEntity<Object> erreur404(Exception404 exception404){ 
	   ErreurMessage erreurMessage= new ErreurMessage(new Date(),exception404.getMessage(),404);
	   return new ResponseEntity<Object>(erreurMessage,HttpStatus.NOT_FOUND);};
}
