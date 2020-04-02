package com.rafa.algamoney.api.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AlgamoneyExceptionHandler extends ResponseEntityExceptionHandler	{
	
	@Autowired
	private MessageSource source; //Para acessar o messages.properties
	
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String mensagemUsuario = source.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale() );
		String mensagemDev = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario,mensagemDev));
		
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
		
		String mensagemUsuario = source.getMessage("recurso.nao.encontrado", null, LocaleContextHolder.getLocale() );
		String mensagemDev = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario,mensagemDev));
		
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {	
		
		List<Erro> erros = criarListaErros(ex.getBindingResult() );
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	
	private List<Erro> criarListaErros(BindingResult result) {
		List<Erro> erros = new ArrayList<>();
		for (FieldError error : result.getFieldErrors()) {
		
		String mensagemUsuario=source.getMessage(error, LocaleContextHolder.getLocale() );
		String mensagemDesenvolvedor = error.toString();
		erros.add(new Erro(mensagemUsuario, mensagemDesenvolvedor) );
		}
		
		return erros;
	}
	
	public static class Erro {
		
		private String msgUsuario;
		private String msgDev;
		
		public Erro(String msgUsuario, String msgDev)	{
			this.msgUsuario = msgUsuario;
			this.msgDev = msgDev;
		}

		public String getMsgUsuario()
		{
			return msgUsuario;
		}

		public String getMsgDev()
		{
			return msgDev;
		}
	}
	
}
