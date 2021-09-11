package com.ojc.Service;

import com.ojc.exception.UserAlreadyExistException;
import com.ojc.model.UserEntity;

public interface IUserService {
	UserEntity register(UserEntity user) throws UserAlreadyExistException;

	UserEntity findByEmail(String email);
}
