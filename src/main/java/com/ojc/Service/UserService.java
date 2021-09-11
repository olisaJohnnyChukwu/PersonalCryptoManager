package com.ojc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojc.exception.UserAlreadyExistException;
import com.ojc.model.UserEntity;
@Service
public class UserService  implements IUserService{
	@Autowired
	com.ojc.repository.UserRepository UserRepository ;
	@Override
	public UserEntity register(UserEntity user) throws UserAlreadyExistException {
		// TODO Auto-generated method stub
		
		if(emailExists(user.getEmail())) {
			throw new UserAlreadyExistException(user.getEmail());
		}else {
			UserRepository.save(user);
		}
		return user;
		
	}
	private boolean emailExists(String email) {
		// TODO Auto-generated method stub
		return UserRepository.findByEmail(email)!=null;
	}
	@Override
	public UserEntity findByEmail(String email) {
		// TODO Auto-generated method stub
		return UserRepository.findByEmail(email);
	}

}
