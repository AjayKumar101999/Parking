package com.hcl.empparking.dtos;

import lombok.Data;

@Data
public class JwtResponse {
	private String jwtToken;
	private String username;

}
