package org.akceptor.ijournal.dao;

import java.util.List;
import org.akceptor.ijournal.domain.User;


public interface UserDAO {
	public void addUser(User user);
	public void updateUser(User user);
	public void delete(User user);
	public User getUserByName(String username);
	public List<User> findUsers();
}