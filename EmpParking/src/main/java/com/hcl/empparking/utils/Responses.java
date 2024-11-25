package com.hcl.empparking.utils;

public interface Responses {

	/**
	 * Success Codes
	 */
	String EMP_PARKING_REQUEST_INSERTED = "SC1001";
	String EMP_PARKING_REQUEST_INSERTED_MSG = "Employee parking spot request Inserted successfully";

	/**
	 * Exception Codes
	 */
	String VALIDATION_ERROR_CODE = "EX1001";
	String EMP_NOT_FOUND_CODE = "EX1002";
	String EMP_NOT_FOUND_MESSAGE = "Employee not Found";
	String EMP_DATA_NOT_INSERTED = "EX1003";
	String EMP_DATA_NOT_INSERTED_MSG = "Employee not Found";
	String EMP_ALREADY_HAVE_PARKING_CODE = "EX1004";
	String EMP_ALREADY_HAVE_PARKING_MSG = "Employee already have the parking spot";
	String EMP_ALREADY_REQUESTED_CODE = "EX1005";
	String EMP_ALREADY_REQUESTED_MSG = "Employee already requested for the parking spot";

}
