package com.app.WebException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.Exception.ErreurMessage;
import com.app.Exception.Exception404;

public class webException4044 {
	@ExceptionHandler(value= {Exception404.class})
	   public  ResponseEntity<Object> erreur404(Exception404 exception404){ 
		   ErreurMessage erreurMessage= new ErreurMessage(new Date(),exception404.getMessage(),404);
		   return new ResponseEntity<Object>(erreurMessage,HttpStatus.NOT_FOUND);};
	}