//package com.hcl.empparking.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.hcl.empparking.dtos.JwtRequest;
//import com.hcl.empparking.dtos.JwtResponse;
//import com.hcl.empparking.entity.Employee;
//import com.hcl.empparking.repository.EmployeeRepo;
//import com.hcl.empparking.securityconfig.JwtTokenUtils;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("/auth")
//@RequiredArgsConstructor
//public class AuthController {
//
//	private final AuthenticationManager manager;
//
//	private final JwtTokenUtils helper;
//	
//	private final EmployeeRepo employeeRepo;
//
//	private Logger logger = LoggerFactory.getLogger(AuthController.class);
//
//	@PostMapping("/login")
//	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
//
//		doAuthenticate(request.getUsername(), request.getPassword());
//		Employee emp = employeeRepo.findByEmpName(request.getUsername()).get();
//		String token = helper.generateToken(emp);
//		JwtResponse jwtResponse = new JwtResponse();
//		jwtResponse.setJwtToken(token);
//		jwtResponse.setUsername(emp.getEmpName());
//		return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
//	}
//
//	private void doAuthenticate(String email, String password) {
//
//		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
//		try {
//			manager.authenticate(authentication);
//
//		} catch (BadCredentialsException e) {
//			throw new BadCredentialsException(" Invalid Username or Password  !!");
//		}
//	}
//
//	@ExceptionHandler(BadCredentialsException.class)
//	public String exceptionHandler() {
//		return "Credentials Invalid !!";
//	}
//
//}
