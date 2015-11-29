package tn.esprit.tp2aop.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import tn.esprit.tp2aop.model.Role;
import tn.esprit.tp2aop.model.User;

@Component
@Qualifier("mock")
public class MockAuthenticationProvider extends GenericAuthenticationProvider {

	public MockAuthenticationProvider() {
		User user1 = new User("aziz", "azizPassword");
		user1.setRoles(new ArrayList<Role>());
		user1.getRoles().add(new Role("Administrateur"));
		user1.getRoles().add(new Role("simpleUser"));
		User user2 = new User("achref", "achrefPassword");
		user2.setRoles(new ArrayList<Role>());
		user2.getRoles().add(new Role("simpleUser"));
		setUsers(new ArrayList<User>());
		getUsers().add(user1);
		getUsers().add(user2);
	}

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
