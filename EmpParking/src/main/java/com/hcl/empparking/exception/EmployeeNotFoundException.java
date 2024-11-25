package com.hcl.empparking.exception;

import com.hcl.empparking.utils.Responses;

public class EmployeeNotFoundException extends GlobalException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message) {
		super(message, GlobalErrorCode.ERROR_RESOURCE_NOT_FOUND);
	}

	public EmployeeNotFoundException() {
		super(Responses.EMP_NOT_FOUND_MESSAGE, GlobalErrorCode.ERROR_RESOURCE_NOT_FOUND);
	}

}
