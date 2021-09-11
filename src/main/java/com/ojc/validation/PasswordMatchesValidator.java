package com.ojc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ojc.model.UserEntity;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches,Object>{

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		UserEntity user=(UserEntity)value;
		
		
		String plainPassword = user.getPassword();
		String repeatPassword = user.getRepeatPassword();
		
		if(plainPassword == null || plainPassword.length() == 0) {
			return true;
		}
		
		if(plainPassword == null || !plainPassword.equals(repeatPassword)) {
			return false;
		}
			
		return true;
	}

}
