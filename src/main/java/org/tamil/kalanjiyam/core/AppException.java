package org.tamil.kalanjiyam.core;


import org.springframework.http.HttpStatus;

/**
 * Main exception class. This exception should be used to wrap other exceptions.
 * 
 * @author Senthil Panneerselvam
 * 
 */
public class AppException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	private String appErrCode;

	private HttpStatus httpErrCode = HttpStatus.INTERNAL_SERVER_ERROR;

	private String errMsg;

	public AppException(String message)
	{
		super(message);
	}

	/**
	 * 
	 * @param message
	 * @param causeException
	 */
	public AppException(String message, Exception causeException)
	{
		super(message, causeException);
	}

	/**
	 * @param exception
	 * @throws AppException
	 */
	public static void throwException(Exception exception) throws AppException
	{
		if(exception instanceof AppException)
		{
			throw (AppException) exception;
		}

		throw new AppException(exception.getMessage());
	}

	/**
	 * @param errCode
	 * @param errMsg
	 */
	public AppException(String errCode, String errMsg)
	{
		this.appErrCode = errCode;
		this.errMsg = errMsg;
	}
	
	public AppException(String errCode, HttpStatus status) {
		this.appErrCode = errCode;
		this.httpErrCode = status;
	}

	public AppException(String errCode, HttpStatus status, String errMsg)
	{
		this.appErrCode = errCode;
		this.errMsg = errMsg;
		this.httpErrCode = status;
	}

	public String getErrMsg()
	{
		return this.errMsg;
	}

	public void setErrMsg(String errMsg)
	{
		this.errMsg = errMsg;
	}

	public String getAppErrCode()
	{
		return this.appErrCode;
	}

	public void setAppErrCode(String appErrCode)
	{
		this.appErrCode = appErrCode;
	}

	public HttpStatus getHttpErrCode()
	{
		return this.httpErrCode;
	}

	public void setHttpErrCode(HttpStatus httpErrCode)
	{
		this.httpErrCode = httpErrCode;
	}

}
