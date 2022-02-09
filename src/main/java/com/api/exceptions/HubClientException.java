package com.api.exceptions;

public class HubClientException extends Exception{
	private Exception e;
	
	public HubClientException() {}
	
	public HubClientException(Exception e) {
		this.e = e;
	}

}
