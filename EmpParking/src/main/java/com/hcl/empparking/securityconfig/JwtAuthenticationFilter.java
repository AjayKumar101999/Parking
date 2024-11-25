//package com.hcl.empparking.securityconfig;
//
//import java.io.IOException;
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.security.SignatureException;
//import jakarta.annotation.Resource;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//
//@Component
//@Slf4j
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//	
//	@Autowired
//    private JwtTokenUtils jwtUtils;
//
//
//    private UserDetailsService userDetailsService;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//
//		String requestHeader = request.getHeader(Constants.HEADER);
//		log.info(" Header :  {}", requestHeader);
//		String username = null;
//		String token = null;
//		if (requestHeader != null && requestHeader.startsWith(Constants.TOKEN_PREFIX)) {
//			// looking good
//			token = requestHeader.substring(7);
//			try {
//				username = jwtUtils.getUsernameFromToken(token);
//
//			} catch (IllegalArgumentException e) {
//				log.info("Illegal Argument while fetching the username !!");
//				e.printStackTrace();
//			} catch (ExpiredJwtException e) {
//				log.info("Given jwt token is expired !!");
//				e.printStackTrace();
//			} catch (SignatureException e) {
//				log.info("Authentication Failed, Username or Password not valid!!");
//				e.printStackTrace();
//			}
//		} else {
//			log.info("Invalid Header Value !! ");
//		}
//		
//		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//			Boolean validateToken = jwtUtils.validateToken(token, userDetails);
//			if (validateToken) {
//				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//						userDetails, null, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
//				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				SecurityContextHolder.getContext().setAuthentication(authentication);
//			} else {
//				log.info("Validation fails !!");
//			}
//		}
//		filterChain.doFilter(request, response);
//
//	}
//}
