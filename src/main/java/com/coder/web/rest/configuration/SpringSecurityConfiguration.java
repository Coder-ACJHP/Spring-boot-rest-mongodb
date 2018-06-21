package com.coder.web.rest.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(inMemoryUserDetailsManager());
	 }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic().
		authenticationEntryPoint(authenticationEntryPoint);
		//Disable .crsf token
		http.csrf().disable();
	}
	
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		final Properties userList = new Properties();
		userList.put("user", "password,ROLE_USER,enabled");
		return new InMemoryUserDetailsManager(userList);
	}
	
	
}
