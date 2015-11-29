package tn.esprit.tp2aop.contracts;

import java.util.List;

import tn.esprit.tp2aop.model.User;

public interface AuthenticationProvider {

	public void addUser(User user);

	public List<User> getUsers();

	public void setUsers(List<User> users);
}
