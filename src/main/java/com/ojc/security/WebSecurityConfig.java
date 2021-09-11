package com.ojc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ojc.Service.CustomUserService;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(authenticationProvider());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/","/login","/registration").permitAll()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/failedLogin");
	}
	
	
	@Bean
	public UserDetailsService UserDetailService() {
		
		return new CustomUserService();
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncorder() {
		return new BCryptPasswordEncoder();
		
	}
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(passwordEncorder());
		authProvider.setUserDetailsService(UserDetailService());
		
		return authProvider;
		
		
		
	}
	

}
