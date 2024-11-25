//package com.hcl.empparking.securityconfig;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import jakarta.annotation.Resource;
//
//@Configuration
//public class SecurityConfig {
//
////	@Autowired
////	private JwtAuthenticationEntryPoint point;
//	@Autowired
//	private JwtAuthenticationFilter filter;
//
//	@Resource(name = "empService")
//	private UserDetailsService userDetailsService;
//	
//	@Bean
//	AuthenticationManager getAuthenticationManager(AuthenticationConfiguration builder) throws Exception {
//		return builder.getAuthenticationManager();
//	}
//
//	@Autowired
//	void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
//	}
//	
//	@Bean
//	JwtAuthenticationFilter authenticationFilter() {
//		return new JwtAuthenticationFilter();
//	}
//
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
//				.authorizeHttpRequests(auth -> auth
//						.requestMatchers("/api/v1/**").authenticated()
//						.requestMatchers("/swagger-ui/index.html", "/auth/login").permitAll()
//						.anyRequest().authenticated())
////				.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
//				.formLogin(AbstractAuthenticationFilterConfigurer::permitAll);
//
//		return http.build();
//	}
//	@Bean
//	BCryptPasswordEncoder encoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//}
