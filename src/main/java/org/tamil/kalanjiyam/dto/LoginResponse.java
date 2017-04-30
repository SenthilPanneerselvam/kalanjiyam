package org.tamil.kalanjiyam.dto;

import java.io.Serializable;

import org.tamil.kalanjiyam.core.GenericResponse;
/**
 * 
 * @author Senthil Panneerselvam
 *
 */
public class LoginResponse extends GenericResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4673564464144478684L;

	private User user;
	
	private String token;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
