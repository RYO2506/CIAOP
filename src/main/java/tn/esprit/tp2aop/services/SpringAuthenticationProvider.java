package tn.esprit.tp2aop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import tn.esprit.tp2aop.model.User;
@Component
@Qualifier("spring")
public class SpringAuthenticationProvider extends GenericAuthenticationProvider {

	@Override
	public List<User> getUsers() {
		return users;
	}

	@Override
	public void addUser(User user) {
		users.add(user);

	}

	@Override
	public void setUsers(List<User> users) {
		this.users = users;

	}

	
}
