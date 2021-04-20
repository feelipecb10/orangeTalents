package com.orange.talents.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.orange.talents.exception.DomainException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {	
		
		var campos = new ArrayList<ObjException.Campo>();
		
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) error).getField();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			campos.add(new ObjException.Campo(nome, mensagem));
		}
			
		var exception = new ObjException();
		exception.setStatus(status.value());
		exception.setTitulo("Um ou mais campos estão inválidos.");
		exception.setDataHora(LocalDateTime.now());
		exception.setCampos(campos);
		
		return super.handleExceptionInternal(ex, exception, headers, status, request);
	}
	
	@ExceptionHandler(DomainException.class)
	public ResponseEntity<Object> handleDomain(DomainException ex, WebRequest request) {
		
		var status = HttpStatus.BAD_REQUEST;
		
		var exception = new ObjException();
		exception.setStatus(status.value());
		exception.setTitulo(ex.getMessage());
		exception.setDataHora(LocalDateTime.now());
		
		return handleExceptionInternal(ex, exception, new HttpHeaders(), status, request);
	}

}
