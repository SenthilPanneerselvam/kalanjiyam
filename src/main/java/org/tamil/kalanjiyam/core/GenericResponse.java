package org.tamil.kalanjiyam.core;


import java.util.ArrayList;
import java.util.List;

/**
 * The generic response which acts as the base class for all the responses being
 * sent to the clients.
 * 
 * @author senthil Panneerselvam
 * 
 */
public class GenericResponse
{
	private final List<String> errors;

	public GenericResponse()
	{
		this.errors = new ArrayList<String>();
	}

	public List<String> getErrors()
	{
		return this.errors;
	}

	public void addError(final String errorCode)
	{
		this.errors.add(errorCode);
	}

	public void clearErrors()
	{
		this.errors.clear();
	}

}
