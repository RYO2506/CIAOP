package tn.esprit.tp2aop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.tp2aop.contracts.AuthenticationProvider;
import tn.esprit.tp2aop.model.User;

public abstract class GenericAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	public List<User> users;
}
