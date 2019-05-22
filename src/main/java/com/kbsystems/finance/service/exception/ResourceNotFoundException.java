package com.kbsystems.finance.service.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ResourceException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String resource) {
		super(HttpStatus.BAD_REQUEST, "resource_not_found", resource);
	}

}
