package com.gmuguessr.backend;

public class RegistrationResult {

	private boolean success;
	private int id;
	
	public RegistrationResult() {
		this.success = false;
		this.id = -1;
	}
	
	public RegistrationResult(boolean success, int id) {
		this.success = success;
		this.id = id;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public int getUserId() {
		return id;
	}
}
