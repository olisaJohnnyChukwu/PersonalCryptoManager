package com.ojc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ojc.model.CustomerUserDetails;
import com.ojc.model.UserEntity;

public class CustomUserService implements UserDetailsService {
	
	@Autowired
	IUserService userService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity user=userService.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomerUserDetails(user);
	}

}
