package com.hcl.empparking.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	private String code;
}
