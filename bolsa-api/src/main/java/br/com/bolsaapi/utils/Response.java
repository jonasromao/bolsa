package br.com.bolsaapi.utils;

import java.io.Serializable;
import java.util.ArrayList;

public class Response implements Serializable {

	private static final long serialVersionUID = 1L;
	private Object data;
	private Boolean success = true;
	private ArrayList<String> messages = new ArrayList<String>();

	public Object getData() {
		return data;
	}

	public void setData( Object data ) {
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess( Boolean success ) {
		this.success = success;
	}

	public ArrayList<String> getMessages() {
		return messages;
	}

	public void setMessages( ArrayList<String> errors ) {
		this.messages = errors;
	}
}
