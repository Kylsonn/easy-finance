package com.kbsystems.finance.service.exception;

import org.springframework.http.HttpStatus;

public class ResourceAlreadyExistsException extends ResourceException {
	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExistsException(HttpStatus status, String code, String resource) {
		super(status, code, resource);
	}

}
