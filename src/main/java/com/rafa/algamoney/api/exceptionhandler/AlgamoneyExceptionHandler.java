package com.rafa.algamoney.api.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AlgamoneyExceptionHandler extends ResponseEntityExceptionHandler	{
	
	@Autowired
	private MessageSource source; //Para acessar o messages.properties
	
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String mensagemUsuario = source.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale() );
		String mensagemDev = ex.getCause().toString();
		
		return handleExceptionInternal(ex, new Erro(mensagemUsuario, mensagemDev), headers, HttpStatus.BAD_REQUEST, request);
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
