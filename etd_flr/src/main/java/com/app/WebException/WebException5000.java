package com.app.WebException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.Exception.ErreurMessage;
import com.app.Exception.Exception500;

public class WebException5000 {
	@ExceptionHandler(value={Exception500.class})
	   public  ResponseEntity<Object> erreur404(Exception500 exception500){ 
		   ErreurMessage erreurMessage= new ErreurMessage(new Date(),exception500.getMessage(),500);
		   return new ResponseEntity<Object>(erreurMessage,HttpStatus.FOUND);};
}
