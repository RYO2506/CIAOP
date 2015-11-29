package tn.esprit.tp2aop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import tn.esprit.tp2aop.contracts.AuthenticationProvider;
import tn.esprit.tp2aop.contracts.Authenticator;
import tn.esprit.tp2aop.model.User;

@Component
public class AuthenticatorAgent implements Authenticator {

	@Autowired
	@Qualifier("spring")
	private AuthenticationProvider provider;

	@Override
	public boolean authenticate(String username, String password) {
		int i = 1/0;
		for (User user : provider.getUsers()) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;

	}

	public AuthenticationProvider getProvider() {
		return provider;
	}

	public void setProvider(AuthenticationProvider provider) {
		this.provider = provider;
	}

}
