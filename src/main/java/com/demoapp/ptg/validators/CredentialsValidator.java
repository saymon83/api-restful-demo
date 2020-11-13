package com.demoapp.ptg.validators;

import static com.demoapp.ptg.validators.ValidatorUtil.isVaildString;
import static com.demoapp.ptg.validators.ValidatorUtil.isValidPassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demoapp.ptg.exceptions.InvalidCredentialsException;
import com.demoapp.ptg.exceptions.MissingFieldsException;
import com.demoapp.ptg.models.User;
import com.demoapp.ptg.repositories.UserRepository;
import com.demoapp.ptg.security.Credentials;


@Component
public class CredentialsValidator implements Validator<Credentials> {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void validate(Credentials model) throws Exception {
		Validator.super.validate(model);
		this.validateRegisteredFields(model);
	}

	@Override
	public void validateRequiredFields(Credentials model) throws Exception {

		if (!isVaildString(model.getEmail())) throw new MissingFieldsException();
		
		if (!isVaildString(model.getPassword())) throw new MissingFieldsException();
	}

	@Override
	public void validateFieldsValues(Credentials model) throws Exception {}

	@Override
	public void validateUniqueFields(Credentials model) throws Exception {}
	
	public void validateRegisteredFields(Credentials model) throws Exception {
		
		User user = userRepository.findByEmail(model.getEmail());
		
		if (user == null) throw new InvalidCredentialsException();
		
		if (!isValidPassword(model.getPassword(), user.getPassword())) throw new InvalidCredentialsException(); 
	}

}
