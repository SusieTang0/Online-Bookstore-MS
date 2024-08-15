package com.johnabbott.OnlineBookstoreMS.security;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BookStoreSecurityConfig {
	
	// hardcode for test securityConfig
	/*@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails john = User.builder()
				.username("john")
				.password("{noop}book123")
				.roles("CUSTOMER")
				.build();
		
		UserDetails mary = User.builder()
				.username("mary")
				.password("{noop}book123")
				.roles("CUSTOMER")
				.build();
		
		UserDetails susan = User.builder()
				.username("susan")
				.password("{noop}book123")
				.roles("EMPLOYEE")
				.build();
		
		return new InMemoryUserDetailsManager(john,mary,susan);
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {	
		
		http
			.authorizeHttpRequests(configurer ->
				configurer
					.requestMatchers("/showMyLoginPage", "/access-denied").permitAll()
					
                	.anyRequest().authenticated()
		)
		
				.formLogin(form ->
					form
						.loginPage("/showLoginPage")
					    .loginProcessingUrl("/authenticateTheUser")
					    .permitAll()
					    
				)
		
			.logout(logout -> logout.permitAll()
			)
			
			.exceptionHandling(configurer ->
					configurer.accessDeniedPage( "/accessDenied")
			);
		
		return http.build();
	
	}*/
	
	//  以下内容是连接数据库的代码
	@Bean
	public UserDetailsManager userdetailsManager(DataSource dataSource) {
		
		return new JdbcUserDetailsManager(dataSource);
	}
	
	
	@Bean
	public SecurityFilterChain  filterChain(HttpSecurity http) throws Exception {	
		http.authorizeHttpRequests(configurer ->
				configurer
						.requestMatchers("/images/**").permitAll() 
						.requestMatchers("/index").hasAnyRole("EMPLOYEE","CUSTOMER")
						.requestMatchers("/books/list").hasAnyRole("EMPLOYEE","CUSTOMER")
						.requestMatchers("/books/**").hasRole("EMPLOYEE")	
						.requestMatchers("/purchases/**").hasRole("CUSTOMER")
						.requestMatchers("/cart/**").hasRole("CUSTOMER")
						.anyRequest().authenticated()
						
		)
				.formLogin(form ->
					form
						.loginPage("/showLoginPage")
					    .loginProcessingUrl("/authenticateTheUser")
					    .permitAll()
					    
				)
		
			.logout(logout -> logout.permitAll()
			)
			
			.exceptionHandling(configurer ->
					configurer.accessDeniedPage("/access-denied")
			);
		
		return http.build();
			
	}
	

}
