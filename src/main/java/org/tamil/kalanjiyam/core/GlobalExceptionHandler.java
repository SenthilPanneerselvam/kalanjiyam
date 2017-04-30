package org.tamil.kalanjiyam.core;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Global Exception Handler
 * 
 * @author Senthil Panneerselvam
 * 
 */
@ControllerAdvice
public class GlobalExceptionHandler
{

	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public void handleAllException(HttpServletResponse response, Exception ex)
	{
			LOG.error("An Internal Error occured", ex);
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public @ResponseBody GenericResponse handleMethodNotSupported(HttpServletResponse response, HttpRequestMethodNotSupportedException ex) {
			LOG.error("Requested Service Does not support the HTTP Method specified!", ex);
			
			final GenericResponse responseBody = new GenericResponse();
			responseBody.addError(ex.getMessage());
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			return responseBody;
			
	}
	
	@ExceptionHandler(AppException.class)
	public @ResponseBody
	GenericResponse handleCustomException(HttpServletResponse response, AppException ex)
	{
		final GenericResponse responseBody = new GenericResponse();
		responseBody.addError(ex.getAppErrCode());
		response.setStatus(ex.getHttpErrCode().value());
		return responseBody;
	}
	
}